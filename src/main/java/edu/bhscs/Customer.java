package edu.bhscs;

class Customer {

  Cake OwnedCake = new Cake(false);
  Store PreferredStore;
  double MyMoney = 0.00;
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

  void BuyAndPayForCake(int y, int x) {
    System.out.println("I, " + MyName + ", will attempt to buy the cake at row " + y + " column " + x);
    PreferredStore.buyCake(y, x);
    MyMoney = PreferredStore.PayForCake(MyMoney);
  }

  void PickupCake() {
    this.OwnedCake = PreferredStore.PickupCake();
    if (OwnedCake.cakeexist()) {
      OwnedCake.SetCakeOwner(MyName);
    }
  }

  void CakeInfo() {
    OwnedCake.viewcake();
  }

  void EatMyCake(int eatinginpercent) {
    OwnedCake.eatcake(eatinginpercent);
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
