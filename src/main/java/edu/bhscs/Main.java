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

  public static float A = 69.42f;
  public static int B = 67;
  public static String pushup(int numb) {
    if (numb > 1) {
      return pushup(numb - 1) + " sweat";
    }
    return "sweaty";
  }
  public static void main(String[] args) {
    System.out.println(A);
    System.out.println(pushup(3));
    //System.out.println(A + "?" + A + na);
    //System.out.println(A + A + na);
    //System.out.println();
    //System.out.println("This is neet");
    //System.out.println();
    //System.out.println("OK I am done");
  }
}
