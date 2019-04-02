package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Reader {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Employee employee = new Employee();
		try (FileInputStream fileInputStream = new FileInputStream("Employee.txt");
				ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)){
			employee = (Employee) inputStream.readObject();
			System.out.println(employee.toString());
			System.out.println(employee.getPhoneNo()+" phone no");
			System.out.println("File Read Successfully.");
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
