/* Dunhuang Su
 * P2
 * Bake Sale
 * 9/29/2025

 * DESCRIPTION: A Cake, a Baker, a Store, and a Customer exist in a bake sale. Earned money is given to PTSA.
 * INPUT: we don't know about input yet
 * OUTPUT: The standard operation of the bake sale
 * EDGE CASE: They are all edge cases at the moment
 */

package edu.bhscs;

class Main {

  public static final int B = 67;

  public static String pushu(int numb) {
    if (numb > 1) {
      return pushu(numb - 1) + " sweat";
    }
    return "sweaty";
  }

  public static String pushup(String food) {
    return "sweat " + food;
  }

  public static void printrepeat(int repetitions, String giventxt) {
    for (int i = 0; i < repetitions; i++) {
      System.out.println(giventxt);
    }
  }

  public static void main(String[] args) { //this is a constructor
    boolean old = false;
    // currently not running the old program
    boolean ttt = false;
    // doing cake stuff, not ttt anymore
    boolean cake = true;
    // doing cake stuff
    if (old) {
      // System.out.println(A);
      // Integer f = Integer.valueOf(System.console().readLine("Pushups: "));
      // System.out.println(pushu(f));
      String x = pushup("Garlic");
      System.out.println(x);
      printrepeat(10, x);
      Awesome anna = new Awesome("Anna");
      Awesome belle = new Awesome("Belle");
      Awesome cadey = new Awesome("Cadey");
      Awesome dorothy = new Awesome("Dorothy");

      Awesome.testin();

      System.out.println(anna.getName());
      System.out.println(belle.getName());
      System.out.println(cadey.getName());
      System.out.println(dorothy.getName());
      anna.learnSomething(x);
      System.out.println(anna.getKnowledge());

      // new funType();
      // System.out.println(A + "?" + A + na);
      // System.out.println(A + A + na);
      // System.out.println();
      // System.out.println("This is neet");
      // System.out.println();
      // System.out.println("OK I am done");
    }
    if (ttt) {
      funType tictactoe = new funType();
      // tictactoe.printboard();
      // System.out.println(tictactoe.checkwin());
      int turn = 1;
      int wincheck = 0;
      String cont_ = "ERROR";
      boolean valid = true;
      int ycord = 0;
      int xcord = 0;
      while (420 > 69) {
        if (valid) {
          tictactoe.printboard(turn);
        }
        try {
          ycord = Integer.parseInt(System.console().readLine("Input row: "));
          if (0 < ycord && ycord < 4) {
            xcord = Integer.parseInt(System.console().readLine("Input col: "));
          }
          valid = tictactoe.validate_pos(xcord, ycord);
        } catch (Exception e) {
          valid = false;
        }
        if (valid) {
          tictactoe.updboard(turn, xcord, ycord);
          wincheck = tictactoe.checkwin();
          if (wincheck == 1) {
            tictactoe.printboard(-1);
            System.out.println("-----------------------------");
            System.out.println();
            System.out.println("Player 1 has WON!");
            System.out.println();
            System.out.println("-----------------------------");
            cont_ = System.console().readLine("Continue? (type yes or no): ");
            if (!"yes".equals(cont_)) {
              break;
            }
            tictactoe.resetboard();
          }
          if (wincheck == 2) {
            tictactoe.printboard(-1);
            System.out.println("-----------------------------");
            System.out.println();
            System.out.println("Player 2 has WON!");
            System.out.println();
            System.out.println("-----------------------------");
            cont_ = System.console().readLine("Continue? (type yes or no): ");
            if (!"yes".equals(cont_)) {
              break;
            }
            tictactoe.resetboard();
          }
          if (wincheck == -1) {
            tictactoe.printboard(-1);
            System.out.println("-----------------------------");
            System.out.println();
            System.out.println("It is a draw like predicted");
            System.out.println();
            System.out.println("-----------------------------");
            cont_ = System.console().readLine("Continue? (type yes or no): ");
            if (!"yes".equals(cont_)) {
              break;
            }
            tictactoe.resetboard();
          }
          if (turn == 1) {
            turn = 2;
          } else {
            turn = 1;
          }
        } else {
          System.out.println("This location is invalid! Please pick another: ");
        }
      }
    }
    if (cake) {
      // default cake settings
      String MyFlavor = "chocolate";
      String MySweetness = "moderately";
      String MyToppings = "cherry";
      String MyShape = "circle";
      int MyDiameter = 8;
      int MyHeight = 6;
      int MyWeight = 617;
      String MyName = "chocolate blast";
      //new baker Bob, given instructions and baked a cake
      Baker bob = new Baker();
      bob.giveinstructions(
          MyFlavor, MySweetness, MyToppings, MyShape, MyDiameter, MyHeight, MyWeight, MyName);
      bob.Bakeacake();
      // MadeCake.viewcake();
      //new store Overpricery opens
      Store overpricery = new Store("overpricery");
      //adds bob's cake to the store
      overpricery.addcakes(2, 1, bob.Givemethecake(), 22.99);
      bob.giveinstructions(
          MyFlavor, MySweetness, MyToppings, MyShape, MyDiameter, MyHeight, MyWeight, "scamblast");
      //adds a few more cakes
      bob.Bakeacake();
      overpricery.addcakes(1, 1, bob.Givemethecake(), 229.99);
      bob.giveinstructions(
          MyFlavor, MySweetness, MyToppings, MyShape, MyDiameter, MyHeight, MyWeight, "miniscamblast");
      bob.Bakeacake();
      overpricery.addcakes(1, 3, bob.Givemethecake(), 129.99);
      bob.giveinstructions(
          "Dog", "more savory than", "dog ear", "dog", 90, 24, 16500, "DogCake");
      bob.Bakeacake();
      overpricery.addcakes(3, 5, bob.Givemethecake(), 69.99);
      //this shows all the cakes
      overpricery.showcakes();
      //Janet, a new customer, buys from specifically overpricery
      Customer Janet = new Customer("Janet", true, overpricery, 100);
      //Janet buys a cake
      Janet.BuyAndPayForCake(2, 1);
      Janet.PickupCake();
      //Janet eats the cake
      Janet.EatMyCake(100);
      Janet.CakeInfo();
      //Cake discarded
      Janet.DiscardMyCake();
      //Since cake is discarded, no cake is present when info is taken
      Janet.CakeInfo();
      //Profits of the store
      overpricery.ShowProfits();
      Janet.BuyAndPayForCake(3, 5);
      Janet.PickupCake();
      Janet.EatMyCake(65);
      Janet.CakeInfo();
      Janet.DiscardMyCake();
      overpricery.ShowProfits();
    }
  }
}
