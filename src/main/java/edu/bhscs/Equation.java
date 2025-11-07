package edu.bhscs;

class Equation {
  // FIELDS AND PROPERTIES
  double slope, yoff;
  double vstretch, xoff;
  double xmajor, ymajor;
  boolean quadratic, linear, ellipse = false;
  boolean polar = false;

  // CONSTRUCTORS
  public Equation(double slope, double yoff) {
    // Input linear as mx + b
    linear = true;
    this.slope = slope;
    this.yoff = yoff;
  }

  public Equation(double x1, double y1, double slope) {
    // Input linear as m(x-x1) + y1
    // mx - x1m + y1
    // offset = y1 - x1m
    linear = true;
    this.slope = slope;
    this.yoff = y1 - (x1 * slope);
  }

  public Equation(double vstretch, double xoff, double yoff, int a) {
    // Input quatdratic as a(x-h)^2 + k
    this.vstretch = vstretch;
    this.xoff = xoff;
    this.yoff = yoff;
  }

  // METHODS
  public int findyvalue() {}
}
