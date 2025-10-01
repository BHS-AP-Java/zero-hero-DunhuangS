package edu.bhscs;

public class Baker {
  // fields and properties
  // constructors
  // methods
  Recipe MyRecipe;
  Cake MadeCake = new Cake(false);
  boolean existent = false;
  Store workplace;
  int exp = 0;

  public Baker(Store work) {
    System.out.println("A new baker has been hired to make cakes!");
    workplace = work;
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

  public void getinstructions(Recipe therecipe) {
    MyRecipe = therecipe;
    this.flavor = therecipe.flavor();
    this.toppings = therecipe.toppings();
    this.shape = therecipe.shape();
    this.diameter = therecipe.diameter();
    this.height = therecipe.height();
    this.name = therecipe.name();

  }
}
