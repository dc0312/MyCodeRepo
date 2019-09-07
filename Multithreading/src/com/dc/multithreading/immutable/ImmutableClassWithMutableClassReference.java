package com.dc.multithreading.immutable;
class Age{
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Age :" + day + "-"+month + "-" +year;
    }
}
final class ImmutableStudent{
    private final int id;
    private final String name;
    //here we add mutable Age class.
    /*If the class holds a mutable object:
    1. Inside the constructor, make sure to use a clone copy of the passed argument
    and never set your mutable field to the real instance passed through constructor,
    this is to prevent the clients who pass the object from modifying it afterwards.
    2. Make sure to always return a clone copy of the field and never return the real object instance.*/
    private final Age age;

    //Shallow cloning
   /* public ImmutableStudent(int id, String name, Age age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }*/
    //Deep cloning
    public ImmutableStudent(int id, String name, Age age) {
        this.id = id;
        this.name = name;

        Age clonedAge = new Age();
        clonedAge.setDay(age.getDay());
        clonedAge.setMonth(age.getMonth());
        clonedAge.setYear(age.getYear());

        this.age = clonedAge;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Make sure to always return a clone copy of the field and never return the real object instance.
    public Age getAge() {
        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setMonth(this.age.getMonth());
        cloneAge.setYear(this.age.getYear());
        return cloneAge;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class ImmutableClassWithMutableClassReference {

    public static void main(String[] args) {
        Age age = new Age();
        age.setDay(03);
        age.setMonth(12);
        age.setYear(1992);
        ImmutableStudent immutableStudent = new ImmutableStudent(1,"Deepak",age);

        System.out.println(immutableStudent);

        age.setYear(1993);

        System.out.println(immutableStudent);
        //Make sure to always return a clone copy of the field and never return the real object instance.
        immutableStudent.getAge().setYear(1993);

        System.out.println(immutableStudent);

    }

}
