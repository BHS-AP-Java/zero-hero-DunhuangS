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
    PreferredStore.buyCake(y,x);
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

}
