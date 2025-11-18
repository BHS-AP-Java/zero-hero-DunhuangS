package edu.bhscs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

class Roboclass {
  // fieldspropertiesand
  private int clicks = 0;

  // default constructor?

  // methods
  public void click(int cx, int cy) {
    try {

      Robot r = new Robot();
      r.mouseMove(cx, cy);
      r.delay(50);
      r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
      r.delay(50);
      r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
      r.delay(25);

      clicks += 1;
    } catch (AWTException e) {
      System.out.println("nonono no robots in my system no pls");
    }
  }

  public int countClicks() {
    return clicks;
  }
}
