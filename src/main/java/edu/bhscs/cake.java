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
  //FIELDS and PROPERTIES (a lot of them)
  String flavor;
  double sweetness;
  String toppings;
  int diameter;
  String shape;
  int height;
  int eatingprogress = 0;
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
  boolean alternatedef = false;

  int drawlt; int drawht; double drawcut; double drawangle; double drawperspective;

  //CONSTRUCTORS

  public Cake(boolean a) {
    if (a) {
      System.out.println("A new cake has been ordered! Please add information:");
    }
  }

  public Cake(String kindofcake, Flour flour, int bakerskill) {
    existent = true;
    alternatedef = true;
    name = kindofcake;
    ingredients[0] = flour.returnquantity();
    quality = flour.returnquality() - 1 + (((double) bakerskill) / 4);
    weight = ingredients[0];
    craftquality = bakerskill;
  }

  public void viewcake() {
    if (alternatedef) {
      System.out.println("------------------------------------------------------");
      System.out.println("Currently viewing a low definition cake:");
      System.out.println("Description: " + name);
      System.out.println("INGREDIENTS:");
      System.out.println("Flour: " + ingredients[0] + "g");
      System.out.println("May include: toppings, flavoring, preservatives.");
      System.out.println(
          "It has a quality rating of "
              + String.format("%.1f", quality)
              + ", made by a baker with experience level "
              + craftquality
              + ".");
      System.out.println("------------------------------------------------------");
      if (owner == null) {
        System.out.println("This cake has not been owned yet.");
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
    } else {
      if (existent) {
        System.out.println("------------------------------------------------------");
        System.out.println("Currently viewing the cake " + name + ":");
        System.out.println("This cake has a " + shape + " shape.");
        System.out.print("The longest part of the cake is " + diameter + " inches wide,");
        System.out.println(" and it is " + height + " inches tall.");
        System.out.println("The cake has a " + flavor + " flavor.");
        System.out.println(
            "It has a sweetness rating of " + String.format("%.2f", sweetness) + ".");
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

  public void draw(int lt, int ht, double cut, double angle, double perspective) {
    drawlt = lt;
    drawht = ht;
    drawcut = cut;
    drawangle = angle;
    drawperspective = perspective;
    //find the minimum grid length of the cake needed
    double xbound =
    Math.max(
      Math.max(
        Math.abs(drawlt - CartesianEllipseX(drawangle)),
        Math.abs(CartesianEllipseX(drawangle + drawcut) - CartesianEllipseX(drawangle))),
      Math.abs(drawlt - CartesianEllipseX(drawangle + drawcut)));
    // find the offset of the grid from the origin
    double xoff =
      Math.min(
        Math.min(
          CartesianEllipseX(drawangle),
          CartesianEllipseX(drawangle + drawcut)),
        drawlt);
    System.out.println(xoff); //DBG
    //Account for if the cut start and end happen to be at the rightmost
    boolean rightedge = false;
    if ((drawangle < Math.PI && (drawangle + drawcut) > Math.PI)
    || (drawangle < 2 * Math.PI && (drawangle + drawcut) > 2 * Math.PI) || drawcut > Math.PI) {
      rightedge = true;
      xbound = Math.max(xbound, (2 * drawlt) - xoff);
    }
    System.out.println(xbound); //DBG
    //repeat with height function
    //find the minimum grid height

    //double ybound =


    //find height offset


    //create a 2d array of such size calculated above

    //find boundaries of curves
    //this seems to only be an issue with the vertical curves and the top diagonal lines
    //in MOST situations (exception: cake slice passes the horizontal parallel or vertical parallel)
    //this can be marked to save processing speed

    //identify applicable curves
    //this can be done by comparing the boundary vertical lines to the origin vertical lines
    //ex: if right vertical is greater than center vertical, right base diagonal would be hidden
    //repeat with left

    //draw applicable curves onto grid
    //done by plugging associated integer values with offset fould earlier for y coordinate
    //please use cartesian equations as much as possible
    //don't forget to consider +- for sqrt of the ellipse
    //have a different marker for each curve for the next step
    //draw from bottom to top or give priority for each marker: top > edge > inside

    //Fill passthrough
    //loop from top to bottom of array, the markers made above define the boundaries of which to draw from

    //print the cake row by row

  }

  private double topoffset () {
    return ((drawlt - drawht) * (1 - Math.sin(drawperspective)));
  }

  private double CartesianEllipseX (double inputradians) {
    return (drawlt + (drawlt * Math.cos(inputradians + Math.PI)));
  }

  private double CartesianEllipseY (double inputradians) {
    return (drawlt - topoffset() + (drawlt * Math.sin(drawperspective) * Math.sin(inputradians + Math.PI)));
  }
}
