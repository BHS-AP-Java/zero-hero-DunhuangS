package edu.bhscs;

class Milk {
  int mililiters;
  int quality;
  double costpergram;

  Milk(int quantity, double cost, int quality) {
    this.mililiters = quantity;
    this.quality = quality;
    this.costpergram = cost / quantity;
  }

  double use(int amount) {
    if (mililiters - amount < 0) {
      return -1;
    } else {
      mililiters -= amount;
      return amount * costpergram;
    }
  }

  int returnquality() {
    return quality;
  }

  void goesbad() {
    quality = 0;
  }

  int returnquantity() {
    return mililiters;
  }
}

