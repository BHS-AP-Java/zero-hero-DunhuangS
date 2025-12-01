package edu.bhscs;

public class MoreApplication {

  public static void main(String[] args) throws InterruptedException {
    Roboclass r = new Roboclass();
    // for(int i = 0; i < 1000; i++) {
    // Thread.sleep(3000);
    System.out.println(r.getMouseLocation()[0]);
    System.out.println(r.getMouseLocation()[1]);
    // }
    FileWriter f = new FileWriter();
    String relapath = "src\\main\\java\\edu\\bhscs\\scrinshaws\\";
    String referencepath = "src\\main\\java\\edu\\bhscs\\defaultimages\\unklight.png";
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

    // f.compareKeyPixel(relapath + "0_2.png", referencelist[4]);
    f.saveSubImage(relapath + "0_2.png", relapath + "testing01.png");
    f.saveSubImage(referencelist[4], relapath + "testing02.png");

    MineSweeperSolver asdij = new MineSweeperSolver();

    asdij.updateBoardFromImages(f, relapath);
    asdij.printGrid();

    // Grid snaekGryd = new Grid(739, 257, 30, 30);
    // for (String ref : referencelist) {
    //   if (f.compareKeyPixel(relapath + "6_2.png", ref)) {
    //     System.out.println("yahoo");
    //   } else {
    //     System.out.println("boohoo");
    //   }
    // }

    // r.moveMouse(627,258);
    // 627, 258
    // 657, 258

    // f.capturegrid(snaekGryd, 18, 14, relapath, r);

    // for (int i = 0; i < 10; i++) {
    //   r.type("right");
    //   Thread.sleep(300);
    //   r.type("up");
    //   Thread.sleep(300);
    //   r.type("left");
    //   Thread.sleep(300);
    //   r.type("down");
    //   Thread.sleep(300);
    // }

    // r.click(50, 50);
    // for (int i = 0; i < 30; i++) {
    //   if (i % 3 == 0 || i % 5 == 0) {
    //     continue;
    //   }
    //   r.click(i * 50, i * 25);
    // }
    System.out.println(r.countClicks());
  }
}
