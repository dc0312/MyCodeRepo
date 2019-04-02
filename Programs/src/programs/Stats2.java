package programs;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Stats2 {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		
		Map<String,List<Double>> symbolMap = new HashMap<String,List<Double>>();
		@Override
		public void putNewPrice(String symbol, double price) {
		    if(symbolMap.containsKey(symbol)) {
		    	symbolMap.get(symbol).add(price);
		    }else {
		    	List<Double> priceList = new ArrayList<>();
		    	priceList.add(price);
		    	symbolMap.put(symbol, priceList);
		    }
		    
		// YOUR CODE HERE
		}

		@Override
		public double getAveragePrice(String symbol) {
		// YOUR CODE HERE
			double averagePrice = 0.0;
			int count=0;
			for (String symbolKey : symbolMap.keySet()) {
				if(symbolKey.equals(symbol)) {
					count = symbolMap.get(symbolKey).size();
					averagePrice = symbolMap.get(symbolKey).stream()
							. mapToDouble(p -> p).sum();
				}
			}
			return averagePrice/count;
		}

		@Override
		public int getTickCount(String symbol) {
		// YOUR CODE HERE
			int count=0;
			for (String symbolKey : symbolMap.keySet()) {
				if(symbolKey.equals(symbol)) {
					count = symbolMap.get(symbolKey).size();
				}
			}
			return count;
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