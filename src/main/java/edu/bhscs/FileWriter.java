package edu.bhscs;

import java.awt.image.BufferedImage;
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

  public void saveSubImage(String filepath, String savepath) {
    try {
      BufferedImage file = ImageIO.read(new File(filepath));
      File f = new File(savepath);
      file = file.getSubimage((file.getWidth() / 2), (3 * file.getHeight() / 4) - 2, 5, 5);
      ImageIO.write(file, "PNG", f);

    } catch (IOException ex) {
      System.out.println("this file is bad ://////");
    }
  }

  public boolean compareKeyPixel(String filepatha, String filepathb) {
    try {
      BufferedImage fim = ImageIO.read(new File(filepatha));

      BufferedImage cim = ImageIO.read(new File(filepathb));

      int activeia = (fim.getWidth() / 2) + 2;
      int activeib = 3 * fim.getHeight() / 4;
      int sourceia = (cim.getWidth() / 2) + 2;
      int sourceib = 3 * cim.getHeight() / 4;

      int aargb = cim.getRGB(sourceia, sourceib);
      int bargb = fim.getRGB(activeia, activeib);

      // System.out.println(cim.getRGB(sourceia, sourceib));
      // System.out.println(fim.getRGB(activeia, activeib));

      int ra = (aargb >> 16) & 0xff;
      int ga = (aargb >> 8) & 0xff;
      int ba = (aargb >> 0) & 0xff;

      int rb = (bargb >> 16) & 0xff;
      int gb = (bargb >> 8) & 0xff;
      int bb = (bargb >> 0) & 0xff;

      System.out.println(ra + " " + ga + " " + ba);
      System.out.println(rb + " " + gb + " " + bb);

      int erar = Math.abs(ra - rb) + Math.abs(ga - gb) + Math.abs(ba - bb);

      if (erar <= 15) {
        return true;
      }
      return false;
    } catch (IOException a) {
      System.out.println("one or both of ur files are bad");
      a.printStackTrace();
      return false;
    }
  }

  public void capturegrid(Grid g, int xlen, int ylen, String relapath, Roboclass r) {

    for (int i = 0; i < xlen; i++) {
      for (int j = 0; j < ylen; j++) {
        String newPath = relapath + i + "_" + j + ".png";
        // System.out.println(newPath);
        cloneSavePixels(
            r,
            g.getCoordinate(i, j)[0],
            g.getCoordinate(i, j)[1],
            g.getXSpacing(),
            g.getYSpacing(),
            newPath);
      }
    }

    String newPath = relapath + "FullGrid.png";
    cloneSavePixels(
        r,
        g.getCoordinate(0, 0)[0],
        g.getCoordinate(0, 0)[1],
        xlen * g.getXSpacing(),
        ylen * g.getYSpacing(),
        newPath);
  }
}
