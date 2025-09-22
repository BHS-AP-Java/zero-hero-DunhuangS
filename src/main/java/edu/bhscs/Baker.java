package edu.bhscs;

public class Baker {

    String flavor = "unknown";
    String sweetness = "unknown";
    String toppings = "unknown";
    int diameter = 6;
    String shape = "unknown";
    int height = 3;
    int weight = 350;



    public Baker() {
        System.out.println("A new baker has been hired to make cakes!");
    }
    public void Bakeacake () {
        makecake MadeCake = new makecake(false);
        MadeCake.batchsetting(
          flavor, sweetness, toppings, shape, diameter, height, weight);
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

    public void giveinstructions(
      String givenflavor,
      String givensweetness,
      String giventoppings,
      String givenshape,
      int givendiameter,
      int givenheight,
      int givenweight) {
    this.flavor = givenflavor;
    this.sweetness = givensweetness;
    this.toppings = giventoppings;
    this.shape = givenshape;
    this.diameter = givendiameter;
    this.height = givenheight;
    this.weight = givenweight;
    }
}
