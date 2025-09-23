package edu.bhscs;

class Store {
  cake a = new cake(false);
  //cake b = new cake(false);
  cake[][] shelf = {{a,a,a,a,a},{a,a,a,a,a},{a,a,a,a,a}};
  public Store(String[] args) {
    System.out.println("A store has opened!");
  }
  void showcakes() {
    boolean therearecakes = false;
    int height = 1;
    int dist = 1;
    for (cake[] row : shelf) {
        for (cake item : row) {
            if (item.cakeexist()) {
                therearecakes = true;
                System.out.println(item.cakename());
            }
        }
    }
  }
}