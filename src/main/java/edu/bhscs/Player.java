/*
 * Dunhuang Su P2 Bake Sale 9/29/2025
 *
 * DESCRIPTION: An all-powerful User can tell their own story of a bake sale through the console.
 * INPUT: Anything the user desires and within the limitations of this code.
 * OUTPUT: The standard operation of the bake sale
 * EDGE CASES: Typing something that cannot be converted to int or double when appropriate will break the code.
 * When another class is being asked for as input, choosing a slot that does not exist (type null) will also.
 * the requirements are VERY SPECIFIC. Please refer to as follows:
 * 1) A store must get a goods shipment before any baking or examinations can be done.
 * 2) A baker must be hired and given a recipe before making a cake.
 * 3) A customer must be given a preferred store before attempting to buy a cake.
 * 4) A store must be made before making a customer, or the process is impossible to complete without an error.
 * there are many more, however they should be basic knowledge.
 */
package edu.bhscs;

import java.util.Scanner;

public class Player {
  //FIELDS AND PROPERTIES
  Scanner userinput = new Scanner(System.in);
  String name;
  boolean playing = true;
  Store[] stores = new Store[5];
  Baker[] bakers = new Baker[5];
  Customer[] customers = new Customer[5];
  Recipe[] recipes = new Recipe[5];
  String selection;
  PTSA fraudulentServices = new PTSA("unknown");

  //CONSTRUCTORS
  public Player() {

  }

  public Player(String name) {
    this.name = name;
  }

  //METHODS
  public void runSimulation() {
    while (playing) {
      selection = GetInput("What would you like to do? Type 'help' for help");
      if (selection.equals("help")) {
        help();
      } else if (selection.equals("Store")) {
        Store();
      } else if (selection.equals("Customer")) {
        Customer();
      } else if (selection.equals("Baker")) {
        Baker();
      } else if (selection.equals("Recipe")) {
        Recipe();
      } else if (selection.equals("Contractor")) {
        Contractor();
      } else if (selection.equals("PTSA")) {
        PTSA();
      } else if (selection.equals("end")) {
        userinput.close();
        playing = false;
      } else {
        System.out.println("Command not recognized! please use 'Help' for help");
      }
    }
  }

  public void setName(String name) {
    this.name = name;
  }


  public String giveAnswer(String prompt) {
    return GetInput(prompt);
  }

  public String GetInput(String prompt) {
    System.out.println(prompt);
    return userinput.next();
  }

  //private methods below, cannot be accessed outside of Player

  private void PTSA() {
    selection = GetInput("PTSA " + fraudulentServices.returnname() + ": Type 1 to view profits. Type 2 to rename PTSA.");
    if (selection.equals("1")) {
      fraudulentServices.sumofdonation();
    } else if (selection.equals("2")) {
      fraudulentServices.updatename(GetInput("What should the PTSA be called?"));
    } else {
      System.out.println("Not valid!");
    }
  }

  private void help() {
    System.out.println("Type 'Store' to edit stores");
    System.out.println("Type 'Baker' to edit bakers");
    System.out.println("Type 'Customer' to edit customers");
    System.out.println("Type 'Recipe' to edit recipes");
    System.out.println("Type 'Contractor' to assign work to a Baker");
    System.out.println("Type 'PTSA' to view PTSA");
    System.out.println("Type 'end' to stop program");
  }

  private void Store() {
    System.out.println("STORE: Type 1 to view stores. Type 2 to add a store.");
    System.out.println("Type 3 to delete a store. Type 4 to view a specific store.");
    selection = userinput.next();
    if (selection.equals("1")) {
      int a = 0;
      for (Store j : stores) {
        a += 1;
        if (j != null) {
          System.out.println(j.StoreName() + " in slot " + a);
        }
      }
    } else if (selection.equals("2")) {
      String storename = GetInput("What shall this store be called?");
      System.out.println("Which slot to put data for this store into? (1 - 5)");
      int storeindex = Integer.parseInt(userinput.next()) - 1;
      stores[storeindex] = new Store(storename);

    } else if (selection.equals("3")) {
      System.out.println("Which slot to remove? (1 - 5)");
      int storeindex = Integer.parseInt(userinput.next()) - 1;
      stores[storeindex] = null;

    } else if (selection.equals("4")) {

      System.out.println("Which slot to view? (1 - 5)");
      int storeindex = Integer.parseInt(userinput.next()) - 1;
      if (stores[storeindex] != null) {
        viewstore(stores[storeindex]);
      } else {
        System.out.println("That does not exist!");
      }

    } else {
      System.out.println("Not valid!");
    }
  }

