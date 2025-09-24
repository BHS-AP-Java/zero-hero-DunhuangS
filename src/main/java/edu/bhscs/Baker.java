package edu.bhscs;

public class Baker {

  String flavor = "unknown";
  String sweetness = "unknown";
  String toppings = "unknown";
  int diameter = 6;
  String shape = "unknown";
  int height = 3;
  int weight = 350;
  cake MadeCake = new cake(false);
  String name = "unknown";
  boolean existent = false;

  public Baker() {
    System.out.println("A new baker has been hired to make cakes!");
  }

  public void Bakeacake() {
    this.MadeCake = new cake(false);
    MadeCake.batchsetting(flavor, sweetness, toppings, shape, diameter, height, weight, name);
  }

  cake Givemethecake() {
    if (existent){
      existent = false;
      cake intermediate = MadeCake;
      MadeCake = new cake(false);
      return intermediate;
    } else {
      cake empty = new cake(false);
      System.out.println("I currently do not have a cake!");
      return empty;
    }
  }

  void setflavor(String given) {
    this.flavor = given;
    this.existent = true;
  }

  void setsweetness(String given) {
    this.sweetness = given;
    this.existent = true;
  }

  void settoppings(String given) {
    this.toppings = given;
    this.existent = true;
  }

  void setshape(String given) {
    this.shape = given;
    this.existent = true;
  }

  void setdiameter(int given) {
    this.diameter = given;
    this.existent = true;
  }

  void setheight(int given) {
    this.height = given;
    this.existent = true;
  }

  void setweight(int given) {
    this.weight = given;
    this.existent = true;
  }

  void setname(String given) {
    this.name = given;
    this.existent = true;
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
    this.existent = true;
  }
}
