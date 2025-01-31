import java.util.Scanner;
import java.util.Random;

public class PassGen {

  public static String genPass(int len, boolean up, boolean low, boolean dig, boolean sch) {
    String ch = "";

    if (up)
      ch += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    if (low)
      ch += "abcdefghijklmnopqrstuvwxyz";
    if (dig)
      ch += "0123456789";
    if (sch)
      ch += "@#$%^&*()_+-=[]{}|;:,.<>?";

    if (ch.isEmpty()) {
      return "Error: No character set selected!";
    }

    int s = ch.length(); // size
    Random rand = new Random();
    String pass = "";

    for (int i = 0; i < len; i++) {
      int randomIndex = rand.nextInt(s);
      pass += ch.charAt(randomIndex);
    }

    return pass;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter password length: "); // Ask for password length
    int l = in.nextInt();

    // Ask for password options
    System.out.print("Include Uppercase? (Enter 1 for yes, 0 for no): ");
    boolean up = in.nextInt() == 1;

    System.out.print("Include Lowercase? (Enter 1 for yes, 0 for no): ");
    boolean low = in.nextInt() == 1;

    System.out.print("Include Digits? (Enter 1 for yes, 0 for no): ");
    boolean dig = in.nextInt() == 1;

    System.out.print("Include Special Characters? (Enter 1 for yes, 0 for no): ");
    boolean sc = in.nextInt() == 1;

    String pass = genPass(l, up, low, dig, sc);
    System.out.println("\nGenerated Password is : " + pass);

    in.close();
  }
}

