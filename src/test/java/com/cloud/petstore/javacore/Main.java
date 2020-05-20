package com.cloud.petstore;

class A {
    void m() {
        System.out.println("Hello");
    }
}

class B {
    void m() {
        System.out.println("java");
    }

    public static void main(String[] args) {
        B obj = new B();
        obj.m();
    }
}