  private void viewstore(Store store) {
    System.out.println(
        "STORE " + store.StoreName() + ": Type 1 to show cakes. Type 2 to check pantry.");
    System.out.println(
        "Type 3 to import a goods shipment. Type 4 to show profits. Type 5 to donate it to the PTSA.");
    System.out.println(
        "Type 6 to fire a baker. Type 7 to get a cake from a baker. Type 8 to examine a specific cake.");
    selection = userinput.next();
    if (selection.equals("1")) {
      store.showcakes();
    } else if (selection.equals("2")) {
      System.out.println("RESULTS OF PANTRY EXAMINATION");
      System.out.println("Flour: " + store.accessPantry().getFlour().returnquantity() + "g");
      System.out.println("Eggs: " + store.accessPantry().getEggs().returnquantity() + " units");
      System.out.println("Butter: " + store.accessPantry().getButter().returnquantity() + "g");
      System.out.println("Milk: " + store.accessPantry().getMilk().returnquantity() + "mL");
      System.out.println("Sugar: " + store.accessPantry().getButter().returnquantity() + "g");
    } else if (selection.equals("3")) {
      String[] items = {"Flour", "Eggs", "Butter", "Milk", "Sugar"};
      Flour d = null;
      Eggs e = null;
      Butter f = null;
      Milk g = null;
      Sugar h = null;
      for (int i = 1; i <= 5; i++) {
        System.out.println("Currently importing: " + items[i - 1]);
        System.out.println("What is the quantity?");
        selection = userinput.next();
        int a = Integer.parseInt(selection);
        System.out.println("What is the cost?");
        selection = userinput.next();
        double b = Double.parseDouble(selection);
        System.out.println("What is the quality?");
        selection = userinput.next();
        int c = Integer.parseInt(selection);
        if (i == 1) {
          d = new Flour(a, b, c);
        } else if (i == 2) {
          e = new Eggs(a, b, c);
        } else if (i == 3) {
          f = new Butter(a, b, c);
        } else if (i == 4) {
          g = new Milk(a, b, c);
        } else {
          h = new Sugar(a, b, c);
          store.delivergoods(d, e, f, g, h);
        }
      }
    } else if (selection.equals("4")) {
      store.ShowProfits();
    } else if (selection.equals("5")) {
      store.DonateAllMoneyToPTSA(fraudulentServices);
    } else if (selection.equals("6")) {
      System.out.println("Which baker index to fire? (1-3)");
      int secei = Integer.parseInt(userinput.next());
      store.firebaker(secei);
    } else if (selection.equals("7")) {
      System.out.println("Which baker to take the cake from? (1 - 3)");
      int sdij = Integer.parseInt(userinput.next());
      System.out.println("Which shelf row should the cake be stored in? (1 - 3)");
      int intermdin = Integer.parseInt(userinput.next());
      System.out.println("Which shelf column should the cake be stored in? (1 - 5)");
      int secei = Integer.parseInt(userinput.next());
      store.getCakefrombaker(intermdin, secei, sdij);
    } else if (selection.equals("8")) {
      System.out.println("Which shelf row? (1 - 3)");
      int intermdin = Integer.parseInt(userinput.next());
      System.out.println("Which shelf column? (1 - 5)");
      int secei = Integer.parseInt(userinput.next());
      store.ExamineCake(intermdin, secei);
    } else {
      System.out.println("Not valid!");
    }
  }

