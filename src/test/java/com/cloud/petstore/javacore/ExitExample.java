package com.cloud.petstore;

public class ExitExample
{
    public static void main(String[] args) {


        try {
            //try block
            System.out.println("Inside try block");
            //System.exit(0);
        } catch (Exception exp) {
            System.out.println(exp);
        } finally {
            System.out.println("Java finally block");
        }
    }
}
