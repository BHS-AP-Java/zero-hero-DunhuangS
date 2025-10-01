/* Dunhuang Su
* P2
* Bake Sale
* 9/29/2025

* DESCRIPTION: A Cake, a Baker, a Store, and a Customer exist in a bake sale. Earned money is given to PTSA.
* INPUT: None
* OUTPUT: The standard operation of the bake sale
* EDGE CASE:
* Putting a cake into a store in a slot that already has a cake replaces the cake without warning
* Delivering goods
*
*
*
*
*
*
*/

package edu.bhscs;

class Main {
  public static void main(String[] args) { // this is a constructor
    boolean bakesale = true;
    // doing cake stuff (acts like a master switch)
    if (bakesale) {
      //Section 1: Defining variables
      Pantry overstorery = new Pantry();
      overstorery.putbutter(new Butter(1000, 10.00, 9));
      overstorery.puteggs(new Eggs(120, 85.00, 3));
      overstorery.putflour(new Flour(16000, 30.15, 9));
      overstorery.putmilk(new Milk(4000, 12.15, 4));
      overstorery.putsugar(new Sugar(8000, 40.00, 5));
      PTSA GalliumOrganization = new PTSA("Veridian Designs Co.");

      Store overpricery = new Store("Overpricery");
      overpricery.updatePantry(overstorery);
      Store goodpricery = new Store("Goodpricery");
      Flour flourdelivery = new Flour(3000, 19.99, 10);
      Eggs eggdelivery = new Eggs(800, 1129.99, 10);
      Butter butterdelivery = new Butter(8200, 250.99, 10);
      Milk milkdelivery = new Milk(9000, 200.99, 10);
      Sugar sugardelivery = new Sugar(80000, 1249.99, 10);
      goodpricery.delivergoods(
          flourdelivery, eggdelivery, butterdelivery, milkdelivery, sugardelivery);

      Contractor hirer = new Contractor();
      Baker bob = new Baker("bob");
      Baker billy = new Baker("billy");

      Recipe chocoblast =
          new Recipe(
              "Chocolate", "Cherry", "Circle", "Chocolate Blast", 6, 3, 600, 5, 70, 120, 560);
      Recipe Mikeoriginal =
          new Recipe(
              "Vanilla",
              "Chocolate crisps",
              "Square",
              "Mike's original",
              8,
              8,
              2900,
              12,
              220,
              411,
              600);
      Recipe Bananablast = new Recipe("Banana",
      "Dehydrated banana crisps", "Oval", "Banana Blast",
              7, 3, 600, 4, 40, 80, 1000);
      Customer Janet = new Customer("janet", true, overpricery, 999.99);
      // Act 1: Bob, an inexperienced baker, gets hired at Overpricery. He makes 5 cakes.
      hirer.performjobinterview(bob, overpricery);
      bob.getinstructions(chocoblast);
      bob.Bakeacake();
      overpricery.getCakefrombaker(1, 1, 1);
      bob.Bakeacake();
      overpricery.getCakefrombaker(1, 2, 1);
      bob.Bakeacake();
      overpricery.getCakefrombaker(1, 3, 1);
      bob.Bakeacake();
      overpricery.getCakefrombaker(1, 4, 1);
      bob.Bakeacake();
      overpricery.getCakefrombaker(1, 5, 1);
      overpricery.showcakes();

      //Act 2: Janet enters the store, buys a cake, and then eats most of it before discarding.
      overpricery.ExamineCake(1, 1);
      Janet.BuyAndPayForCake(1, 1);
      Janet.PickupCake();
      Janet.EatMyCake(90);
      Janet.DiscardMyCake();

      overpricery.ShowProfits();
      bob.printlevel();

      // Act 3: Bob gets fired from Overpricery, and is hired at Goodpricery. He keeps his experience.
      overpricery.firebaker(1);
      hirer.performjobinterview(bob, goodpricery);
      bob.getinstructions(Mikeoriginal);
      bob.Bakeacake();
      goodpricery.getCakefrombaker(1, 1, 1);
      goodpricery.showcakes();
      goodpricery.ExamineCake(1, 1);

      // Act 4: Bob tries to make another cake, however there is
      //not enough resources. A new shipment is then delivered, allowing him to bake the cake.
      bob.Bakeacake(); // prints not enough resources (we know flour is low from examination)
        System.out.println(goodpricery.accessPantry().getButter().returnquantity());
      goodpricery.getCakefrombaker(1, 2, 1);
      goodpricery.showcakes();

      bob.examinepantry(); //Bob examines the pantry and orders more flour
      Flour newflourshipment = new Flour(800000, 1509.99, 5);
      goodpricery.delivergoods(newflourshipment, null, null, null, null);

      bob.Bakeacake(); // cake is now baked.
      // The new cake is worth less because the cost per gram of flour and quality is low.
      goodpricery.getCakefrombaker(1, 2, 1);
      goodpricery.showcakes();
      goodpricery.ExamineCake(1, 2);

      // Act 5: Bob goes to classes. Since he is higher level than before, his cakes are worth more.
      for (int i = 0; i < 10; i++) {
        bob.gotobakingclass();
      }
      bob.printlevel();
      bob.Bakeacake();
      goodpricery.getCakefrombaker(2, 2, 1);
      goodpricery.showcakes();
      goodpricery.ExamineCake(2, 2);
      // The cake is worth even more than the one made with high quality ingredients.
      // This is due to Bob's expertise.
      Janet.ChangePreferredStore(goodpricery);
      Janet.BuyAndPayForCake(2, 2);
      Janet.PickupCake();

      // Act 6: Billy gets hired at the same bakery. They make the same cake, but the price is different.
      hirer.performjobinterview(billy, goodpricery);
      billy.getinstructions(Bananablast);
      bob.getinstructions(Bananablast);
      billy.Bakeacake();
      bob.Bakeacake();
      goodpricery.getCakefrombaker(2, 1, 2);
      goodpricery.getCakefrombaker(3, 1, 1);
      goodpricery.showcakes(); //Cake at (3,1) is worth much more because of difference in experience!

      // Act 7: Janet buys more cakes. Profits are donated to the PTSA.
      Janet.EatMyCake(100);
      Janet.CakeInfo(); //Cake shows owner and eating progress
      Janet.DiscardMyCake();
      //Notice how discarding a cake yields a
      // different message depending on how much of the cake was eaten.
      Janet.BuyAndPayForCake(1, 1);
      Janet.PickupCake();
      Janet.EatMyCake(80);
      Janet.DiscardMyCake();

      Janet.BuyAndPayForCake(1, 2);
      Janet.PickupCake();
      Janet.EatMyCake(95);
      Janet.DiscardMyCake();

      Janet.BuyAndPayForCake(3, 1);
      Janet.PickupCake();
      Janet.EatMyCake(30);
      Janet.DiscardMyCake();

      goodpricery.ShowProfits(); //goodpricery profits from cakes sold, but only a fraction of the price
      goodpricery.DonateAllMoneyToPTSA(GalliumOrganization);
      goodpricery.ShowProfits(); //profits are gone because...
      GalliumOrganization.sumofdonation(); // ...they are all in the PTSA!

      /*
      // default cake settings
      String MyFlavor = "chocolate";
      String MySweetness = "moderately";
      String MyToppings = "cherry";
      String MyShape = "circle";
      int MyDiameter = 8;
      int MyHeight = 6;
      int MyWeight = 617;
      String MyName = "chocolate blast";
      // new baker Bob, given instructions and baked a cake
      Baker bob = new Baker();
      bob.giveinstructions(
          MyFlavor, MySweetness, MyToppings, MyShape, MyDiameter, MyHeight, MyWeight, MyName);
      bob.Bakeacake();
      // MadeCake.viewcake();
      // new store Overpricery opens
      Store overpricery = new Store("overpricery");
      // adds bob's cake to the store
      overpricery.addcakes(2, 1, bob.Givemethecake(), 22.99);
      bob.giveinstructions(
          MyFlavor, MySweetness, MyToppings, MyShape, MyDiameter, MyHeight, MyWeight, "scamblast");
      // adds a few more cakes
      bob.Bakeacake();
      overpricery.addcakes(1, 1, bob.Givemethecake(), 229.99);
      bob.giveinstructions(
          MyFlavor,
          MySweetness,
          MyToppings,
          MyShape,
          MyDiameter,
          MyHeight,
          MyWeight,
          "miniscamblast");
      bob.Bakeacake();
      overpricery.addcakes(1, 3, bob.Givemethecake(), 129.99);
      bob.giveinstructions("Dog", "more savory than", "dog ear", "dog", 90, 24, 16500, "DogCake");
      bob.Bakeacake();
      overpricery.addcakes(3, 5, bob.Givemethecake(), 69.99);
      // this shows all the cakes
      overpricery.showcakes();
      // Janet, a new customer, buys from specifically overpricery
      Customer Janet = new Customer("Janet", true, overpricery, 100);
      // Janet buys a cake
      Janet.BuyAndPayForCake(2, 1);
      Janet.PickupCake();
      // Janet eats the cake
      Janet.EatMyCake(100);
      Janet.CakeInfo();
      // Cake discarded
      Janet.DiscardMyCake();
      // Since cake is discarded, no cake is present when info is taken
      Janet.CakeInfo();
      // Profits of the store
      overpricery.ShowProfits();
      Janet.BuyAndPayForCake(3, 5);
      Janet.PickupCake();
      Janet.EatMyCake(65);
      Janet.CakeInfo();
      Janet.DiscardMyCake();
      overpricery.ShowProfits();
      */
    }
  }
}
