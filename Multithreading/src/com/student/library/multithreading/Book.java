package com.student.library.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

    private int id;
    private Lock lock;

    public Book(int id) {
        this.id = id;
        lock = new ReentrantLock();
    }

    public void read(Student student) throws InterruptedException {
        //lock.tryLock(10, TimeUnit.MILLISECONDS);
        lock.lock();
        System.out.println(student + " start reading " + this);
        Thread.sleep(1000);
        lock.unlock();
        System.out.println(student + " has finished reading " + this);
    }

    @Override
    public String toString() {
        return "Book " + id;
    }

}
