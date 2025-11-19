package edu.bhscs;

public class MoreApplication {

  public static void main(String[] args) throws InterruptedException {
    Roboclass r = new Roboclass();
    Thread.sleep(3000);
    System.out.println(r.getMouseLocation()[0]);
    System.out.println(r.getMouseLocation()[1]);
    Grid snaekGryd = new Grid(627,258,30,30);
    //627, 258
    //657, 258

    for(int i = 0; i < 18; i++) {
      for (int j = 0; j < 14; j++) {
        r.click(snaekGryd,i, j);
      }
    }


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
