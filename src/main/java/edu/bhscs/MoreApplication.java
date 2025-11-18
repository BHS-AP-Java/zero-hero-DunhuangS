package edu.bhscs;

public class MoreApplication {

  public static void main(String[] args) {
    Roboclass r = new Roboclass();
    r.click(50, 50);
    for (int i = 0; i < 30; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        continue;
      }
      r.click(i * 50, i * 25);
    }
    System.out.println(r.countClicks());
  }
}
