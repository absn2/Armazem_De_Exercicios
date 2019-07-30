import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
     Scanner in = new Scanner (System.in);
		String P, L, S, C;
		P = in.nextLine();
		L = in.nextLine();
		S = in.nextLine();
		P = (P.substring(0, 1)) + (P.substring(P.length()-1));
		S = (S.substring(0, 1)) + (S.substring(S.length()-1));
		L = (L.substring(0, 1)) + (L.substring(L.length()-1));
		if (P.equals("fr") || P.equals("FR") || P.equals("Fr") || P.equals("fR") ) {			
		System.out.println("Direita");
		} else if (L.equals("fr") || L.equals("FR") || L.equals("Fr") || L.equals("fR")) {
			System.out.println("Meio");
		} else if (S.equals("fr") || S.equals("FR") || S.equals("Fr") || S.equals("fR")) {
			System.out.println("Esquerda");
		} else {
			System.out.println("Vou em frente");
		}
  }
}