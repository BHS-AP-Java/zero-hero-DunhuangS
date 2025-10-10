package edu.bhscs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Burger {
  //FIELDS AND PROPERTIES
  boolean existent = false;
  int eatingpercent = 0;

  //CONSTRUCTORS
  public Burger() {
    existent = true;
  }
  //METHODS
  public void beEaten(int eatinpercent) {
    eatingpercent += eatinpercent;
    if (eatingpercent > 100) {
      this.eatingpercent = 100;
    }
  }
  public void DrawAWholeMassiveWhoppingHolyWhatTheBurgerOhMy() {
    //This is the path to the file I want to output (burger ASCII art) in a type file
    File BurgerArt = new File("src\\main\\java\\edu\\bhscs\\Burger.txt");
    //Scanner to read the file
    Scanner scana = null;
    try { //try and catch; it attempts a piece of code but allows continuation if there is an error
      //if file doesn't exist it outputs "no" instead
      scana = new Scanner(BurgerArt); //creates a scanner that reads the file
      while (scana.hasNextLine()) { //keeps printing the next row of text if it exists
        System.out.println(scana.nextLine());
      }
    } catch (FileNotFoundException e) { //catch runs when an error happens
      //(specifically FileNotFound in this example) in the try
      System.out.println("no");
    }
  }

  public void Draw() {
    
  }
}