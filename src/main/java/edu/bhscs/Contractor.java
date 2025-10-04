/*
 * Dunhuang Su
 * P2
 * Bake Sale
 * 10/1/2025
 *
 * DESCRIPTION: A person that links bakers and stores
 * INPUT: Baker, Store
 * OUTPUT: Status if the assignment
 * EDGE CASES: None at the moment
 */
package edu.bhscs;

class Contractor {

  Contractor() {}

  boolean performjobinterview(Baker baker, Store store) {
    if (store.bakerapplication(baker)) {
      baker.acceptjob(store);
      return true;
    } else {
      return false;
    }
  }
}
