package edu.bhscs;

class Pantry {
  Sugar sugarstore;
  Eggs eggstore;
  Butter butterstore;
  Flour flourstore;
  Milk milkstore;

  Pantry() {}

  void putsugar(Sugar source) {
    sugarstore = source;
  }

  void puteggs(Eggs source) {
    eggstore = source;
  }

  void putmilk(Milk source) {
    milkstore = source;
  }

  void putflour(Flour source) {
    flourstore = source;
  }

  void putbutter(Butter source) {
    butterstore = source;
  }

  Sugar getSugar() {
    return sugarstore;
  }

  Eggs getEggs() {
    return eggstore;
  }

  Milk getMilk() {
    return milkstore;
  }

  Flour getFlour() {
    return flourstore;
  }

  Butter getButter() {
    return butterstore;
  }

  boolean checkresources(int neededSugar, int neededEggs, int neededMilk, int neededFlour, int neededButter) {
    if (
    neededSugar <= sugarstore.returnquantity() &&
    neededEggs <= eggstore.returnquantity() &&
    neededMilk <= milkstore.returnquantity() &&
    neededFlour <= flourstore.returnquantity() &&
    neededButter <= butterstore.returnquantity()
    ) {return true;} else {return false;}
  }


}