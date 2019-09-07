package com.dc.multithreading.immutable;

public class Main {

    public static void main(String[] args) {
        SimpleImmutableStudent simpleImmutableStudent = new SimpleImmutableStudent(1,"Deepak");

        System.out.println(simpleImmutableStudent.getId());
        System.out.println(simpleImmutableStudent.getName());
    }
}
