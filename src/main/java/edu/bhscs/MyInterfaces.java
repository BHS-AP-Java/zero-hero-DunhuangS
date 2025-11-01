package edu.bhscs;

interface MyInterfaces {
  public void printwidth(int a);
}

class offsetable implements MyInterfaces {
  public void printwidth(int a) {
    for (int i = 0; i < a; i++) {
      System.out.print("  ");
    }
  }
}
