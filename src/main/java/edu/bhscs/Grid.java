package edu.bhscs;

class Grid {
  private int startx, starty;
  private int xspacing, yspacing;

  public Grid(int stx, int sty, int xspac, int yspac) {
    startx = stx;
    starty = sty;
    xspacing = xspac;
    yspacing = yspac;
  }

  public int[] getCoordinate(int xval, int yval) {
    int[] outlist = {(startx + (xval * xspacing)), (starty + (yval * yspacing))};
    return outlist;
  }

  public int getXSpacing() {
    return xspacing;
  }

  public int getYSpacing() {
    return yspacing;
  }
}
