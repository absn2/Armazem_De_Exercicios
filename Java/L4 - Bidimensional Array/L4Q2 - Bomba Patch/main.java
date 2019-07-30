import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner (System.in);
		String[][] matrizNomes = new String [3][3];
		for (int auxLinha = 0; auxLinha < matrizNomes.length; auxLinha++) {
			for (int auxColuna = 0; auxColuna < matrizNomes[0].length; auxColuna++) {
				matrizNomes[auxLinha][auxColuna] = in.next();
			}
		}for (int auxLinha = 0; auxLinha < matrizNomes.length; auxLinha++) {
				for (int auxColuna = 0; auxColuna < matrizNomes[0].length; auxColuna++) {
					if (auxLinha == 0 && auxColuna == 1 || auxLinha == 0 && auxColuna == 2 || auxLinha == 1 && auxColuna == 2) {
						String aux = matrizNomes[auxLinha][auxColuna];
						matrizNomes[auxLinha][auxColuna] = matrizNomes[auxColuna][auxLinha];
						matrizNomes[auxColuna][auxLinha] = aux;
					}
				}
		}for (int auxLinha = 0; auxLinha < matrizNomes.length; auxLinha++) {
			for (int auxColuna = 0; auxColuna < matrizNomes[0].length; auxColuna++) {
				if (auxColuna == matrizNomes[0].length-1) {
					System.out.print(matrizNomes[auxLinha][auxColuna]+"\n");
				}else {
					System.out.print(matrizNomes[auxLinha][auxColuna]+" ");
				}
			}
		}
	}
}
