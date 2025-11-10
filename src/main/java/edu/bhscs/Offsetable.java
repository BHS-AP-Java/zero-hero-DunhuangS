/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 11/3/2025
 *
 * DESCRIPTION: Interfaces to implement into other classes
 * INPUT: nothing
 * OUTPUT: I'm not really sure what it exactly "outputs"
 * EDGE CASES: I'm not familiar enough with implements and interfaces to know
 * Probably only inputting wrong types
 */

package edu.bhscs;

interface MyInterfaces {
  public void printwidth(int a);
}

public interface Offsetable {
  int getWidth();

  // Default centering logic — always clamps to 0 so alignment never goes negative.
  default int getOffset(Offsetable below) {
    if (below == null) return 0;
    return Math.max(0, (below.getWidth() - this.getWidth()) / 2);
  }

  // Each Offsetable thing knows how to draw itself
  // relative to whatever is beneath it.
  void draw(Offsetable below);
}
