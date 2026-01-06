package edu.bhscs;

public class Mystery1 {
  public static void main(String[] args) {
    int a = 29; // 0 1 1 1 0 1
    System.out.println(a >> 1); // 0 0 1 1 1 0 = 14
    System.out.println(a >> 2); // 0 0 0 1 1 1 = 7
    System.out.println(a >> 3); // 0 0 0 0 1 1 = 3
  }
}
