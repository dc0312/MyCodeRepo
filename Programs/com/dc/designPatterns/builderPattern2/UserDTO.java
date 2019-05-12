package Programs.com.dc.designPatterns.builderPattern2;

import java.time.LocalDate;
import java.time.Period;

public class UserDTO {

    private String name;

    private String address;

    private String age;

    UserDTO(String name, String address, String age){
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static UserDTOBuilder getBuiler(){
        return new UserDTOBuilder();
    }

    //Inner Static class for creating UserDTOBuilder
    public static class UserDTOBuilder{

        private String firstName;

        private String lastName;

        private String address;

        private String age;

        private UserDTO userDTO;

        public UserDTOBuilder withFirstName(String fName){
            firstName = fName;
            return this;
        }

        public UserDTOBuilder withLastName(String lName){
            lastName = lName;
            return this;
        }

        public UserDTOBuilder withAddress(Address address){
            this.address = address.getHouseNumber()+","+address.getStreet()+
                    "\n"+address.getCity()+
                    "\n"+address.getState() + " " +address.getZipcode();
            return this;
        }

        public UserDTOBuilder withBirthDay(LocalDate birthDay){
            Period period = Period.between(birthDay,LocalDate.now());
            age = String.valueOf(period.getYears());
            return this;
        }

        public UserDTO build(){
            return new UserDTO(firstName+" "+lastName,address,age);
        }

        public UserDTO getUserDTO(){
            return this.userDTO;
        }
    }
}
