/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 10/1/2025
 *
 * DESCRIPTION: A cake with various assigned properties
 * INPUT: The wanted properties of a given cake
 * OUTPUT: Various information about the cake
 * EDGE CASES: Often the string-based properties will have gramatically incorrect phrases in viewcake
 */

package edu.bhscs;

class Cake {
  // FIELDS and PROPERTIES (a lot of them)
  String flavor;
  double sweetness;
  String toppings;
  int diameter;
  String shape;
  int height;
  int eatingprogress = 0;
  int weight;
  String owner;
  boolean existent;
  String name;
  int[] ingredients = {0, 0, 0, 0, 0};
  // I have no clue how to make a dictionary in Java,
  // so I will just use array instead :/
  double quality;
  double oprice;
  int craftquality;
  boolean alternatedef = false;

  double drawlt;
  double drawht;
  double drawcut;
  double drawangle;
  double drawperspective;

  // CONSTRUCTORS

  public Cake(boolean a) {
    if (a) {
      System.out.println("A new cake has been ordered! Please add information:");
    }
  }

  public Cake(String kindofcake, Flour flour, int bakerskill) {
    existent = true;
    alternatedef = true;
    name = kindofcake;
    ingredients[0] = flour.returnquantity();
    quality = flour.returnquality() - 1 + (((double) bakerskill) / 4);
    weight = ingredients[0];
    craftquality = bakerskill;
  }

  public void viewcake() {
    if (alternatedef) {
      System.out.println("------------------------------------------------------");
      System.out.println("Currently viewing a low definition cake:");
      System.out.println("Description: " + name);
      System.out.println("INGREDIENTS:");
      System.out.println("Flour: " + ingredients[0] + "g");
      System.out.println("May include: toppings, flavoring, preservatives.");
      System.out.println(
          "It has a quality rating of "
              + String.format("%.1f", quality)
              + ", made by a baker with experience level "
              + craftquality
              + ".");
      System.out.println("------------------------------------------------------");
      if (owner == null) {
        System.out.println("This cake has not been owned yet.");
      } else {
        System.out.println("This cake is owned by " + owner + ".");
        if (eatingprogress == 100) {
          System.out.println("They have finished the entire cake. Yummy!");
        } else {
          System.out.println("They have eaten " + eatingprogress + "% of this cake.");
          System.out.println(
              "It weighs " + (((100 - eatingprogress) * weight) / 100) + " grams right now.");
        }
      }
    } else {
      if (existent) {
        System.out.println("------------------------------------------------------");
        System.out.println("Currently viewing the cake " + name + ":");
        System.out.println("This cake has a " + shape + " shape.");
        System.out.print("The longest part of the cake is " + diameter + " inches wide,");
        System.out.println(" and it is " + height + " inches tall.");
        System.out.println("The cake has a " + flavor + " flavor.");
        System.out.println(
            "It has a sweetness rating of " + String.format("%.2f", sweetness) + ".");
        System.out.println("Finally, it is topped off with " + toppings + " toppings.");
        System.out.println("It weighs " + weight + " grams coming out of the store.");
        System.out.println(
            "It has a quality rating of "
                + String.format("%.1f", quality)
                + ", made by a baker with experience level "
                + craftquality
                + ".");
        System.out.println("------------------------------------------------------");
        if (owner == null) {
          System.out.println("This cake has not been purchased yet.");
        } else {
          System.out.println("This cake is owned by " + owner + ".");
          if (eatingprogress == 100) {
            System.out.println("They have finished the entire cake. Yummy!");
          } else {
            System.out.println("They have eaten " + eatingprogress + "% of this cake.");
            System.out.println(
                "It weighs " + (((100 - eatingprogress) * weight) / 100) + " grams right now.");
          }
        }
        System.out.println("------------------------------------------------------");
        System.out.println("INGREDIENTS:");
        System.out.println("Flour: " + ingredients[0] + "g");
        System.out.println("Eggs: " + ingredients[1] + " large");
        System.out.println("Butter: " + ingredients[2] + "g");
        System.out.println("Milk: " + ingredients[3] + "mL");
        System.out.println("Sugar: " + ingredients[4] + "g");
        System.out.println("May include: toppings, flavoring, preservatives.");
        System.out.println("------------------------------------------------------");
        System.out.println();
      } else {
        System.out.println("There is no cake!");
      }
    }
  }

