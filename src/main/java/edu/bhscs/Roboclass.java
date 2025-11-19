package edu.bhscs;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

class Roboclass {
  // fieldspropertiesand
  private int clicks = 0;

  // default constructor?

  // methods
  private void runFailSafe() {
    if(MouseInfo.getPointerInfo().getLocation().getY() < 10) {
      System.exit(0);
    }
  }

  public int[] getMouseLocation() {
    int[] outlist = {(int) MouseInfo.getPointerInfo().getLocation().getX(),
      (int) MouseInfo.getPointerInfo().getLocation().getY()};
    return outlist;
  }

  public void click(int cx, int cy) {
    try {

      Robot r = new Robot();
      r.mouseMove(cx, cy);
      r.delay(50);
      runFailSafe();

      r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
      r.delay(50);
      runFailSafe();

      r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
      r.delay(25);

      clicks += 1;
    } catch (AWTException e) {
      System.out.println("nonono no robots in my system pls");
    }
  }

  public void click(Grid g, int gx, int gy) {
    click(g.getCoordinate(gx, gy)[0], g.getCoordinate(gx, gy)[1]);
  }

  public void type(String key) {
    try {

      runFailSafe();

      Robot r = new Robot();
      if (key.equals("left")) {
        r.keyPress(KeyEvent.VK_LEFT);
        r.delay(15);
        r.keyRelease(KeyEvent.VK_LEFT);
      } else if (key.equals("right")) {
        r.keyPress(KeyEvent.VK_RIGHT);
        r.delay(15);
        r.keyRelease(KeyEvent.VK_RIGHT);
      } else if (key.equals("up")) {
        r.keyPress(KeyEvent.VK_UP);
        r.delay(15);
        r.keyRelease(KeyEvent.VK_UP);
      } else if (key.equals("down")) {
        r.keyPress(KeyEvent.VK_DOWN);
        r.delay(15);
        r.keyRelease(KeyEvent.VK_DOWN);
      }

      clicks += 1;
    } catch (AWTException e) {
      System.out.println("nonono no robots in my system pls");
    }
  }

  public int countClicks() {
    return clicks;
  }
}
