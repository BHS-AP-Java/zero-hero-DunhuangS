package edu.bhscs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Burger {
  // FIELDS AND PROPERTIES
  boolean existent = false;
  int eatingpercent = 0;
  boolean cheese = true;
  boolean lettuce = true;
  boolean tomato = true;
  boolean sesame = true;

  // CONSTRUCTORS
  public Burger() {
    existent = true;
  }

  // METHODS
  public void beEaten(int eatinpercent) {
    eatingpercent += eatinpercent;
    if (eatingpercent > 100) {
      this.eatingpercent = 100;
    }
  }

  public void DrawAWholeMassiveWhoppingHolyWhatTheBurgerOhMy() {
    // This is the path to the file I want to output (burger ASCII art) in a type file
    File BurgerArt = new File("src\\main\\java\\edu\\bhscs\\Burger.txt");
    //The path is different between devices: for example, on a Macbook the directory is
    // src/main/java/edu/bhscs/Burger.txt
    // Scanner to read the file
    Scanner scana = null;
    try { // try and catch; it attempts a piece of code but allows continuation if there is an error
      // if file doesn't exist it outputs "no" instead
      scana = new Scanner(BurgerArt); // creates a scanner that reads the file
      while (scana.hasNextLine()) { // keeps printing the next row of text if it exists
        System.out.println(scana.nextLine());
      }
    } catch (FileNotFoundException e) { // catch runs when an error happens
      // (specifically FileNotFound in this example) in the try
      System.out.println("no");
    }
  }

  public void Draw() {
   drawbuns(true);
   drawvegetables();
   drawanimalproducts();
   drawbuns(false);
  }

  private void drawbuns(boolean top) {
    int s = 7;
    String a = "      ";
    for (int i = 0; i < 29; i++) { //top and bottom outline display
      a += "██";
    }
    if (top) {
      s = 0;
    } else {
      System.out.println(a);
    }
    for (int i = s; i <= s + 5; i++) {
      int amount = ((-1 * ((i - 6) * (i - 6)) + 42))/3; // math equation for the buns
      //automatic truncating is so nice
      String burgrow = "";
      for (int k = amount; k < 16; k++) { // repeats to add proper spacing
        burgrow += "  ";
      }
      amount = (amount * 2 ) + 1; // doubles values to make sure spacing is always even
      burgrow += "██"; // outline
      for (int j = 0; j < amount; j++) {
        if (sesame && ((i * j)) % (i + 2) == 0 && top) { //pseudorandom sesame seed generation
          burgrow += "▒▒";
        } else {
          burgrow += "▓▓";
        }
      }
      burgrow += "██"; // outline
      System.out.println(burgrow);
    }
    if (top) {
      System.out.println(a);
    }
  }
  private void drawvegetables() {
    if(lettuce) {
      int[] lengths = {15,16,16};
      for(int i = 0; i < 3; i++) {
        String burgrow = "";
        for (int k = lengths[i]; k < 16; k++) { // add proper spacing
          burgrow += "  ";
        }
        burgrow += "██"; // outline
        for (int j = 0; j < (lengths[i] * 2) + 1; j++) { //doubled again to guarantee even spacing
          if (i == 2 && tomato && (j - 2) % 10 <= 5) { //pseudorandom tomato generation
            burgrow += "▒▒";
          } else {
            burgrow += "▓▓";
          }
        }
        burgrow += "██"; // outline
        System.out.println(burgrow);
      }
    } else if (tomato) { //prints one row instead of 3
      String burgrow = "  "; //set spacing
      burgrow += "██"; // outline
      for (int j = 0; j < 31; j++) {
        if ((j - 2) % 10 <= 5) { // pseudorandom tomato distance generation
          burgrow += "▓▓";
        } else {
          burgrow += "▒▒";
        }
      }
      burgrow += "██"; // outline
      System.out.println(burgrow);
    }
  }
  private void drawanimalproducts() {
    for (int i = 0; i < 5; i++) {
      int[] lengths = {14, 15, 15, 15, 14};
      int[] cheesestart = {0, 9, 12};
      int[] cheeseend = {99,22,19};
      String burgrow = "";
      for (int k = lengths[i]; k < 16; k++) { // repeats to add proper spacing
        burgrow += "  ";
      }
      for (int j = 0; j < ((lengths[i] * 2) + 3); j++) { // doubled again to guarantee even spacing
        //notice I add 3 instead of 1 because this one doesn't have a border addition!
        if (i < 3 && cheese) { // set cheese generation
          if (j >= cheesestart[i] && j <= cheeseend[i]) {
            burgrow += "██";
          } else {
            if (i == 0 || i == 4 || (((i - 6) * (j / 2))) % (i + 3) == 0 || j == 0 || j == 32) {
              burgrow += "░░";
            } else {
              burgrow += "▒▒";
            }
          }
        } else {
          if (i == 0 || i == 4 || (((i - 6) * (j / 2))) % (i + 3) == 0 || j == 0 || j == 32) { //pseudo random darkspots..?
            burgrow += "░░";
          } else {
            burgrow += "▒▒";
          }
        }
      }
      System.out.println(burgrow);
    }

  }
}

