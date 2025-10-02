/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 10/1/2025
 *
 * DESCRIPTION: This is a baker that makes cakes from instructions
 * INPUT: Baker's name, Recipe to bake, Store to work for
 * OUTPUT: A made cake with the given properties
 * EDGE CASES:
 * An incomplete recipe (null info) will break the comparison
 * A negative ingredient requirement will add ingredients to the source (undesirable)
 * Much negative ingredients will result in a negative pricetag. This sometimes breaks formatting.
 * Negative ingredients also give negative exp to the baker
 */
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
  int level = 1;
  int[] levelupchart = {
    20, 30, 50, 50, 75, 125, 150, 200, 300, 1000, 3000, 5000, 15000, Integer.MAX_VALUE
  };
  // there are 14 levels, so 13 level up sequences
  String[] levelnames = {
    "Newbie",
    "Novice I",
    "Novice II",
    "Novice III",
    "Intermediate I",
    "Intermediate II",
    "Intermediate III",
    "Expert I",
    "Expert II",
    "Expert III",
    "Virtuoso confectioner",
    "Master confectioner",
    "Grandmaster confectioner",
    "World class confectioner"
  };
  String name;
  double price = 0.;
  double sellprice;

  public Baker(String name) {
    this.name = name;
    // System.out.println("A new baker has been hired to make cakes!");
  }

  String getname() {
    return name;
  }

  void printlevel() {
    String levelcomptxt;
    if (level == 14) {
      levelcomptxt = "infinite";
    } else {
      levelcomptxt = String.valueOf(levelupchart[level - 1]);
    }
    System.out.println(
        name
            + " is level "
            + level
            + " ("
            + levelnames[level - 1]
            + ") with "
            + exp
            + "/"
            + levelcomptxt
            + " experience points");
  }

  void acceptjob(Store bakery) {
    workplace = bakery;
  }

  void gotfired() {
    workplace = null;
  }

  void gotobakingclass() {
    if (level < 14) {
      level += 1;
    }
  }

  void examinepantry() {
    System.out.println("RESULTS OF PANTRY EXAMINATION");
    System.out.println("Flour: " + workplace.accessPantry().getFlour().returnquantity() + "g");
    System.out.println("Eggs: " + workplace.accessPantry().getEggs().returnquantity() + " units");
    System.out.println("Butter: " + workplace.accessPantry().getButter().returnquantity() + "g");
    System.out.println("Milk: " + workplace.accessPantry().getMilk().returnquantity() + "mL");
    System.out.println("Sugar: " + workplace.accessPantry().getButter().returnquantity() + "g");
  }

  public void Bakeacake() {
    if (workplace
        .accessPantry()
        .checkresources(
            MyRecipe.flour(),
            MyRecipe.eggs(),
            MyRecipe.butter(),
            MyRecipe.milk(),
            MyRecipe.sugar())) {
      price = 0.;
      double cakequality = 0.;
      Pantry Ravage = workplace.accessPantry();
      price += Ravage.getFlour().use(MyRecipe.flour());
      cakequality += Ravage.getFlour().returnquality();
      price += Ravage.getEggs().use(MyRecipe.eggs());
      cakequality += Ravage.getEggs().returnquality();
      price += Ravage.getButter().use(MyRecipe.butter());
      cakequality += Ravage.getButter().returnquality();
      price += Ravage.getMilk().use(MyRecipe.milk());
      cakequality += Ravage.getMilk().returnquality();
      price += Ravage.getSugar().use(MyRecipe.sugar());
      cakequality += Ravage.getSugar().returnquality();
      cakequality /= 5.;
      cakequality -= 1.;
      cakequality += ((double) level / 4);
      sellprice = price * ((double) 1. + (0.1 * level) + ((double) cakequality / (double) 10.));
      // Ravage.putflour(Ravage.getFlour().use(MyRecipe.flour()));
      MadeCake = new Cake(false);
      int weight =
          (50 * MyRecipe.eggs())
              + MyRecipe.butter()
              + MyRecipe.milk()
              + MyRecipe.sugar()
              + MyRecipe.flour();
      MadeCake.batchsetting(
          MyRecipe.flavor(),
          MyRecipe.sweetness(),
          MyRecipe.toppings(),
          MyRecipe.shape(),
          MyRecipe.diameter(),
          MyRecipe.height(),
          MyRecipe.name(),
          MyRecipe.flour(),
          MyRecipe.eggs(),
          MyRecipe.butter(),
          MyRecipe.milk(),
          MyRecipe.sugar(),
          cakequality,
          price,
          level);
      this.existent = true;
      exp += weight / 50;
      checklevelup();
    } else {
      System.out.println("Insufficient materials to make the cake!");
    }
  }

  private void checklevelup() {
    while (exp >= levelupchart[level - 1]) {
      exp -= levelupchart[level - 1];
      level += 1;
    }
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

  double getprice() {
    double intermediate = sellprice;
    sellprice = 0.;
    price = 0.;
    return intermediate;
  }

  public void getinstructions(Recipe therecipe) {
    MyRecipe = therecipe;
  }
}
