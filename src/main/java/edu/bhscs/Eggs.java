/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 10/1/2025
 *
 * DESCRIPTION: Base ingredient #2 (Eggs)
 * INPUT: Egg quantity, cost, and quality
 * OUTPUT: boolean if the materials exist or not
 * EDGE CASES: negative numbers again. Same issue as flour.
 */

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
