package com.cloud.petstore;

class HashCodeAndEqual
{ 
      
    public static void main (String[] args) 
    { 
      
        // creating the Objects of Geek class. 
        Geek g1 = new Geek("aa", 1); 
        Geek g2 = new Geek("aa", 1); 
          
        // comparing above created Objects.

        System.out.println("g1 hashcode:"+g1.hashCode());
        System.out.println("g2 hashcode:"+g2.hashCode());
        if(g1.hashCode() == g2.hashCode()) 
        { 
            if(g1.equals(g2))
                System.out.println("Both Objects are equal. "); 
        }
        else
        System.out.println("Both Objects are not equal. ");  
    }  
} 