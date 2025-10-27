package edu.bhscs;

class Table {
  //FIELDS AND PROPERTIES
  int size;
  int legs;

  //CONSTRUCTORs
  Table(int legs, int size) {
    this.size = size;
    this.legs = legs;
  }

  //METHODS
  public void draw(int cakesize) {
    int cakecen = (cakesize + 1) / 2;
    /*
     * center of cake: example = = = = =
     * 5 items                     ^
     * size + 1 / 2 is item 3, the center
     */
    int cakestart = cakecen - ((int) Math.floor((size) / 2)); //locates start position of cake
    //half rounded down
  }
}
