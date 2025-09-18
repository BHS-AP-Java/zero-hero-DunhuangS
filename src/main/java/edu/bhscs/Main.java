// Dunhuang Su
// P2
// Varriables
// 9/16/2025

/*
 * DESCRIPTION: Whatever Mr. Reiber says
 * INPUT: we don't know about input yet
 * OUTPUT: Some cool words in the command line terminal thing
 * EDGE CASE: They are all edge cases at the moment
 */

package edu.bhscs;

class Main {

  public static final float A = 69.42f;
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

  public static void main(String[] args) {
    boolean old = false;
    //currently not running the old program
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

      new funType();
      // System.out.println(A + "?" + A + na);
      // System.out.println(A + A + na);
      // System.out.println();
      // System.out.println("This is neet");
      // System.out.println();
      // System.out.println("OK I am done");
    }
    funType tictactoe = new funType();
    tictactoe.printboard();
    System.out.println(tictactoe.checkwin());
  }
}
