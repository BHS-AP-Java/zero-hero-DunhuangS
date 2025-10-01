package edu.bhscs;

class Sugar {
  int grams;
  int quality;
  double costpergram;

  Sugar(int quantity, double cost, int quality) {
    this.grams = quantity;
    this.quality = quality;
    this.costpergram = cost / quantity;
  }

  double use(int amount) {
    if (grams - amount < 0) {
      return -1;
    } else {
      grams -= amount;
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
    return grams;
  }
}

