/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 10/1/2025
 *
 * DESCRIPTION: A PTSA collects money from store.
 * INPUT: Money
 * OUTPUT: Sum of collected money
 * EDGE CASES: negative numbers put the organization in debt.
 */
package edu.bhscs;

class PTSA {
  String name;
  double money;

  PTSA(String name) {
    this.name = name;
  }

  void updatename(String name) {
    this.name = name;
  }

  String returnname() {
    return name;
  }

  void donation(double donation) {
    money += donation;
  }

  void sumofdonation() {
    System.out.println("The PTSA " + name + " has gathered $" + String.format("%.2f", money));
  }
}
