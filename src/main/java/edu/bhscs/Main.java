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

     }
  }
  public static void main(String[] args) {
    // System.out.println(A);
    // Integer f = Integer.valueOf(System.console().readLine("Pushups: "));
    // System.out.println(pushu(f));
    String x = pushup("Garlic");
    System.out.println(x);
    //String[] names = {"Anna","Belle","Cadey","Dorothy"};
    Awesome anna = new Awesome("Anna");
    Awesome belle = new Awesome("Belle");
    Awesome cadey = new Awesome("Cadey");
    Awesome dorothy = new Awesome("Dorothy");


    System.out.println(anna.getName());
    System.out.println(belle.getName());
    System.out.println(cadey.getName());
    System.out.println(dorothy.getName());
    // System.out.println(A + "?" + A + na);
    // System.out.println(A + A + na);
    // System.out.println();
    // System.out.println("This is neet");
    // System.out.println();
    // System.out.println("OK I am done");
  }
}