  double getoprice() {
    return oprice;
  }

  public int ReturnAmountEaten() {
    return eatingprogress;
  }

  public int ReturnWeight() {
    return weight;
  }

  public boolean cakeexist() {
    return this.existent;
  }

  public String cakename() {
    return this.name;
  }

  public double returnquality() {
    return quality;
  }

  public void batchsetting(
      String givenflavor,
      double givensweetness,
      String giventoppings,
      String givenshape,
      int givendiameter,
      int givenheight,
      String givenname,
      int flouramount,
      int eggamount,
      int butteramount,
      int milkamount,
      int sugaramount,
      double predictedquality,
      double makeprice,
      int craftsmanship) {
    this.flavor = givenflavor;
    this.sweetness = givensweetness;
    this.toppings = giventoppings;
    this.shape = givenshape;
    this.diameter = givendiameter;
    this.height = givenheight;
    this.weight = (eggamount * 50) + butteramount + milkamount + sugaramount + flouramount;
    this.name = givenname;
    this.existent = true;
    ingredients[0] = flouramount;
    ingredients[1] = eggamount;
    ingredients[2] = butteramount;
    ingredients[3] = milkamount;
    ingredients[4] = sugaramount;
    quality = predictedquality;
    this.oprice = makeprice;
    this.craftquality = craftsmanship;
  }

  public void eatcake(int eatpercent) {
    this.eatingprogress += eatpercent;
    if (eatingprogress > 100) {
      this.eatingprogress = 100;
    }
  }

  public void SetCakeOwner(String name) {
    this.owner = name;
  }

