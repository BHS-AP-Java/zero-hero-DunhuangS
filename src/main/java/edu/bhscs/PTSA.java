package edu.bhscs;

class PTSA {
  String name;
  double money;

  PTSA(String name) {
    this.name = name;
  }

  void donation(double donation) {
    money += donation;
  }

  void sumofdonation() {
    System.out.println("The PTSA " + name + " has gathered $" + String.format("%.2f", money));
  }
}
