import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      	Scanner in = new Scanner (System.in);
		int R = 10;
		String U = in.nextLine();
		if (U.equals("Zero")) {
		    R = 0;
		} else if (U.equals("Um")) {
			R = 1;
		} else if (U.equals("Dois")) {
			R = 2;
		} else if (U.equals("Tres")) {
			R = 3;
		} else if (U.equals("Quatro")) {
			R = 4;
		} else if (U.equals("Cinco")) {
			R = 5;
		} else if (U.equals("Seis")) {
			R = 6;
		} else if (U.equals("Sete")) {
			R = 7;
		} else if (U.equals("Oito")) {
			R = 8;
		} else if (U.equals("Nove")) {
			R = 9;
		}
		System.out.println(R);		
	}

}