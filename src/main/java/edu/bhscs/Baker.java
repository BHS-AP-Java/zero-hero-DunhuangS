package edu.bhscs;

public class Baker {
  //fields and properties
  //constructors
  //methods
  String flavor = "unknown";
  String sweetness = "unknown";
  String toppings = "unknown";
  int diameter = 6;
  String shape = "unknown";
  int height = 3;
  int weight = 350;
  Cake MadeCake = new Cake(false);
  String name = "unknown";
  boolean existent = false;

  public Baker() {
    System.out.println("A new baker has been hired to make cakes!");
  }

  public void Bakeacake() {
    this.MadeCake = new Cake(false);
    MadeCake.batchsetting(flavor, sweetness, toppings, shape, diameter, height, weight, name);
    this.existent = true;
  }

  Cake Givemethecake() {
    if (existent) {
      existent = false;
      Cake intermediate = MadeCake;
      MadeCake = new Cake(false);
      return intermediate;
    } else {
      Cake empty = new Cake(false);
      System.out.println("I currently do not have a cake!");
      return empty;
    }
  }

  void setflavor(String given) {
    this.flavor = given;
  }

  void setsweetness(String given) {
    this.sweetness = given;
  }

  void settoppings(String given) {
    this.toppings = given;
  }

  void setshape(String given) {
    this.shape = given;
  }

  void setdiameter(int given) {
    this.diameter = given;
  }

  void setheight(int given) {
    this.height = given;
  }

  void setweight(int given) {
    this.weight = given;
  }

  void setname(String given) {
    this.name = given;
  }

  public void giveinstructions(
      String givenflavor,
      String givensweetness,
      String giventoppings,
      String givenshape,
      int givendiameter,
      int givenheight,
      int givenweight,
      String givenname) {
    this.flavor = givenflavor;
    this.sweetness = givensweetness;
    this.toppings = giventoppings;
    this.shape = givenshape;
    this.diameter = givendiameter;
    this.height = givenheight;
    this.weight = givenweight;
    this.name = givenname;
  }
}
