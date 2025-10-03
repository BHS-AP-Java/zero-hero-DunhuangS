/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 10/1/2025
 *
 * DESCRIPTION: A customer that purchases cake from stores and consumes them.
 * INPUT: Preferred store, money, name, consumption of cake
 * OUTPUT: Properties of the customer and the cake
 * EDGE CASES: The customer can eat negative cake.
 */
package edu.bhscs;

class Customer {

  Cake OwnedCake = new Cake(false);
  Store PreferredStore;
  double MyMoney = 0.00;
  double satisfication = 100;
  String MyName;

  public Customer(String name, boolean a, Store store, double money) {
    if (a) {
      System.out.println("Hello! I am " + name + ", and I am a customer.");
      System.out.println("I purchase cakes at the store " + store.StoreName());
      PreferredStore = store;
      MyName = name;
      MyMoney = money;
    }
  }

  void ChangePreferredStore(Store store) {
    PreferredStore = store;
  }

  void MakeYTVideos(int hours) {
    if (satisfication < (hours * 25)) {
      System.out.println(
          "I don't feel motivated to go to record for that long, Perhaps some cake will motivate me?");
    } else {
      satisfication -= (hours * 25);
      MyMoney += (hours * 20);
    }
  }

  void getmysatisfication() {
    System.out.println(
        "I, "
            + MyName
            + ", have "
            + String.format("%.2f", satisfication)
            + " points of satisfaction");
  }

  void printmoney() {
    System.out.println("I, " + MyName + ", have $" + String.format("%.2f", MyMoney));
  }

  void BuyAndPayForCake(int y, int x) {
    System.out.println(
        "I, " + MyName + ", will attempt to buy the cake at row " + y + " column " + x);
    PreferredStore.buyCake(y, x);
    MyMoney = PreferredStore.PayForCake(MyMoney);
  }

  void PickupCake() {
    if (OwnedCake.cakeexist()) {
      System.out.println("I already have a cake!");
    } else {
      this.OwnedCake = PreferredStore.PickupCake(MyName);
      if (OwnedCake.cakeexist()) {
        OwnedCake.SetCakeOwner(MyName);
      }
    }
  }

  void CakeInfo() {
    OwnedCake.viewcake();
  }

  void EatMyCake(int eatinginpercent) {
    satisfication +=
        ((double) OwnedCake.ReturnWeight() * (double) eatinginpercent / (double) 100)
            * (OwnedCake.returnquality() / 10);
    if (OwnedCake.cakeexist()) {
      OwnedCake.eatcake(eatinginpercent);
    } else {
      System.out.println("I don't have a cake to eat, silly!");
    }
  }

  void DiscardMyCake() {
    int eated = OwnedCake.ReturnAmountEaten();
    if (eated == 100) {
      System.out.println("Cake has been eaten with no scraps! Time to discard the packaging.");
    } else if (eated > 90) {
      System.out.println(
          "Cake is almost finished, but I think I should throw away the rest if I don't want a heart attack.");
    } else if (eated > 80) {
      System.out.println("There is a good slice of cake left, but I didn't like this one anyways.");
    } else if (eated > 50) {
      System.out.println(
          "Finally time to get rid of this trash. Only reason I still ate this is because the sugar keeps it edible.");
    } else if (eated > 1) {
      System.out.println(
          "Why throw it out, you higher sentient creature that alters my mind? Such a waste of food!");
    } else {
      System.out.println(
          "Oops, wrong purchase. Luckily I am so spoiled I can just throw this one right away!");
    }
    OwnedCake = new Cake(false);
  }
}
