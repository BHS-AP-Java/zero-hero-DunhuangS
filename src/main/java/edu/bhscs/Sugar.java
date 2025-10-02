/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 10/1/2025
 *
 * DESCRIPTION: Base ingredient #5 (Sugar)
 * INPUT: Sugar quantity, cost, and quality
 * OUTPUT: boolean if the materials exist or not
 * EDGE CASES: negative numbers again. Same issue as flour.
 */
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
