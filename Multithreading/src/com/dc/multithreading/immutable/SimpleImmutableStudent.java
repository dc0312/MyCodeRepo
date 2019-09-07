package com.dc.multithreading.immutable;

/*1. Make your class final, so that no other classes can extend it.
2. Make all your fields final, so that they’re initialized only once inside the constructor and never modified afterward.
3. Don’t expose setter methods.*/

public final class SimpleImmutableStudent {
    private final int id;
    private final String name;

    public SimpleImmutableStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
