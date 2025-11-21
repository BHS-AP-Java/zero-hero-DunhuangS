package edu.bhscs;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class FileWriter {

  public void cloneSavePixels(
      Roboclass r, int startx, int starty, int lenx, int leny, String filepath) {
    try {
      File f = new File(filepath);
      ImageIO.write(r.cloneDisplayPixels(startx, starty, lenx, leny), "PNG", f);
    } catch (IOException i) {
      System.out.println("ur file is bad :(");
      i.printStackTrace();
    }
  }
}
