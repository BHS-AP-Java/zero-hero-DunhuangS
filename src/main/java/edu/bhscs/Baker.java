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

  public Baker() {
    System.out.println("A new baker has been hired to make cakes!");
  }

  public void Bakeacake() {
    this.MadeCake = new cake(false);
    MadeCake.batchsetting(flavor, sweetness, toppings, shape, diameter, height, weight, name);
  }

  cake addtostore() {
    return MadeCake;
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
