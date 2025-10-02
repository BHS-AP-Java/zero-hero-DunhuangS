/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 10/1/2025
 *
 * DESCRIPTION: Base ingredient #1 (flour)
 * INPUT: Flour quantity, cost, and quality
 * OUTPUT: boolean if the materials exist or not
 * EDGE CASES: negative numbers break things once again.
 * Especially if the quantity is also negative,
 * which practically disables all input other than more negatives
 */

package edu.bhscs;

class Flour {
  int grams;
  int quality;
  double costpergram;

  Flour(int quantity, double cost, int quality) {
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