  public void draw(double lt, double ht, double cut, double angle, double perspective, double diagprecision) {
    drawlt = lt;
    drawht = ht;
    drawcut = cut;
    drawangle = angle;
    drawperspective = perspective;
    // find all points of the cake
    double[] stct = {CartesianEllipseX(drawangle), CartesianEllipseY(drawangle)}; // start cut top
    double[] stcb = {
      CartesianEllipseX(drawangle),
      CartesianEllipseY(drawangle) - drawlt + topoffset() + baseoffset()
      // I don't know how to describe the formula for finding y value in plain english
      // I have a good visualization of it in Desmos though
    }; // start cut bottom
    double[] etct = {
      CartesianEllipseX(drawangle + drawcut), CartesianEllipseY(drawangle + drawcut)
    }; // end cut top
    double[] etcb = {
      CartesianEllipseX(drawangle + drawcut),
      CartesianEllipseY(drawangle + drawcut) - drawlt + topoffset() + baseoffset()
    }; // end cut bottom
    double[] cent = {drawlt, drawlt - topoffset()}; // center top
    double[] cenb = {drawlt, baseoffset()}; // center bottom

    // DBG
    // System.out.println(stct[0]);
    // System.out.println(stct[1]);
    // System.out.println(stcb[0]);
    // System.out.println(stcb[1]);
    // System.out.println(etct[0]);
    // System.out.println(etct[1]);
    // System.out.println(etcb[0]);
    // System.out.println(etcb[1]);
    // System.out.println(cent[0]);
    // System.out.println(cent[1]);
    // System.out.println(cenb[0]);
    // System.out.println(cenb[1]);
    // System.out.println();

    // find the minimum grid length of the cake needed
    double[] xcoordlst = {stct[0], stcb[0], etct[0], etcb[0], cent[0], cenb[0]};

    // Max value finder yada yada
    double solmin = Integer.MAX_VALUE;
    double solmax = Integer.MIN_VALUE;
    for (double value : xcoordlst) {
      if (value > solmax) {
        solmax = value;
      }
      if (value < solmin) {
        solmin = value;
      }
    }
    double xbound = solmax - solmin;
    // find the offset of the grid from the origin
    double xoff = solmin;
    // Account for if the cut start and end happen to be at the rightmost
    boolean rxedge = false;
    boolean lxedge = false;
    if (((drawangle + Math.PI) % (2 * Math.PI)) + drawcut > (2 * Math.PI)) {
      // right edge, accounts for first set
      rxedge = true;
      xbound = Math.max(xbound, (2 * drawlt) - xoff);
    }
    if (((drawangle) % (2 * Math.PI)) + drawcut > (2 * Math.PI)) {
      // left edge, accounts for other set
      lxedge = true;
      xbound = Math.max(xbound, solmax);
      // xoff additionally must be adjusted as left side impacts both
      xoff = 0;
    }
    if (rxedge && lxedge) {
      xbound = 2 * drawlt;
    }
    // System.out.println(xbound); // DBG
    // System.out.println(xoff);
    // System.out.println();
    // repeat with height function
    // find the minimum grid height

    // Max value finder yada yada
    // hmm I should REALLLLLLLYYYYY abstract the max value finder
    // maybe when I get less lazy

    // define all height points
    double[] ycoordlst = {stct[1], stcb[1], etct[1], etcb[1], cent[1], cenb[1]};

    solmin = Integer.MAX_VALUE;
    solmax = Integer.MIN_VALUE;
    for (double value : ycoordlst) {
      if (value > solmax) {
        solmax = value;
      }
      if (value < solmin) {
        solmin = value;
      }
    }

    double ybound = solmax - solmin;
    // find height offset
    double yoff = solmin;
    boolean byedge = false;
    boolean tyedge = false;

    // Account for if the cut start and end happen to cross the center:
    if (((drawangle + ((3 * Math.PI) / 2)) % (2 * Math.PI)) + drawcut > (2 * Math.PI)) {
      // bottom edge, accounts for first set
      byedge = true;
      ybound = Math.max(ybound, solmax);
      // adjust base y as necessary
      yoff = 0;
    }
    if (((drawangle + (Math.PI / 2)) % (2 * Math.PI)) + drawcut > (2 * Math.PI)) {
      // top edge, accounts for other set
      tyedge = true;
      ybound = Math.max(ybound, CartesianEllipseY(3 * Math.PI / 2) - baseoffset());
    }
    if (byedge && tyedge) {
      ybound = CartesianEllipseY(3 * Math.PI / 2);
    }

    // System.out.println(ybound); // DBG
    // System.out.println(yoff);
    // System.out.println();

    // create a 2d array of such size calculated above
    int xarraysz = (int) Math.floor(xbound) + 4;
    int yarraysz = (int) Math.floor(ybound) + 4;
    /*
     * Note that 4 additional rows are created!!! This is to account for possible points
     * just below the old int cutoff and for safety in case something happens with the top cutoff.
     * For example, boundary (4.9, 6.1) can result in a value ranging from 4 to 6
     * (size 3 array required) while the xbound is 2.2 (truncated to 2).
     * This would produce a massive error.
     * xoff and yoff need to be DECREASED by 1 respectively for this to work.
     * Otherwise, they can return -1 when values get rounded / truncated.
     */
    xoff--;
    yoff--;

    int[][] drawarray = new int[xarraysz][yarraysz];

    // System.out.println(xarraysz); // DBG
    // System.out.println(yarraysz);
    // System.out.println(drawarray.length);
    // System.out.println(drawarray[0].length);
    // System.out.println();

    // printarrayreverse(drawarray, "a", "b", "c", "d", "e"); //DBG

    // find boundaries of curves
    // this seems to only be an issue with the vertical curves and the top diagonal lines
    // in MOST situations (exception: cake slice passes the horizontal parallel or vertical
    // parallel)
    // this can be marked to save processing speed

    // identify applicable curves
    // this can be done by comparing the boundary vertical lines to the origin vertical lines
    // ex: if right vertical is greater than center vertical, right base diagonal would be hidden
    // repeat with left

    // draw applicable curves onto grid
    // the top 3 lines are ALWAYS drawn, let's start with those!

    double repeti;
    double tempoffset;
    int points;

    // TOP START LINE

    // find the correct point

    repeti = Math.abs(drawlt - CartesianEllipseX(drawangle)) + 2;
    tempoffset = Math.min(CartesianEllipseX(drawangle), drawlt) - 1;

    // System.out.println(repeti); // DBG
    // System.out.println(tempoffset);
    // System.out.println(topliney(drawlt));
    // System.out.println();

    double TSStart = tempoffset;
    double TSEnd = tempoffset + repeti;

    // to make sure all points are drawn:
    // amount of points needed depends on max of y and x times precision given
    points =
        (int) Math.floor(Math.max(Math.abs(cent[1] - stct[1]), Math.abs(cent[0] - stct[0])) * diagprecision);
    /*
     * This is here BECAUSE drawing normally (increment x by 1 OR draw using cartesian equations)
     * Would negate some points if the slope is too large. This is a more general fix for this issue
     * However to make it better I will also include a vertical line draw for values significantly
     * close to theta = kpi + pi/2 when I get the chance
     */

    for (double i = Math.floor(tempoffset);
        i <= (int) Math.ceil(tempoffset + repeti);
        i += (repeti / points)) {
      double ptc = i;
      if (ptc < Math.min(drawlt, CartesianEllipseX(drawangle))) { // check values are within bounds
        ptc = Math.min(drawlt, CartesianEllipseX(drawangle)); // if not make them be in bounds
      } else if (ptc > Math.max(drawlt, CartesianEllipseX(drawangle))) {
        ptc = Math.max(drawlt, CartesianEllipseX(drawangle));
      }
      double pty = topliney(ptc); // f(x)
      drawarray[(int) Math.round(ptc - xoff)][(int) Math.round(pty - yoff)] = 5;
    }
    // START LINE DONE

    // TOP END LINE
    repeti = Math.abs(drawlt - CartesianEllipseX(drawangle + drawcut)) + 2;
    tempoffset = Math.min(CartesianEllipseX(drawangle + drawcut), drawlt) - 1;

    // System.out.println(repeti); // DBG
    // System.out.println(tempoffset);
    // System.out.println(topliney(drawlt));
    // System.out.println();

    double TEStart = tempoffset;
    double TEEnd = tempoffset + repeti;

    points =
        (int) Math.floor(Math.max(Math.abs(cent[1] - etct[1]), Math.abs(cent[0] - etct[0])) * diagprecision);

    for (double i = Math.floor(tempoffset);
        i <= (int) Math.ceil(tempoffset + repeti);
        i += (repeti / points)) {
      double ptc = i;
      if (ptc
          < Math.min(
              drawlt, CartesianEllipseX(drawangle + drawcut))) { // check values are within bounds
        ptc =
            Math.min(
                drawlt, CartesianEllipseX(drawangle + drawcut)); // if not make them be in bounds
      } else if (ptc > Math.max(drawlt, CartesianEllipseX(drawangle + drawcut))) {
        ptc = Math.max(drawlt, CartesianEllipseX(drawangle + drawcut));
      }
      double pty = endtopliney(ptc); // f(x)
      //System.out.println("(" + (ptc - xoff) + ", " + (pty - yoff) + ")");
      drawarray[(int) Math.round(ptc - xoff)][(int) Math.round(pty - yoff)] = 5;
    }

    // TOP END LINE DONE

    // TOP CIRCLE
    double detail = 1.25;
    repeti = Math.floor(detail * drawlt * drawcut); // creates marfkers along the ellipse
    // gives approximately 1 marker per
    for (int i = 1; i <= repeti; i++) {
      double idtheta = (i / (detail * drawlt)) + drawangle;
      drawarray[(int) Math.round(CartesianEllipseX(idtheta) - xoff)][
              (int) Math.round(CartesianEllipseY(idtheta) - yoff)] =
          5;
      // System.out.println("(" + (int) Math.round(CartesianEllipseX(idtheta)) + ", " + (int)
      // Math.round(CartesianEllipseY(idtheta)) + ")");
    }
    // TOP CIRCLE DONE

    // Here is where line drawing meets conditions. Starting with the simplist, vertical lines
    // This is drawn when the slice doesn't pass through the 2kpi + pi/2 mark

    // CENTER VERTICAL
    if (!(((drawangle + (3 * Math.PI / 2)) % (2 * Math.PI)) + drawcut > 2 * Math.PI)) {
      for (double i = Math.round(cenb[1]); i <= Math.round(cent[1]); i++) {
        drawarray[(int) Math.round(drawlt - xoff)][(int) (i - yoff)] = 5;
      }
    }
    // CENTER VERTICAL DONE

    // The outer start cut is not drawn between theta = 3pi/2 and theta = 2pi
    // Account for the top end diagonal being annoying

    // START CUT VERTICAL
    if (!((drawangle % (2 * Math.PI)) > (3 * Math.PI / 2))) {
      for (double i = Math.round(stcb[1]); i <= Math.round(stct[1]); i++) {
        if (!(stcb[0] > TEStart
            && stcb[0] < TEEnd
            && // Must be within the bounds of the top line first of all
            i < endtopliney(stcb[0])
            && // Then must be less than top of the line
            (drawangle % (2 * Math.PI)) > Math.PI)) { // If it's facing you, you can always see it
          drawarray[(int) Math.round(stcb[0] - xoff)][(int) (i - yoff)] = 5;
        }
      }
    }
    // START CUT VERTICAL DONE

    // the outer end cut is not drawn between theta = pi and theta = 3pi/2
    // account for the top start diagonal being in the way

    // END CUT VERTICAL
    // System.out.println("asdjbsiudhiuvhsdiuzhuaihs"); //DBG
    // System.out.println(drawangle + drawcut);

    if (!(((drawangle + drawcut) % (2 * Math.PI)) < (3 * Math.PI / 2)
        && ((drawangle + drawcut) % (2 * Math.PI)) > (Math.PI))) {
      for (double i = Math.round(etcb[1]); i <= Math.round(etct[1]); i++) {
        if (!(etcb[0] > TSStart
            && etcb[0] < TSEnd
            && i < topliney(etcb[0])
            && ((drawangle + drawcut) % (2 * Math.PI)) > Math.PI)) {
          //System.out.println("yes this does run"); //DBG
          drawarray[(int) Math.round(etcb[0] - xoff)][(int) (i - yoff)] = 5;
        }
      }
    }
    // END CUT VERTICAL DONE

    // right and left perspective edges: We use the true/false we found earlier

    // RIGHT VERTICAL CLIP

    if (rxedge) {
      for (double i = Math.round(CartesianEllipseY(Math.PI) - topbottomoffset());
          i <= Math.round(CartesianEllipseY(Math.PI));
          i++) {
        drawarray[(int) Math.round((2 * drawlt) - xoff)][(int) (i - yoff)] = 5;
      }
    }
    // RIGHT VERTICAL CLIP DONE
    // LEFT VERTICAL CLIP
    if (lxedge) {
      for (double i = Math.round(CartesianEllipseY(0) - topbottomoffset());
          i <= Math.round(CartesianEllipseY(0));
          i++) {
        drawarray[(int) Math.round(0 - xoff)][(int) (i - yoff)] = 5;
      }
    }

    // LEFT VERTICAL CLIP DONE

    // Conditions now get a little messy with diagonals. They are just the previous ones but shifted
    // Bottom start line is hidden between 3pi/2 to pi/2
    // Notice how the other line has exactly the opposite conditions, so I can just use this if
    // condition for both!
    // BE CAUTIOUS HERE: if the cake is set to draw a large enough slice that wraps around, the
    // bottom could get
    // covered up. In this case, we need to account for this by negating anything below the other
    // (top) line
    // Kind of like a cross parameter
    // Bottom front aligns with top end, Bottom end aligns with top start
    // REMEMBER that this is also opposite on the opposing side!

    // BOTTOM DIAGONALS
    if (!((drawangle % (2 * Math.PI) > (3 * Math.PI / 2))
        || (drawangle % (2 * Math.PI) < (Math.PI / 2)))) {
      repeti = Math.abs(drawlt - CartesianEllipseX(drawangle)) + 2;
      tempoffset = Math.min(CartesianEllipseX(drawangle), drawlt) - 1;

      // System.out.println(repeti); // DBG
      // System.out.println(tempoffset);
      // System.out.println(topliney(drawlt));
      // System.out.println("idahsidhaihasidfh");
      // System.out.println();

      points =
          (int) Math.floor(Math.max(Math.abs(cent[1] - stct[1]), Math.abs(cent[0] - stct[0])) * diagprecision);

      for (double i = Math.floor(tempoffset);
          i <= (int) Math.ceil(tempoffset + repeti);
          i += (repeti / points)) {
        double ptc = i;
        if (ptc
            < Math.min(drawlt, CartesianEllipseX(drawangle))) { // check values are within bounds
          ptc = Math.min(drawlt, CartesianEllipseX(drawangle)); // if not make them be in bounds
        } else if (ptc > Math.max(drawlt, CartesianEllipseX(drawangle))) {
          ptc = Math.max(drawlt, CartesianEllipseX(drawangle));
        }
        double pty = topliney(ptc) - topbottomoffset(); // THIS IS THE ONLY OTHER CHANGE!
        // Y VALUE IS SUBTRACTED BY OFFSET TO ALLIGN WITH BOTTOM ELLIPSE!
        if (!(ptc > TEStart
            && ptc < TEEnd
            && // within range
            pty < endtopliney(ptc)
            && // smaller than top line
            (endtopliney(ptc)) //This needs to be true here
                <= topliney(ptc))) { // and is above it significantly (in terms of equal plane)
          drawarray[(int) Math.round(ptc - xoff)][(int) Math.round(pty - yoff)] = 5;
          // System.out.println("Super success");
          // System.out.println(endtopliney(ptc) + 2);
          // System.out.println(topliney(ptc));
          // System.out.println(ptc > TEStart);
          // System.out.println(ptc < TEEnd);
          // System.out.println(pty < endtopliney(ptc));
          // System.out.println((endtopliney(ptc) - 0.01) <= topliney(ptc));
        } else {
          // System.out.println("bruh epic fail");
          // System.out.println(ptc);
          // System.out.println(TEEnd);
          // System.out.println(ptc > TEStart);
          // System.out.println(ptc < TEEnd);
          // System.out.println(pty < endtopliney(ptc));
          // System.out.println((endtopliney(ptc) - 0.01) <= topliney(ptc));
          // System.out.println();
        }
      }

      repeti = Math.abs(drawlt - CartesianEllipseX(drawangle + drawcut)) + 2;
      tempoffset = Math.min(CartesianEllipseX(drawangle + drawcut), drawlt) - 1;
    }
    if ((((drawangle + drawcut) % (2 * Math.PI) > (3 * Math.PI / 2))
        || (drawangle + drawcut) % (2 * Math.PI) < (Math.PI / 2))) {
      repeti = Math.abs(drawlt - CartesianEllipseX(drawangle + drawcut)) + 2;
      tempoffset = Math.min(CartesianEllipseX(drawangle + drawcut), drawlt) - 1;

      // System.out.println(repeti); // DBG
      // System.out.println(tempoffset);
      // System.out.println(topliney(drawlt));
      // System.out.println();

      points =
          (int) Math.floor(Math.max(Math.abs(cent[1] - etct[1]), Math.abs(cent[0] - etct[0])) * diagprecision);

      for (double i = Math.floor(tempoffset);
          i <= (int) Math.ceil(tempoffset + repeti);
          i += (repeti / points)) {
        double ptc = i;
        if (ptc
            < Math.min(
                drawlt, CartesianEllipseX(drawangle + drawcut))) { // check values are within bounds
          ptc =
              Math.min(
                  drawlt, CartesianEllipseX(drawangle + drawcut)); // if not make them be in bounds
        } else if (ptc > Math.max(drawlt, CartesianEllipseX(drawangle + drawcut))) {
          ptc = Math.max(drawlt, CartesianEllipseX(drawangle + drawcut));
        }
        double pty = endtopliney(ptc) - topbottomoffset(); // again, ONLY SIGNIFICANT CHANGE!!!!!!
        if (!(ptc > TSStart
            && ptc < TSEnd
            && // within range
            pty < topliney(ptc)
            && // smaller than top line
            endtopliney(ptc) >= topliney(ptc))) { // and is above it (in terms of equal plane)
          drawarray[(int) Math.round(ptc - xoff)][(int) Math.round(pty - yoff)] = 5;
        }
      }
    }
    // BOTTOM DIAGONALS DONE

    // Okay, time for the hardest conditional
    // The bottom ellipse
    // Must account for clipping on both edges, full cake loops, and more.
    // I think the best way to do this is to attempt to draw along the entirety,
    // and filter sectors that don't fit.

    // BOTTOM ELLIPSE!!!
    repeti = Math.floor(detail * drawlt * drawcut); // creates markers along the ellipse
    // gives approximately 1 marker per grid unit
    for (int i = 1; i <= repeti; i++) {
      double idtheta = (i / (detail * drawlt)) + drawangle;
      if (!(idtheta % (2 * Math.PI) > Math.PI)) { // stops drawing if the portion is hidden
        drawarray[(int) Math.round(CartesianEllipseX(idtheta) - xoff)][
                (int) Math.round(CartesianEllipseY(idtheta) - yoff - topbottomoffset())] =
            5;
      }
    }
    // BOTTOM ELLIPSE DONE!!!!

    // done by plugging associated integer values with offset fould earlier for y coordinate
    // please use cartesian equations as much as possible
    // have a different marker for each curve for the next step
    // draw from bottom to top or give priority for each marker: top > edge > inside

    printarrayreverse(drawarray, "aa", "bb", "cc", "dd", "ee"); // DBG

    // Fill passthrough
    // loop from top to bottom of array, the markers made above define the boundaries of which to
    // draw from

    // print the cake row by row

  }

