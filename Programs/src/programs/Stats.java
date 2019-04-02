package programs;
import java.util.*;
import java.util.concurrent.*;

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		
		class A {
			int count;
			double price;
			/**
			 * @return the count
			 */
			public int getCount() {
				return count;
			}
			/**
			 * @return the price
			 */
			public double getPrice() {
				return price;
			}
			/**
			 * @param count the count to set
			 */
			public void setCount(int count) {
				this.count = count;
			}
			/**
			 * @param price the price to set
			 */
			public void setPrice(double price) {
				this.price = price;
			}
		}

		Map<String,A> symbolMap = new HashMap<String,A>();
		@Override
		public void putNewPrice(String symbol, double price) {
		    if(symbolMap.containsKey(symbol)) {
		    	int tempCount = symbolMap.get(symbol).getCount() + 1;
		    	double averagePrice = (symbolMap.get(symbol).getPrice() * symbolMap.get(symbol).getCount() + price)/tempCount; 
		    	symbolMap.get(symbol).setPrice(averagePrice);
		    	symbolMap.get(symbol).setCount(tempCount);
		    }else {
		    	A a = new A();
		    	a.setCount(1);
		    	a.setPrice(price);
		    	symbolMap.put(symbol, a);
		    }
		    
		   // average price calculate and enter
		// YOUR CODE HERE
		}

		@Override
		public double getAveragePrice(String symbol) {
			return symbolMap.get(symbol).getPrice();
		// YOUR CODE HERE
		}

		@Override
		public int getTickCount(String symbol) {
			return symbolMap.get(symbol).getCount();
		// YOUR CODE HERE
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);
            
		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}