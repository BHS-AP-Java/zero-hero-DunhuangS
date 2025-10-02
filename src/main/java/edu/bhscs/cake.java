/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 10/1/2025
 *
 * DESCRIPTION: A cake with various assigned properties
 * INPUT: The wanted properties of a given cake
 * OUTPUT: Various information about the cake
 * EDGE CASES: Often the string-based properties will have gramatically incorrect phrases in viewcake
 */

package edu.bhscs;

class Cake {
  String flavor;
  double sweetness;
  String toppings;
  int diameter;
  String shape;
  int height;
  int eatingprogress;
  int weight;
  String owner;
  boolean existent;
  String name;
  int[] ingredients = {0, 0, 0, 0, 0};
  // I have no clue how to make a dictionary in Java,
  // so I will just use array instead :/
  double quality;
  double oprice;
  int craftquality;

  public Cake(boolean a) {
    if (a) {
      System.out.println("A new cake has been ordered! Please add information:");
    }
  }

  public void viewcake() {
    if (existent) {
      System.out.println("------------------------------------------------------");
      System.out.println("Currently viewing the cake " + name + ":");
      System.out.println("This cake has a " + shape + " shape.");
      System.out.print("The longest part of the cake is " + diameter + " inches wide,");
      System.out.println(" and it is " + height + " inches tall.");
      System.out.println("The cake has a " + flavor + " flavor.");
      System.out.println("It has a sweetness rating of " + String.format("%.2f", sweetness) + ".");
      System.out.println("Finally, it is topped off with " + toppings + " toppings.");
      System.out.println("It weighs " + weight + " grams coming out of the store.");
      System.out.println(
          "It has a quality rating of "
              + String.format("%.1f", quality)
              + ", made by a baker with experience level "
              + craftquality
              + ".");
      System.out.println("------------------------------------------------------");
      if (owner == null) {
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
      System.out.println("INGREDIENTS:");
      System.out.println("Flour: " + ingredients[0] + "g");
      System.out.println("Eggs: " + ingredients[1] + " large");
      System.out.println("Butter: " + ingredients[2] + "g");
      System.out.println("Milk: " + ingredients[3] + "mL");
      System.out.println("Sugar: " + ingredients[4] + "g");
      System.out.println("May include: toppings, flavoring, preservatives.");
      System.out.println("------------------------------------------------------");
      System.out.println();
    } else {
      System.out.println("There is no cake!");
    }
  }

  double getoprice() {
    return oprice;
  }

  public int ReturnAmountEaten() {
    return eatingprogress;
  }

  public int ReturnWeight() {
    return weight;
  }

  public boolean cakeexist() {
    return this.existent;
  }

  public String cakename() {
    return this.name;
  }

  public double returnquality() {
    return quality;
  }

  public void batchsetting(
      String givenflavor,
      double givensweetness,
      String giventoppings,
      String givenshape,
      int givendiameter,
      int givenheight,
      String givenname,
      int flouramount,
      int eggamount,
      int butteramount,
      int milkamount,
      int sugaramount,
      double predictedquality,
      double makeprice,
      int craftsmanship) {
    this.flavor = givenflavor;
    this.sweetness = givensweetness;
    this.toppings = giventoppings;
    this.shape = givenshape;
    this.diameter = givendiameter;
    this.height = givenheight;
    this.weight = (eggamount * 50) + butteramount + milkamount + sugaramount + flouramount;
    this.name = givenname;
    this.existent = true;
    ingredients[0] = flouramount;
    ingredients[1] = eggamount;
    ingredients[2] = butteramount;
    ingredients[3] = milkamount;
    ingredients[4] = sugaramount;
    quality = predictedquality;
    this.oprice = makeprice;
    this.craftquality = craftsmanship;
  }

  public void eatcake(int eatpercent) {
    this.eatingprogress += eatpercent;
    if (eatingprogress > 100) {
      this.eatingprogress = 100;
    }
  }

  public void SetCakeOwner(String name) {
    this.owner = name;
  }
}
