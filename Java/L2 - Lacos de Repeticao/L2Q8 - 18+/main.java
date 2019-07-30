import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
       Scanner in = new Scanner (System.in);
		String sAtual = "", lnt = "", ln = "", s = "";
		int t, contadorex = 0, contador = 1, y, sc;
		while (in.hasNextLine()) {
		    contador = 0;
			sAtual = in.nextLine();
			t = sAtual.length();
			ln = "";
			contadorex = 0;
			while (contador < t) {
	
			sc = sAtual.charAt(contador);
		   //especiais e tal
			if ((sc < 97 | sc > 122) & (sc < 65 | sc > 90) & (sc < 48  | sc > 57)) {
				if (sc != 32) {
				contadorex++;
				}
				contador++;
				continue;
			}
			// 0 ate 9
			if (sc >= 48  && sc <= 57) {
				if (sc == 48) {
					s = "*";	
				}if (sc == 49) {
					s = ")";	
				}if (sc == 50) {
					s = "$";	
				}if (sc == 51) {
					s = "!";	
				}if (sc == 52) {
					s = "+";	
				}if (sc == 53) {
					s = "@";	
				}if (sc == 54) {
					s = "-";	
				}if (sc == 55) {
					s = "/";	
				}if (sc == 56) {
					s = "(";	
				}if (sc == 57) {
					s = "%";	
				}
				ln = ln + s;
				contador ++;
				continue;	
			}
			// para letras maiusculas
			if (sc >= 65 && sc <= 90) {
				y = sc - 64;
				s = "" + y;
				ln = ln + s;
				contador ++;
				continue;		
			}
			// pra letras minusculas
			if (sc >= 97 && sc <= 122) {
				if (contadorex % 2 == 0) {
					char u = (char) (sc-32);
					sc = u;
			    ln = ln + u;	
				} else {
					char u = (char) sc;
					sc = u;
			    ln = ln + u;
				}
			contador ++;	
			continue;
		    }
		} lnt =ln + "\n" + lnt  ;
	} 
	System.out.println(lnt);
}
}
      