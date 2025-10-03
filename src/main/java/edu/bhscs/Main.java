/* Dunhuang Su
 * P2
 * Bake Sale
 * 9/29/2025
 *
 * DESCRIPTION: A Cake, a Baker, a Store, and a Customer exist in a bake sale. Earned money is given to PTSA.
 * INPUT: None
 * OUTPUT: The standard operation of the bake sale
 * EDGE CASES: None in Main
 */

package edu.bhscs;

class Main {
  public static void main(String[] args) { // this is a constructor
    boolean storybakesale = false;
    if (storybakesale) {
      // Prelude: Defining variables
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
      Recipe Bananablast =
          new Recipe(
              "Banana",
              "Dehydrated banana crisps",
              "Oval",
              "Banana Blast",
              7,
              3,
              600,
              4,
              40,
              80,
              1000);
      Customer Janet = new Customer("janet", true, overpricery, 999.99);
      // Act 1: Bob, an inexperienced baker, gets hired at Overpricery. He makes 5 cakes.
      System.out.println("================ ACT 1 ================");
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

      // Act 2: Janet enters the store, buys a cake, and then eats most of it before discarding.
      System.out.println("================ ACT 2 ================");
      overpricery.ExamineCake(1, 1);
      Janet.BuyAndPayForCake(1, 1);
      Janet.PickupCake();
      Janet.EatMyCake(90);
      Janet.DiscardMyCake();

      overpricery.ShowProfits();
      bob.printlevel(); // bob levels up because of making cakes

      // Act 3: Bob gets fired from Overpricery, and is hired at Goodpricery.
      // Bob keeps his experience level between jobs.
      System.out.println("================ ACT 3 ================");
      overpricery.firebaker(1);
      hirer.performjobinterview(bob, goodpricery);
      bob.getinstructions(Mikeoriginal);
      bob.Bakeacake();
      goodpricery.getCakefrombaker(1, 1, 1);
      goodpricery.showcakes();
      goodpricery.ExamineCake(1, 1);

      // Act 4: Bob tries to make another cake, however there is
      // not enough resources. A new shipment is then delivered, allowing him to bake the cake.
      System.out.println("================ ACT 4 ================");
      bob.Bakeacake(); // prints not enough resources (we know flour is low from examination)
      System.out.println(goodpricery.accessPantry().getButter().returnquantity());
      goodpricery.getCakefrombaker(1, 2, 1);
      goodpricery.showcakes();

      bob.examinepantry(); // Bob examines the pantry and orders more flour
      Flour newflourshipment = new Flour(800000, 1509.99, 5);
      goodpricery.delivergoods(newflourshipment, null, null, null, null);

      bob.Bakeacake(); // cake is now baked.
      // The new cake is worth less because the cost per gram of flour and quality is low.
      goodpricery.getCakefrombaker(1, 2, 1);
      goodpricery.showcakes();
      goodpricery.ExamineCake(1, 2);

      // Act 5: Bob goes to classes. Since he is higher level than before, his cakes are worth more.
      System.out.println("================ ACT 5 ================");
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

      // Act 6: Billy gets hired at the same bakery. They make the same cake, but the price is
      // different.
      System.out.println("================ ACT 6 ================");
      hirer.performjobinterview(billy, goodpricery);
      billy.getinstructions(Bananablast);
      bob.getinstructions(Bananablast);
      billy.Bakeacake();
      bob.Bakeacake();
      goodpricery.getCakefrombaker(2, 1, 2);
      goodpricery.getCakefrombaker(3, 1, 1);
      goodpricery
          .showcakes(); // Cake at (3,1) is worth much more because of difference in experience!

      // Act 7: Janet buys more cakes. Profits are donated to the PTSA.
      System.out.println("================ ACT 7 ================");
      Janet.EatMyCake(100);
      Janet.CakeInfo(); // Cake shows owner and eating progress
      Janet.DiscardMyCake();
      // Notice how discarding a cake yields a
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

      goodpricery
          .ShowProfits(); // goodpricery profits from cakes sold, but only a fraction of the price
      goodpricery.DonateAllMoneyToPTSA(GalliumOrganization);
      goodpricery.ShowProfits(); // profits are gone because...
      GalliumOrganization.sumofdonation(); // ...they are all in the PTSA!

      // Act 8: Janet goes to work to earn money. She gets tired after a while, and buying a cake
      // heeps her satisfication up.
      System.out.println("================ ACT 8 ================");
      Janet.getmysatisfication();
      Janet.MakeYTVideos(600);
      Janet.printmoney();
      Janet.MakeYTVideos(20); // she isn't motivated enough to do this
      Janet.BuyAndPayForCake(2, 1);
      Janet.PickupCake();
      Janet.EatMyCake(50); // she is more motivated after eating cake
      Janet.getmysatisfication();
      Janet.MakeYTVideos(20);

    } else {
      
    }
  }
}
