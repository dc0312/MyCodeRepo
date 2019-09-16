package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
	
	public static void main(String[] args) {
		Employee1 employee = new Employee1();
		employee.setGender("Male");
		employee.setName("Deepak");
		employee.setPassword("12345");
		employee.setPhoneNo("1234567890");
		
		try (FileOutputStream output = new FileOutputStream("Employee.txt");
				ObjectOutputStream oos = new ObjectOutputStream(output)){
			oos.writeObject(employee);
			System.out.println("Written Successfully.");
		} catch (IOException e) {
			System.out.println("File not written Successfully");
		}
	}

}
