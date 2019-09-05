package com.dc.multithreading;

public abstract class OverLoading {
    
    public static void test(int... x) {
        System.out.println("Var Arg Called");
    }
    
    public static void test(int x) {
        System.out.println("Normal method called");
    }
    
    public static void main(String[] args) {
        OverLoading loading = new OverLoading();
        test(1);
    }

}
