package lambda;

/**
 * @author deechaturvedi
 *
 */
public class Trader {
	
	private String name;
	private String city;
	
	
	/**
	 * @param name
	 * @param city
	 */
	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trader [name=" + this.name + ", city=" + this.city + "]";
	}
	
	

}
