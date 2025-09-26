package edu.bhscs;

class Store {
  Cake a = new Cake(false);
  // cake b = new cake(false);
  Cake[][] shelf = {{a, a, a, a, a}, {a, a, a, a, a}, {a, a, a, a, a}};
  double[][] prices = {
    {0.00, 0.00, 0.00, 0.00, 0.00}, {0.00, 0.00, 0.00, 0.00, 0.00}, {0.00, 0.00, 0.00, 0.00, 0.00}
  };
  Cake selCake = a;
  double cashier = 0.00;
  boolean paid = false;
  int selCakex = 0;
  int selCakey = 0;
  String StoreName;

  public Store(String name) {
    System.out.println("A new store that sells cakes, " + name + ", has opened!");
    StoreName = name;
  }

  String StoreName() {
    return StoreName;
  }

  void showcakes() { // shows all cakes on sale
    boolean therearecakes = false;
    int height = 1;
    for (Cake[] row : shelf) {
      int dist = 1;
      for (Cake item : row) {
        if (item.cakeexist()) {
          if (!therearecakes) {
            therearecakes = true;
            System.out.println("THE FOLLOWING CAKES ARE AVAILABLE:");
            System.out.println("-------------------------------------");
          } else {
            System.out.println();
          }
          System.out.println("'" + item.cakename() + "'");
          System.out.println("At shelf position | row: " + height + " column: " + dist + " |");
          System.out.println("This cake costs $" + prices[height - 1][dist - 1]);
        }
        dist += 1;
      }
      height += 1;
    }
    if (!therearecakes) {
      System.out.println("There are no cakes on the shelf right now!");
    } else {
      System.out.println("-------------------------------------");
      System.out.println();
    }
  }

  void addcakes(int y, int x, Cake thingie, double price) { // adds a cake to the shelves
    this.shelf[y - 1][x - 1] = thingie;
    this.prices[y - 1][x - 1] = price;
  }

  void ExamineCake(int y, int x) {
    this.shelf[y - 1][x - 1].viewcake();
  }

  void buyCake(int y, int x) {
    if (shelf[y - 1][x - 1].cakeexist()) {
      if (selCake.cakeexist()) {
        addcakes(selCakey, selCakex, selCake, cashier);
        System.out.println("The previous cake has been returned to the shelf!");
      }
      this.cashier = prices[y - 1][x - 1];
      selCake = this.shelf[y - 1][x - 1];
      this.shelf[y - 1][x - 1] = a;
      selCakex = x;
      selCakey = y;
      System.out.println("Cake '" + selCake.cakename() + "' has been selected! Please pay at the cashier!");
    } else {
      System.out.println("There is no cake here!");
    }
  }

  double PayForCake(double payment) {
    double refund = payment - cashier;
    if (selCake.cakeexist()) {
      if (refund == 0) {
        System.out.println("Paid exactly! Have a great day!");
        System.out.println("don't forget to pick up your cake!");
        paid = true;
        return refund;
      } else if (refund < 0) {
        System.out.println("Oof. Not enough money, no cake for you! Cake returned to shelf.");
        addcakes(selCakey, selCakex, selCake, cashier);
        selCake = a;
        return payment;
      } else {
        System.out.println("Your change is $" + refund + ". Have a great day!");
        System.out.println("don't forget to pick up your cake!");
        paid = true;
        return refund;
      }
    } else {
      System.out.println("No selected cake to pay for!");
      return payment;
    }
  }

  Cake PickupCake() {
    if (paid) {
      Cake outcake = selCake;
      selCake = a;
      paid = false;
      System.out.println("You have picked up the cake '" + outcake.cakename() + "' !");
      return outcake;
    } else {
      System.out.println("There isn't a cake to pick up!");
      return a;
    }
  }
}
