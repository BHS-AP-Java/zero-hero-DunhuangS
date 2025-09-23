package edu.bhscs;

class cake {
  String flavor = "unknown";
  String sweetness = "unknown";
  String toppings = "unknown";
  int diameter = 6;
  String shape = "unknown";
  int height = 3;
  int eatingprogress = 0;
  int weight = 350;
  String owner = "unknown";
  boolean existent = false;
  String name = "unknown";

  public cake(boolean a) {
    if (a) {
      System.out.println("A new cake has been ordered! Please add information:");
    }
  }

  void viewcake() {
    if (existent) {
      System.out.println("Currently viewing the cake " + name + ":");
      System.out.println("This cake has a " + shape + " shape.");
      System.out.println("The longest part of the cake is " + diameter + " inches wide,");
      System.out.println("and is " + height + " inches tall.");
      System.out.println("The cake has a " + flavor + " flavor.");
      System.out.println("It is " + sweetness + " sweet.");
      System.out.println("Finally, it is topped off with " + toppings + " toppings.");
      System.out.println("It weighs " + weight + " grams coming out of the store.");
      System.out.println("------------------------------------------------------");
      if (owner.equals("unknown")) {
        System.out.println("This cake has not been purchased yet.");
      } else {
        System.out.println("This cake is owned by " + owner + ".");
        if (eatingprogress == 100) {
          System.out.println("They have finished the entire cake. Yummy!");
        } else {
          System.out.println("They have eaten " + eatingprogress + "% of this cake.");
          System.out.println(
              "It weighs " + (((100 - eatingprogress) * weight) / 100) + " grams right now.");
        }
      }
      System.out.println("------------------------------------------------------");
      System.out.println();
    } else {
      System.out.println("There is no cake!");
    }
  }
  boolean cakeexist() {
    return this.existent;
  }
  String cakename() {
    return this.name;
  }

  public void batchsetting(
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
  /* 
  void eatcake(int eatpercent) {
    this.eatingprogress += eatpercent;
    if (eatingprogress > 100) {
      this.eatingprogress = 100;
    }
  }

  void setowner(String given) {
    this.owner = given;
  }
  */
}
