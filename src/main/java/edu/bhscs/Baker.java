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
  // FIELDS AND PROPERTIES
  Recipe MyRecipe;
  Cake MadeCake = new Cake(false);
  boolean existent = false;
  int exp = 0;
  int skill = 1;
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
  String name = "";
  double price = 0.;
  double sellprice;

  Player p;
  Flour f;
  Store placeOfWork;
  int cash;

  //

  // CONSTRUCTORS
  public Baker(String name) {
    this.name = name;
    // System.out.println("A new baker has been hired to make cakes!");
  }

  Baker(Player p) {
    this.p = p;
  }

  // METHODS
  void takeOrder(int price, Customer c) {
    cash += c.pay(price);
    c.takeCake(bakeCake());
  }

  public void learn(int amount) {
    this.skill += amount;
  }

  Cake bakeCake() {
    String answer = this.p.giveAnswer("what cake do you you want?");
    return new Cake(answer, this.f, this.skill);
  }

  void takeJob(Store bakery) {
    String doYouWantToWorkHere = this.p.giveAnswer("Do you want to work at " + bakery.getName() + "? (y/n)");
    if (doYouWantToWorkHere.equals("y")) {
      this.placeOfWork = bakery;
      System.out.println(this.name + " now works at " + bakery.getName());
    }
  }

  //

  void setflour(Flour flour) {
    this.f = flour;
  }

  Store showworkplace() {
    return placeOfWork;
  }

  String getname() {
    return name;
  }

  void setname(String name) {
    this.name = name;
  }

  void printlevel() {
    String levelcomptxt;
    if (skill == 14) {
      levelcomptxt = "infinite";
    } else {
      levelcomptxt = String.valueOf(levelupchart[skill - 1]);
    }
    System.out.println(
        name
            + " is level "
            + skill
            + " ("
            + levelnames[skill - 1]
            + ") with "
            + exp
            + "/"
            + levelcomptxt
            + " experience points");
  }

  void acceptjob(Store bakery) {
    this.placeOfWork = bakery;
  }

  void gotfired() {
    this.placeOfWork = null;
  }

  void gotobakingclass() {
    if (skill < 14) {
      skill += 1;
    }
  }

  void examinepantry() {
    System.out.println("RESULTS OF PANTRY EXAMINATION");
    System.out.println(
        "Flour: " + this.placeOfWork.accessPantry().getFlour().returnquantity() + "g");
    System.out.println(
        "Eggs: " + this.placeOfWork.accessPantry().getEggs().returnquantity() + " units");
    System.out.println(
        "Butter: " + this.placeOfWork.accessPantry().getButter().returnquantity() + "g");
    System.out.println(
        "Milk: " + this.placeOfWork.accessPantry().getMilk().returnquantity() + "mL");
    System.out.println(
        "Sugar: " + this.placeOfWork.accessPantry().getButter().returnquantity() + "g");
  }

  public void Bakeacake() {
    if (placeOfWork != null && MyRecipe != null) {
      if(placeOfWork.accessPantry().getFlour() == null ||
      placeOfWork.accessPantry().getEggs() == null ||
      placeOfWork.accessPantry().getButter() == null ||
      placeOfWork.accessPantry().getMilk() == null ||
      placeOfWork.accessPantry().getSugar() == null) {
        System.out.println("Pantry is not imported yet!");
      } else {
        if (this.placeOfWork
            .accessPantry()
            .checkresources(
                MyRecipe.flour(),
                MyRecipe.eggs(),
                MyRecipe.butter(),
                MyRecipe.milk(),
                MyRecipe.sugar())) {
          price = 0.;
          double cakequality = 0.;
          Pantry Ravage = this.placeOfWork.accessPantry();
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
          cakequality += ((double) skill / 4);
          sellprice = price * ((double) 1. + (0.1 * skill) + ((double) cakequality / (double) 10.));
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
              skill);
          this.existent = true;
          exp += weight / 50;
          checklevelup();
        } else {
          System.out.println("Insufficient materials to make the cake!");
        }
      }
    } else {
      if (MyRecipe == null) {
        System.out.println("I don't have a recipe!");
      } else {
        System.out.println("I have not been hired yet!");
      }
    }
  }

  private void checklevelup() {
    while (exp >= levelupchart[skill - 1]) {
      exp -= levelupchart[skill - 1];
      skill += 1;
      if (p != null) {
        p.accomplish(skill);
      }
    }
  }

  void increaselevelforlowdefcakes() {
    exp += f.returnquantity() / 50;
    checklevelup();
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

  void printpersonalcash() {
    System.out.println("I have $" + cash);
  }

  public void getinstructions(Recipe therecipe) {
    MyRecipe = therecipe;
  }

}
