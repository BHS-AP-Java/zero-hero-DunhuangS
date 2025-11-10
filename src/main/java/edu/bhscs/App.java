/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 11/3/2025
 *
 * DESCRIPTION: A different executable class to run the bakesale with
 * INPUT: nothing
 * OUTPUT: The operation of the bake sale under this new operation
 * EDGE CASES: Table size and legs in the millions
 */
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
    bDay.drawbetter(t);
    
  }
}
