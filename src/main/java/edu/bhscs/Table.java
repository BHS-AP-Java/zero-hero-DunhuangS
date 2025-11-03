/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 11/3/2025
 *
 * DESCRIPTION: Draws a 2D table which the cake sits ontop of
 * INPUT: tabke length, number of legs, offset of the cake, length of the cake
 * OUTPUT: a table printed in the terminal
 * EDGE CASES: Table can be too long and wraps around the edge of the screen,
 * miscounts the legs at absurdly high numbers of legs
 */
package edu.bhscs;

class Table {
  // FIELDS AND PROPERTIES
  int size;
  int legs;
  int height = 10;
  String TableTxt = "HelloWrld";
  String LegTxt = "INI";
  offsetable a = new offsetable();

  // CONSTRUCTORs
  Table(int legs, int size) {
    this.size = (size * 3);
    this.legs = legs;
  }

  public int getSize() {
    return size;
  }

  public void setLegs(String legs) {
    this.LegTxt = legs;
  }

  public void setTop(String top) {
    this.TableTxt = top;
  }

  // METHODS
  private void drawspacing(int cakestart) {
    for (int i = 0; i < cakestart; i++) {
      System.out.print("  ");
    }
  }

  public void draw(int cakesize) {

    int cakecen = (cakesize + 1) / 2;
    /*
     * center of cake: example = = = = =
     * 5 items                     ^
     * I have programmed it in a way where cakesize should always be odd
     * size + 1 / 2 is item 3, the center (6/2=3)
     */
    int cakestart = cakecen - ((int) Math.floor((size) / 2)); // locates start position of cake
    // half rounded down

    int legTxtOrder = 0; // used to order leg text, as the table legs aren't continuous
    // unlike the tabletop

    // checks if start is below 0
    if (cakestart < 0) { // make it in bounds
      cakestart = 0;
    }
    //TECHNICALLY not necessary as the for loop condition would always be false anyways

    // top of the table
    a.printwidth(cakestart);
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(
            (String)
                TableTxt.substring(
                    ((2 * i + j) % TableTxt.length()), ((2 * i + j) % TableTxt.length()) + 1));
      }
      // System.out.print("==");
    }
    System.out.println();
    // legs of the table
    if (legs == 1) {
      for (int i = 0; i < height; i++) { // repeat for height

        // legTxtOrder = 0;

        a.printwidth(cakecen); // space to center
        for (int j = 0; j < 2; j++) { // then draw the leg
          System.out.print(
              LegTxt.substring(legTxtOrder % LegTxt.length(), (legTxtOrder % LegTxt.length()) + 1));
          legTxtOrder++;
        }
        System.out.println(); // new ln
      }
      // put in center if legs = 1
    } else {
      double spacing = ((double) (size - 1) / (double) (legs - 1)) - 0.0000001;
      // this is to account for repeating decimals - storage limit prevents actual value reflected
      // and defaults to rounding up! Storage is 16 "bytes" but I dont really care about
      // flooring the last digit exactly, so I will do a generous subtraction
      // who makes a table with 10^8 legs anyways
      // welp I guess that is an edge case now
      // System.out.println(spacing);
      // System.out.println(size);
      for (int i = 0; i < height; i++) {
        // I am not sure if I should reset the order of the leg text per loop
        // I am not going to do it for now because I think its better without

        // legTxtOrder = 0;

        drawspacing(cakestart); // spacing for the table
        for (int j = 0; j < size; j++) { // repeats for size of table
          if (0 == Math.floor(((double) j) % spacing)) { // if we calculated spacing
            // from before, and it matches we draw
            for (int k = 0; k < 2; k++) { // draw loop (my table is char / length)
              System.out.print(
                  LegTxt.substring(
                      legTxtOrder % LegTxt.length(), (legTxtOrder % LegTxt.length()) + 1));
              legTxtOrder++;
            }
            // System.out.println(j);
          } else { // if not spacing, skip
            System.out.print("  ");
          }
        }
        System.out.println();
      }
    }
  }
}
