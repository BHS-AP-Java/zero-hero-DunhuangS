package edu.bhscs;

public class App {

  public static void main(String[] args) {
    date10_27();
    System.out.println("I'm the app!!!!!!!!");
  }

  public static void date10_27() {
    Baker bob = new Baker("Bob");
    Table t = new Table(3, 15);
    Cake bDay = bob.bakes(5, "Suzzie");
    bDay.draw(t);
  }
}
