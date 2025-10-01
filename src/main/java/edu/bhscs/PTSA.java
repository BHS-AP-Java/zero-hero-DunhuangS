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

  double returnprofits() {
    return money;
  }

}