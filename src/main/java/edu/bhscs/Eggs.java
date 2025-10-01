package edu.bhscs;

class Eggs {
  int Count;
  int quality;
  double costpergram;

  Eggs(int quantity, double cost, int quality) {
    this.Count = quantity;
    this.quality = quality;
    this.costpergram = cost / quantity;
  }

  double use(int amount) {
    if (this.Count - amount < 0) {
      return -1;
    } else {
      this.Count -= amount;
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
    return Count;
  }
}

