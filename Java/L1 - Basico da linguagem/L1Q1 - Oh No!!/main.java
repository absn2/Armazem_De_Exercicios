import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner (System.in);
		int N = in.nextInt();
		String U = "";
		if (N == 1) {
			U = "Life Mushroom";
		} else if (N == 2) {
			U = "Fire Flower";
		} else if (N == 3) {
			U = "Boost Star";
		} else if (N == 4) {
			U = "Mega Mushroom";
		} 
		System.out.println(U);			
  }
}