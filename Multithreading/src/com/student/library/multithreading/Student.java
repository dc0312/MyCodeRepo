package com.student.library.multithreading;

import java.util.Random;

public class Student implements Runnable{
    
    private int id;
    private Book [] books;
    
    public Student(int id,Book [] books) {
        this.id = id;
        this.books = books;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        while(true) {
            int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
            try {
                books[bookId].read(this);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public String toString() {
        return "Student "+id;
    }

}