  private void Customer() {
    System.out.println("CUSTOMER: Type 1 to view customers. Type 2 to add a customer.");
    System.out.println("Type 3 to delete a customer. Type 4 to view a specific customer.");
    selection = userinput.next();
    if (selection.equals("1")) {
      int a = 0;
      for (Customer j : customers) {
        a += 1;
        if (j != null) {
          System.out.println(j.name() + " in slot " + a);
        }
      }
    } else if (selection.equals("2")) {
      System.out.println("What shall this customer be called?");
      String thename = userinput.next();
      System.out.println("How much money should they have?");
      Double money = Double.parseDouble(userinput.next());
      System.out.println("Which store should they buy from? (index 1 - 5)");
      String intermdin = userinput.next();
      Store buyfrom = null;
      if (!intermdin.equals("0")) {
        buyfrom = stores[Integer.parseInt(intermdin) - 1];
      }
      System.out.println("Which slot to put data for this customer into? (1 - 5)");
      int theindex = Integer.parseInt(userinput.next()) - 1;
      customers[theindex] = new Customer(thename, true, buyfrom, money);

    } else if (selection.equals("3")) {
      System.out.println("Which slot to remove? (1 - 5)");
      int theindex = Integer.parseInt(userinput.next()) - 1;
      customers[theindex] = null;

    } else if (selection.equals("4")) {

      System.out.println("Which slot to view? (1 - 5)");
      int theindex = Integer.parseInt(userinput.next()) - 1;
      if (customers[theindex] != null) {
        ViewCustomer(customers[theindex]);
      } else {
        System.out.println("That does not exist!");
      }

    } else {
      System.out.println("Not valid!");
    }
  }

  private void ViewCustomer(Customer customer) {
    System.out.println(
        "CUSTOMER " + customer.name() + ": Type 1 to set store to go to. Type 2 to see money.");
    System.out.println(
        "Type 3 to go to work. Type 4 to buy a cake. Type 5 to eat cake. Type 6 to discard cake. Type 7 to examine the cake.");
    selection = userinput.next();
    if (selection.equals("1")) {
      System.out.println("Which store should they buy from? (index 1 - 5). Type '0' for none.");
      int intermdin = Integer.parseInt(userinput.next()) - 1;
      customer.ChangePreferredStore(stores[intermdin]);
    } else if (selection.equals("2")) {
      customer.printmoney();
    } else if (selection.equals("3")) {
      System.out.println("How long should I work for?");
      int intermdin = Integer.parseInt(userinput.next());
      customer.MakeYTVideos(intermdin);
    } else if (selection.equals("4")) {
      System.out.println("Which shelf row should I buy from? (1 - 3)");
      int intermdin = Integer.parseInt(userinput.next());
      System.out.println("Which shelf column should I buy from? (1 - 5)");
      int secei = Integer.parseInt(userinput.next());
      customer.BuyAndPayForCake(intermdin, secei);
      customer.PickupCake();
    } else if (selection.equals("5")) {
      System.out.println("How much cake should I eat?");
      int secei = Integer.parseInt(userinput.next()) - 1;
      customer.EatMyCake(secei);
    } else if (selection.equals("6")) {
      customer.DiscardMyCake();
    } else if (selection.equals("7")) {
      customer.CakeInfo();
    } else {
      System.out.println("Not valid!");
    }
  }

