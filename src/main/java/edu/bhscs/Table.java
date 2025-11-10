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

class Table implements Offsetable {
  // FIELDS AND PROPERTIES
  int size;
  int legs;
  int height = 10;
  String TableTxt = "HelloWrld";
  String LegTxt = "INI";
  int tablestart;
  int cakecen;
  int legTxtOrder = 0;

  // CONSTRUCTORs
  Table(int legs, int size) {
    this.size = (size * 3);
    this.legs = legs;
  }

  // MMETHODS

  @Override
  public int getWidth() {
    return size;
  }

  @Override
  public void draw(Offsetable below) {
    tablestart = getOffset(below);
    cakecen = ((below.getWidth() + 1) / 2) + tablestart;
    draw();
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

    cakecen = ((cakesize + 1) / 2) + getOffset(this);
    tablestart = getOffset(this); // locates start position of cake
    // half rounded down

    legTxtOrder = 0; // used to order leg text, as the table legs aren't continuous
    // unlike the tabletop
    draw();
  }
  public void draw() {
    // checks if start is below 0
    if (tablestart < 0) { // make it in bounds
      tablestart = 0;
    }
    // TECHNICALLY not necessary as the for loop condition would always be false anyways

    // top of the table
    drawspacing(tablestart);
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

        drawspacing(tablestart);

        // legTxtOrder = 0;

        drawspacing((int) cakecen - (LegTxt.length() / 4)); // space to center
        for (int j = 0; j < LegTxt.length(); j++) { // then draw the leg
          System.out.print(
              LegTxt.substring(legTxtOrder % LegTxt.length(), (legTxtOrder % LegTxt.length()) + 1));
          legTxtOrder++;
        }
        System.out.println(); // new ln
      }
      // put in center if legs = 1
    } else {
      double spacing =
          (double) ((double) ((size * 2) - (legs * LegTxt.length())) / (double) (legs - 1))
              + LegTxt.length()
              - 0.0000001;
      // this is to account for repeating decimals - storage limit prevents actual value reflected
      // and defaults to rounding up! Storage is 16 "bytes" but I dont really care about
      // flooring the last digit exactly, so I will do a generous subtraction
      // who makes a table with 10^8 legs anyways
      // welp I guess that is an edge case now
      // System.out.println(spacing);
      // System.out.println(size);

      for (int i = 0; i < height; i++) {
        // With the new update, this is now needed~~

        legTxtOrder = 0;

        drawspacing(tablestart); // spacing for the table
        for (int j = 0; j < size * 2; j++) { // repeats for size of table
          if (Math.floor(((double) j) % spacing) < (LegTxt.length())) { // if we calculated spacing
            // from before, and it matches we draw
            // we print at the start few char
            System.out.print(
                LegTxt.substring(
                    legTxtOrder % LegTxt.length(), (legTxtOrder % LegTxt.length()) + 1));
            legTxtOrder++;
            // System.out.println(j);
          } else { // if not spacing, skip
            System.out.print(" ");
          }
        }
        System.out.println();
      }
    }
  }
}
