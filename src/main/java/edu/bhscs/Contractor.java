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
