package lambda;

public class Transaction {
	
	private Trader trader;
	private int year;
	private int value;
	/**
	 * @param trader
	 * @param year
	 * @param value
	 */
	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}
	/**
	 * @return the trader
	 */
	public Trader getTrader() {
		return trader;
	}
	/**
	 * @param trader the trader to set
	 */
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}
	
}
