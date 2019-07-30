import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      Scanner in = new Scanner (System.in);
		double C, L, X, Y;
		String tipo, resultado;
		C = in.nextDouble();
		L = in.nextDouble();
		String tipolixo = in.nextLine();
		tipo = in.nextLine();
		resultado = "";
		X = in.nextDouble();
		Y = in.nextDouble();
		if (tipo.equals("Bola Normal")) {
			if (X < C/2 && Y <= L) {
				resultado = "A bola foi rebatida";
			} else {
				resultado = "A bola foi para fora";
			}
		} else if (tipo.equals("Saque")) {
			if (X >= C/4 && X < C/2 && Y <= L) {
				resultado = "A bola foi rebatida";
			} else {
				resultado = "A bola foi para fora";
			}
		}System.out.println(resultado);
    
  }
}