  private double topbottomoffset() {
    return drawlt - topoffset() - (drawlt * Math.sin(drawperspective));
  }

  private double topslope(double angle) {
    double th = drawlt - topoffset() - CartesianEllipseY(angle); // y2 / y1
    double oth = drawlt - CartesianEllipseX(angle); // x2 / x1
    return (th / oth);
  }

  private double endtopliney(double inputx) {
    return (topslope(drawangle + drawcut) * (inputx - drawlt)) + drawlt - topoffset();
  }

  private double topliney(double inputx) {
    return (topslope(drawangle) * (inputx - drawlt)) + drawlt - topoffset();
  }

  private double topoffset() {
    return ((drawlt - drawht) * (1 - Math.sin(drawperspective)));
  }

  private double baseoffset() {
    // NOTE: base offset is also used for the verital major axis
    return (drawlt * Math.sin(drawperspective));
  }

  private double CartesianEllipseX(double inputradians) {
    return (drawlt + (drawlt * Math.cos(inputradians + Math.PI)));
  }

  private double CartesianEllipseY(double inputradians) {
    return (drawlt
        - topoffset()
        + (drawlt * Math.sin(drawperspective) * Math.sin(inputradians + Math.PI)));
  }

  private void printarrayreverse(
      int[][] array, String v0, String v1, String v2, String v3, String v4) {
    // Starts at (0,y) then moves as read
    // array printing yada yada pretty simple
    for (int i = array[0].length - 1; i >= 0; i--) {
      for (int j = 0; j <= array.length - 1; j++) {
        if (array[j][i] == 0) {
          System.out.print(v0);
        } else if (array[j][i] == 1) {
          System.out.print(v1);
        } else if (array[j][i] == 2) {
          System.out.print(v2);
        } else if (array[j][i] == 3) {
          System.out.print(v3);
        } else if (array[j][i] == 4) {
          System.out.print(v4);
        } else {
          System.out.print("MM");
        }
      }
      System.out.println("");
    }
  }
}
