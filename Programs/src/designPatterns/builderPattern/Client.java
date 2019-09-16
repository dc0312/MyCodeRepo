package designPatterns.builderPattern;

import java.time.LocalDate;

//This is our client which also works as "director"
public class Client {

	public static void main(String[] args) {

		User user = createUser();
		UserDTOBuilder builder = new UserWebDTOBuilder();

		UserDTO dto = directBuild(builder,user);

		System.out.println(dto);
		
	}

	private static UserDTO directBuild(UserDTOBuilder builder,User user){
		return builder.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withBirthday(user.getBirthday())
				.withAddress(user.getAddress())
				.build();

	}
	
	/**
	 * Returns a sample user. 
	 */
	public static User createUser() {
		User user = new User();
		user.setBirthday(LocalDate.of(1992	, 12, 03));
		user.setFirstName("Deepak");
		user.setLastName("Chaturvedi");
		Address address = new Address();
		address.setHouseNumber("101");
		address.setStreet("Sreeja Fantasy");
		address.setCity("Bangalore");
		address.setState("India");
		address.setZipcode("560037");
		user.setAddress(address);
		return user;
	}
}
