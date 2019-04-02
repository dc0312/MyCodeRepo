package cloning.example;

import java.util.*;
class Address implements Cloneable{
	private String city;
	final String pincode = "560057";

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	

	@Override
	public Address clone() throws CloneNotSupportedException{
		return (Address) super.clone();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}
	
	
	
	
}
class Student implements Cloneable {
	private String name;
	private int rollNo;
	private ArrayList<String> subjects;
	private Address address;

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
	 * @return the rollNo
	 */
	public int getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * @return the subjects
	 */
	public ArrayList<String> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(ArrayList<String> subjects) {
		this.subjects = subjects;
	}
	
	
	
	//shallow cloning
		/*@Override
		public Student clone() throws CloneNotSupportedException {
			Student clonedStudent = (Student) super.clone();
			return clonedStudent;

		}*/

	
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	//deep cloning
	@Override
	public Student clone() throws CloneNotSupportedException {
		Student clonedStudent = (Student) super.clone();
		//deep  long for Mutable ArrayList
		ArrayList<String> cloneSubjects = (ArrayList<String>) subjects.clone();
		clonedStudent.subjects = cloneSubjects;
		//deep cloning for mutable Address object
		clonedStudent.address = this.address.clone();
		return clonedStudent;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", subjects=" + subjects + ", address=" + address + "]";
	}

	

}

public class Cloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		Address address = new Address();
		address.setCity("Fatehgarh");
		
		Student student = new Student();
		
		ArrayList<String> subjects = new ArrayList<>();
		subjects.add("Hindi");
		student.setName("Deepak");
		student.setRollNo(3);
		student.setSubjects(subjects);
		student.setAddress(address);
		System.out.println("Before Changes");
		System.out.println(student.toString());

		Student clonedStudent = student.clone();

		System.out.println(clonedStudent.toString());
		System.out.println("After Changes");
		clonedStudent.setName("Aditya");
		clonedStudent.getSubjects().add("English");
		clonedStudent.getAddress().setCity("Farrukhabad");
		//final modifier we cannt clone.
		//clonedStudent.getAddress().pincode= "100";

		System.out.println(student.toString());
		System.out.println(clonedStudent.toString());
	}

}
