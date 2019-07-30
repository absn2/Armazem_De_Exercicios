import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int amigos = in.nextInt();
		String[] amigosArray = new String [amigos];
		int[] fome = new int [amigos];
		String[] amigosArrayInvertido = new String [amigos];
		int[] fomeInvertida = new int [amigos];
		for (int aux = 0; aux < amigos; aux++) {
			amigosArray[aux] = in.next();
			fome[aux] = in.nextInt();
		}
		amigosArray = inverteString(amigosArray, amigosArrayInvertido, amigos, amigos-1, 0);
		fome = inverteInt(fome, fomeInvertida, amigos, amigos-1, 0);
		for (int aux = 0; aux < amigos; aux++) {
			int resultado = fome[aux] - 400;
			if (resultado <= 0) {
				System.out.printf("\n%s foi servido(a).", amigosArray[aux]);
			} else {
				System.out.printf("\n%s foi servido(a).",  amigosArray[aux]);
				System.out.printf("\nFica tranquilo(a), %s pode se servir novamente!",  amigosArray[aux]);
				while (resultado > 0) {
					resultado-=400;
					if (resultado <= 0) {
						System.out.printf("\n%s foi servido(a).",  amigosArray[aux]);
					} else {
						System.out.printf("\n%s foi servido(a).",  amigosArray[aux]);
						System.out.printf("\nFica tranquilo(a), %s pode se servir novamente!",  amigosArray[aux]);
					}
				}
			}
		}
	}
	static String[] inverteString(String[] amigosArray, String[] amigosArrayInvertido, int tamanhoReal, int tamanho, int novo) {
		String aux ;
		if (tamanhoReal == 0) {
			return amigosArrayInvertido;
		} else {
			amigosArrayInvertido[novo] = amigosArray[tamanho];
			return inverteString(amigosArray, amigosArrayInvertido, tamanhoReal-1, tamanho-1, novo+1);
		}
	}
	static int[] inverteInt(int[] fome, int[] fomeInvertida, int tamanhoReal, int tamanho, int novo) {
		int aux ;
		if (tamanhoReal == 0) {
			return fomeInvertida;
		} else {
			fomeInvertida[novo] = fome[tamanho];
			return inverteInt(fome, fomeInvertida, tamanhoReal-1, tamanho-1, novo+1);
		}
	}
}