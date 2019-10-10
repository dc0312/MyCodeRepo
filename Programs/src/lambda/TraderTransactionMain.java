package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TraderTransactionMain {
	
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
		
		List<Transaction> transaction2011 = transactions.stream()
													.filter(t -> t.getYear()==2011)
													.sorted(Comparator.comparing(Transaction::getValue))
													.collect(Collectors.toList());
		System.out.println(transaction2011);
		
		List<String> cities = transactions.stream()
										.map(t -> t.getTrader().getCity())
										.distinct()
										.collect(Collectors.toList());
		System.out.println(cities);
		
		List<Trader> camTraders = transactions.stream()
											.map(Transaction::getTrader)
											.filter(t -> t.getCity().equals("Cambridge"))
											.distinct()
											.sorted(Comparator.comparing(Trader::getName))
											.collect(Collectors.toList());
		
		System.out.println(camTraders);
		
		String traderName = transactions.stream()
												.map(t -> t.getTrader().getName())
												.distinct()
												.sorted()
												.reduce("", (n1,n2) -> n1 + n2+",");
		
		System.out.println(traderName);
		
		Boolean istraderMilan = transactions.stream()
										.anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(istraderMilan);
		
		String traderMilan = transactions.stream()
										.filter(t -> t.getTrader().getCity().equals("Milan"))
										.map(t->t.getTrader().getName())
										.distinct()
										.collect(Collectors.joining());
		System.out.println(traderMilan);
	}

}
