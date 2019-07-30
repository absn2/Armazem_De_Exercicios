import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      Scanner in = new Scanner (System.in);
		double A, I, D, P, Y;
		String R = "";
		I = in.nextDouble();
		A = in.nextDouble();
		D = in.nextDouble();
		P = in.nextDouble();
		String lixo = in.nextLine();
		String S = in.nextLine();
		if (S.equals("Sim")) {
			Y = (((I+5) * (I+5) * (I+5)) / (Math.sqrt(A) + (D/2) + ((P+50)/3)));
		    if ( Y >= 100) {
		    	R = "Voce consegue";
		    } else {
		    	R = "Isso e perda de tempo";
		    }
		} else if (S.equals("Nao")) {
			Y = (I * I * I) / (Math.sqrt(A) + (D/2) + (P/3));
			if (Y >= 100) {
				R = "Voce consegue";
			} else {
				R = "Isso e perda de tempo";
			}
		} System.out.println(R);		
    
  }
}