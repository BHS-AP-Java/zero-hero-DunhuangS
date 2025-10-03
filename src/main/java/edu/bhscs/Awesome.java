// This is NOT used in bakesale, and is here from a class lecture and purely for reference

package edu.bhscs;

public class Awesome {

  // fields / properties -> this is the stuff Awesome has
  // these ones can be changed and stored separately per instance
  String name;
  String knowledge;
  // this one can be changed BUT SHARED per instance
  static String testinki;

  // we need awesomeness via CONSTRUCT of something
  public Awesome(String name) {
    System.out.println("I am the most awesome " + name);
    // this.name does fun stuff to nonstatic variable outside ..????
    // name can be changed per instance hmm
    this.name = name;
    // this.var is not needed here and instead can be referenced by Awesome...?????
    Awesome.testinki = name;
  }

  // this also a method, however must be given a NEW instance to be ran in static
  String getName() {
    System.out.println(Awesome.testinki); // last set to D, returns D each time
    return this.name; // set independently
  }

  // this is also a method, but can be directly run with Awesome.testin() because it is static
  static void testin() {
    System.out.println("idk");
  }

  void learnSomething(String knowledge) {
    this.knowledge = knowledge;
  }

  String getKnowledge() {
    return knowledge;
  }
}
