package com.dc.studenttab;

import com.dc.studenttab.dao.entities.Customer;
import com.dc.studenttab.dao.entities.Student;
import com.dc.studenttab.dao.repository.CustomerRepository;
import com.dc.studenttab.dao.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationTests {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testCreateStudent() {

		Student student = new Student();
		student.setId(1l);
		student.setName("John");
		student.setCourse("Java Web Services");
		student.setFee(30d);

		studentRepository.save(student);

	}

	@Test
	public void testGetStudent(){
		Optional<Student> optionalStudent = studentRepository.findById(1l);

		if(optionalStudent.isPresent()){
			System.out.println(optionalStudent.get());
		}
	}

	@Test
	public void updateStudent(){
		Optional<Student> optionalStudent = studentRepository.findById(1l);

		if(optionalStudent.isPresent()){
			Student student = optionalStudent.get();
			student.setFee(40d);
			studentRepository.save(student);
		}
	}

	@Test
	public void deleteStudent(){
		studentRepository.deleteById(1l);
	}

	@Test
	public void createCustomer(){
		Customer customer = new Customer();
		//customer.setId(1l);
		customer.setName("Deepak");
		customer.setEmail("dc@dc.com");
		customerRepository.save(customer);
	}

	@Test
	public void findCustomer(){
		Optional<Customer> optionalCustomer = customerRepository.findById(1l);
		if(optionalCustomer.isPresent()){
			Customer customer = optionalCustomer.get();
			System.out.println(customer);
		}
	}

	@Test
	public void updateCustomer(){
		Optional<Customer> optionalCustomer = customerRepository.findById(1l);
		if(optionalCustomer.isPresent()){
			Customer customer = optionalCustomer.get();
			customer.setName("Deepak Chaturvedi");
			customerRepository.save(customer);
		}
	}

	@Test
	public void deleteCustomer(){
		customerRepository.deleteById(2l);
	}

}
