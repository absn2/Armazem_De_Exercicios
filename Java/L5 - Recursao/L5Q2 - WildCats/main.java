import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int soma = 0;
		while (in.hasNext()) {
			int voltas = in.nextInt();
			soma += voltas;
			long resultado = fatorial(voltas);
			if (fatorial(voltas) < 50) {
				resultado = resultado * 2;
			}
			System.out.println(resultado);
		}
		if (soma > 100) {
			System.out.println("WildCats, get the head in the game!");
		}
	}

	static long fatorial(int i) {
		long resultado = 0;
		if (i == 0) {
			resultado = 1;
		} else {
			resultado = Math.abs(i * fatorial(i - 1));
		}
		return resultado;
	}

}