package edu.bhscs;

class Recipe {
  String flavor;
  double sweetness;
  String toppings;
  int diameter;
  String shape;
  int height;
  String name;
  int flour;
  int egg;
  int butter;
  int milk;
  int sugar;

  Recipe(String givenflavor,
        String giventoppings,
        String givenshape,
        String givenname,
        int givendiameter,
        int givenheight,
        int flouramount,
        int eggamount,
        int butteramount,
        int milkamount,
        int sugaramount) {
      flavor = givenflavor;
      toppings = giventoppings;
      shape = givenshape;
      name = givenname;
      diameter = givendiameter;
      height = givenheight;
      flour = flouramount;
      egg = eggamount;
      butter = butteramount;
      milk = milkamount;
      sugar = sugaramount;
      sweetness = (500/35) * (sugar / ((50 * egg) + butter + milk + sugar + flour)); //an egg weighs approximately 50 grams
      /*
       * The average cake is about 30-40% sugar by weight, I will assume 35%
       * Which is assigned a 5 on the sweetness scale
       * Therefore multiply percent of sugar in cake by 100/35 * 5 = 500/35
       */
  }

  String flavor() {
    return flavor;
  }

  String toppings() {
    return toppings;
  }

  String name() {
    return name;
  }

  String shape() {
    return shape;
  }

  int diameter() {
    return diameter;
  }

  int height() {
    return height;
  }

  int flour() {
    return height;
  }

  int eggs() {
    return height;
  }

  int butter() {
    return height;
  }

  int milk() {
    return height;
  }

  int sugar() {
    return height;
  }

  double sweetness() {
    return sweetness;
  }



}