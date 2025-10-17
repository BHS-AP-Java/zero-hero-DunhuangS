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

  public void draw(double lt, double ht, double cut, double angle, double perspective) {
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
    System.out.println(stct[0]);
    System.out.println(stct[1]);
    System.out.println(stcb[0]);
    System.out.println(stcb[1]);
    System.out.println(etct[0]);
    System.out.println(etct[1]);
    System.out.println(etcb[0]);
    System.out.println(etcb[1]);
    System.out.println(cent[0]);
    System.out.println(cent[1]);
    System.out.println(cenb[0]);
    System.out.println(cenb[1]);
    System.out.println();

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
    System.out.println(xbound); // DBG
    System.out.println(xoff);
    System.out.println();
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
      lxedge = true;
      ybound = Math.max(ybound, drawlt - topoffset() + baseoffset());
    }
    System.out.println(ybound); // DBG
    System.out.println(yoff);
    System.out.println();

    // create a 2d array of such size calculated above
    int xarraysz = (int) Math.floor(xbound) + 2;
    int yarraysz = (int) Math.floor(ybound) + 2;
    /*
     * Note that 2 additional rows are created!!! This is to account for possible points
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

    System.out.println(xarraysz); // DBG
    System.out.println(yarraysz);
    System.out.println(drawarray.length);
    System.out.println(drawarray[0].length);
    System.out.println();

    //printarrayreverse(drawarray, "a", "b", "c", "d", "e"); //DBG

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

    //TOP CIRCLE
    double detail = 1.25;
    int repeti = (int) Math.floor(detail * drawlt * drawcut); //creates marfkers along the ellipse
    //gives approximately 1 marker per
    for (int i = 1; i <= repeti; i++) {
      double idtheta = (i / (detail * drawlt)) + drawangle;
      drawarray[(int) Math.round(CartesianEllipseX(idtheta) - xoff)]
      [(int) Math.round(CartesianEllipseY(idtheta) - yoff)] = 5;
      //System.out.println("(" + (int) Math.round(CartesianEllipseX(idtheta)) + ", " + (int) Math.round(CartesianEllipseY(idtheta)) + ")");
    }
    // TOP CIRCLE DONE

    //TOP START LINE

    //find the correct point
    double tempoffset;
    if (CartesianEllipseX(drawangle) <= drawlt) {
      repeti = (int) Math.floor(drawlt - CartesianEllipseX(drawangle) + 2);
      tempoffset = CartesianEllipseX(drawangle) - 1;
    } else {
      repeti = (int) Math.floor(CartesianEllipseX(drawangle) - drawlt + 2);
      tempoffset = drawlt - 1;
    }

    for(int i = (int) Math.floor(tempoffset); i <= (int) Math.ceil(tempoffset + repeti); i++) {
      double ptc = i;
      if(ptc < Math.min(drawlt, CartesianEllipseX(drawangle))) { //check values are within bounds
        ptc = Math.min(drawlt, CartesianEllipseX(drawangle)); //if not make them be in bounds
      } else if (ptc > Math.max(drawlt, CartesianEllipseX(drawangle))) {
        ptc = Math.max(drawlt, CartesianEllipseX(drawangle));
      }
      double pty = starttopliney(ptc);
      drawarray[(int) Math.round(ptc)][(int) Math.round(pty)] = 5;
    }

    // done by plugging associated integer values with offset fould earlier for y coordinate
    // please use cartesian equations as much as possible
    // don't forget to consider +- for sqrt of the ellipse
    // have a different marker for each curve for the next step
    // draw from bottom to top or give priority for each marker: top > edge > inside


    printarrayreverse(drawarray, "a", "b", "c", "d", "e"); //DBG

    // Fill passthrough
    // loop from top to bottom of array, the markers made above define the boundaries of which to
    // draw from

    // print the cake row by row

  }

  private double starttopliney(double inputx) {
    double th = drawlt - topoffset() - CartesianEllipseY(drawangle); //y2 / y1
    double oth = drawlt - CartesianEllipseX(drawangle);//x2 / x1
    return ((th / oth) * (inputx - drawlt)) + drawlt - topoffset();
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

  private void printarrayreverse (int[][] array, String v0, String v1, String v2, String v3, String v4) {
    //Starts at (0,y) then moves as read
    //array printing yada yada pretty simple
    for (int i = array[0].length - 1; i >= 0; i--) {
      for (int j = 0; j<= array.length - 1; j++) {
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
          System.out.print("M");
        }

      }
      System.out.println("");
    }
  }
}