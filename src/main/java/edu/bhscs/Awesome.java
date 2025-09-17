package edu.bhscs;

public class Awesome {

    //fields / properties -> this is the stuff Awesome has
    String name;
    
    // we need awesomeness via CONSTRUCT of something
    public Awesome(String name) {
         System.out.println("I am the most awesome " + name);
         //this.name does fun stuff to nonstatic variable outside ..????
         this.name = name;
    }

    // this also a method
     String getName() {
        return this.name;
    }

}
