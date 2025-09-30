package edu.bhscs.Ingredients;

class Flour {
  int grams;
  int quality;
  double costpergram;

  Flour(int quantity, double cost, int quality) {
    this.grams = quantity;
    this.quality = quality;
    this.costpergram = cost / quantity;
  }

  double useflour(int amount) {
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
}
