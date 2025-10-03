package edu.bhscs;
import java.util.Scanner;

public class Player {
  Scanner userinput = new Scanner(System.in);
  String name;
  public Player(String name) {
    this.name = name;
  }

  private void AnswerQuestions() {
    System.out.println("What is your question?");
    String question = this.userinput.next();
    System.out.println(question + " is a dumb question!");
  }
}