  private void Baker() {
    System.out.println("BAKER: Type 1 to view bakers. Type 2 to add a baker.");
    System.out.println("Type 3 to delete a baker. Type 4 to view a specific baker.");
    selection = userinput.next();
    if (selection.equals("1")) {
      int a = 0;
      for (Baker j : bakers) {
        a += 1;
        if (j != null) {
          System.out.println(j.getname() + " in slot " + a);
        }
      }
    } else if (selection.equals("2")) {
      System.out.println("What shall this baker be called?");
      String thename = userinput.next();
      System.out.println("Which slot to put data for this baker into? (1 - 5)");
      int theindex = Integer.parseInt(userinput.next()) - 1;
      bakers[theindex] = new Baker(thename);

    } else if (selection.equals("3")) {
      System.out.println("Which slot to remove? (1 - 5)");
      int theindex = Integer.parseInt(userinput.next()) - 1;
      bakers[theindex] = null;

    } else if (selection.equals("4")) {

      System.out.println("Which slot to view? (1 - 5)");
      int theindex = Integer.parseInt(userinput.next()) - 1;
      if (bakers[theindex] != null) {
        ViewBaker(bakers[theindex]);
      } else {
        System.out.println("That does not exist!");
      }

    } else {
      System.out.println("Not valid!");
    }
  }

  private void ViewBaker(Baker baker) {
    System.out.println(
        "BAKER " + baker.getname() + ": Type 1 to set the recipe. Type 2 to see level.");
    System.out.println("Type 3 to bake a cake. Type 4 to go to clases.");
    selection = userinput.next();
    if (selection.equals("1")) {
      System.out.println("Which slot to take recipe from? (1 - 5)");
      int theindex = Integer.parseInt(userinput.next()) - 1;
      baker.getinstructions(recipes[theindex]);
    } else if (selection.equals("2")) {
      baker.printlevel();
    } else if (selection.equals("3")) {
      baker.Bakeacake();
    } else if (selection.equals("4")) {
      baker.gotobakingclass();
    } else {
      System.out.println("Not valid!");
    }
  }

  private void Recipe() {
    System.out.println("RECIPE: Type 1 to view recipes. Type 2 to add a recipe.");
    System.out.println("Type 3 to delete a recipe.");
    selection = userinput.next();
    if (selection.equals("1")) {
      int a = 0;
      for (Recipe j : recipes) {
        a += 1;
        if (j != null) {
          System.out.println(j.name() + " in slot " + a);
        }
      }
    } else if (selection.equals("2")) {
      System.out.println("What shall this recipe be called?");
      String names = userinput.next();
      System.out.println("What flavor should it have?");
      String flavor = userinput.next();
      System.out.println("What toppings should it have?");
      String toppings = userinput.next();
      System.out.println("What shape should it have?");
      String shape = userinput.next();
      System.out.println("What is it's diameter (inches)?");
      int diameter = Integer.parseInt(userinput.next());
      System.out.println("What is it's height (inches)?");
      int height = Integer.parseInt(userinput.next());
      System.out.println("How much flour to use?");
      int flour = Integer.parseInt(userinput.next());
      System.out.println("How many eggs to use?");
      int eggs = Integer.parseInt(userinput.next());
      System.out.println("How much butter to use?");
      int butter = Integer.parseInt(userinput.next());
      System.out.println("How much milk to use?");
      int milk = Integer.parseInt(userinput.next());
      System.out.println("How much sugar to use?");
      int sugar = Integer.parseInt(userinput.next());
      System.out.println("Which slot to save the recipe to? (1 - 5)");
      int theindex = Integer.parseInt(userinput.next()) - 1;
      recipes[theindex] =
          new Recipe(
              flavor, toppings, shape, names, diameter, height, flour, eggs, butter, milk, sugar);

    } else if (selection.equals("3")) {
      System.out.println("Which slot to remove? (1 - 5)");
      int theindex = Integer.parseInt(userinput.next()) - 1;
      recipes[theindex] = null;

    } else {
      System.out.println("Not valid!");
    }
  }

  private void Contractor() {
    System.out.println("Which baker should be hired? (1 - 5)");
    int theindex = Integer.parseInt(userinput.next()) - 1;
    System.out.println("At which store? (1 - 5)");
    int theotherindex = Integer.parseInt(userinput.next()) - 1;
    if (bakers[theindex] != null && stores[theotherindex] != null) {
      Contractor a = new Contractor();
      a.performjobinterview(bakers[theindex], stores[theotherindex]);
    } else {
      System.out.println("One or more of the two are invalid!");
    }
  }
}