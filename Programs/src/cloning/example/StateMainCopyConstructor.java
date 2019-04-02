package cloning.example;

import java.util.ArrayList;
import java.util.List;
class People{
	private String name;
	private String gender;
	
	People(){
		
	}
	
	People(People p){
		this.name = p.name;
		this.gender = p.gender;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "People [name=" + name + ", gender=" + gender + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
class State{
	private String name;
	private String capital;
	private List<String> cities;
	private People people;
	
	public State() {
		
	}
	public State(State st) {
		this.name = st.name;
		this.capital = st.capital;
		List<String> cities = new ArrayList<>();
		for (String city : st.cities) {
			cities.add(city);
		}
		this.cities=cities;
		//this.people = st.people;//shallow cloning;
		this.people = new People(st.people);//deep Cloning
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}
	/**
	 * @param capital the capital to set
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}
	/**
	 * @return the cities
	 */
	public List<String> getCities() {
		return cities;
	}
	/**
	 * @param cities the cities to set
	 */
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	
	
	/**
	 * @return the people
	 */
	public People getPeople() {
		return people;
	}
	/**
	 * @param people the people to set
	 */
	public void setPeople(People people) {
		this.people = people;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((people == null) ? 0 : people.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (cities == null) {
			if (other.cities != null)
				return false;
		} else if (!cities.equals(other.cities))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (people == null) {
			if (other.people != null)
				return false;
		} else if (!people.equals(other.people))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "State [name=" + name + ", capital=" + capital + ", cities=" + cities + ", people=" + people + "]";
	}
	
	
	
	
	
}

public class StateMainCopyConstructor {
	public static void main(String[] args) {
		State state = getState(); 
		System.out.println(state.toString());
		State clonedState = new State(state);
		clonedState.getCities().add("Varanasi");
		clonedState.getPeople().setName("Aditya");
		System.out.println(state.toString());
		System.out.println(clonedState.toString());
	}
	
	private static State getState() {
		State state = new State();
		People people = new People();
		people.setGender("Male");
		people.setName("Deepak");
		List<String> cities = new ArrayList<>();
		cities.add("Fatehgarh");
		cities.add("Farrukhabad");
		
		state.setCapital("Lucknow");
		state.setName("UP");
		state.setCities(cities);
		state.setPeople(people);
		return state;
	}
}
