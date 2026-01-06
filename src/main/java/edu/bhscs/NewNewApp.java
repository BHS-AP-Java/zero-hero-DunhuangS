package edu.bhscs;

public class NewNewApp {

  private int dang;

  public NewNewApp(int dang) {
    this.dang = dang;
  }
  public static void main(String[] args) {
    String sentence = "Grab the last word";
    String lastWord = sentence.substring(sentence.length()-4, sentence.length());
    String l2word = sentence.substring(sentence.indexOf("w"), sentence.indexOf("d"));
    String l3word = sentence.substring(14, 16) + sentence.substring(1, 2) + sentence.substring(sentence.length()-1, sentence.length());
    System.out.println(lastWord);
    System.out.println(l2word);
    System.out.println(l3word);
    NewerClass a = new NewerClass();
    System.out.println(a.sout());
    System.out.println(a.iout());
    System.out.println(a.dout());
    System.out.println(a.bout());
    a.arraing();

    NewNewApp b = new NewNewApp(3);
    System.out.println(b.ok());
  }
  public int ok() {
    return dang;
  }
}
