package edu.bhscs;

class MineSweeperSolver {

  int[][] board = new int[14][18];

  public int runTileCheck(FileWriter f, String path) {
    String[] referencelist = {
      "src\\main\\java\\edu\\bhscs\\defaultimages\\unklight.png",
      "src\\main\\java\\edu\\bhscs\\defaultimages\\unkdark.png",
      "src\\main\\java\\edu\\bhscs\\defaultimages\\klight.png",
      "src\\main\\java\\edu\\bhscs\\defaultimages\\kdark.png",
      "src\\main\\java\\edu\\bhscs\\defaultimages\\1dark.png",
      "src\\main\\java\\edu\\bhscs\\defaultimages\\1light.png",
      "src\\main\\java\\edu\\bhscs\\defaultimages\\2.png",
      "src\\main\\java\\edu\\bhscs\\defaultimages\\3.png",
      "src\\main\\java\\edu\\bhscs\\defaultimages\\4.png",
      "src\\main\\java\\edu\\bhscs\\defaultimages\\5.png",
    };
    int count = 0;
    int[] resultmap = {9, 9, 0, 0, 1, 1, 2, 3, 4, 5};
    for (String compitem : referencelist) {
      if (f.compareKeyPixel(path, compitem)) {
        return resultmap[count];
      }
      count++;
    }
    System.out.println("not found!!! " + path);
    return -1;
  }

  public void updateBoardFromImages(FileWriter f, String relapath) {

    for (int i = 0; i < 14; i++) { // y first
      for (int j = 0; j < 18; j++) { // prints across x before moving down
        String newPath = relapath + j + "_" + i + ".png"; // this is MIRRORED
        board[i][j] = runTileCheck(f, newPath);

        // from the screenshot order:
        /*
          s s
          v v
          v v
          v v
          v v

          to

          s > > > > >
          s > > > > >
        */

      }
    }
  }

  public void printGrid() {
    for (int i = 0; i < 14; i++) {
      for (int j = 0; j < 18; j++) {
        if (board[i][j] != 9) System.out.print(board[i][j] + " ");
        else System.out.print("-" + " ");
      }
      System.out.println();
    }
  }
}
