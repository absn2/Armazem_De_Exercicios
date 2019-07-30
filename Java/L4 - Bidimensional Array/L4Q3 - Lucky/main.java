import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
		int matriz = in.nextInt();
		int jogadas = in.nextInt();
		int[][] matrizJogo = new int[matriz][matriz];
		int auxZerou = 0;
		for (int auxLinha = 0; auxLinha < matriz; auxLinha++) {
			for (int auxColuna = 0; auxColuna < matrizJogo.length; auxColuna++) {
				matrizJogo[auxLinha][auxColuna] = in.nextInt();
			}
		}
		for (int aux = 0; aux < jogadas && auxZerou == 0; aux++) {
			int coordX = in.nextInt();
			int coordY = in.nextInt();
			int somaBaixo = 0;
			int somaDiagonal = 0;
			int somaLado = 0;
			for (int auxColuna = coordY, auxLinha = coordX; auxLinha < matriz && auxZerou == 0; auxLinha++) {
				if (matrizJogo[auxLinha][auxColuna] == -1) {
					somaBaixo += 0;
				} else {
					somaBaixo += matrizJogo[auxLinha][auxColuna];
				}
			}
			for (int auxColuna = coordY, auxLinha = coordX; auxLinha < matriz && auxColuna < matriz && auxZerou == 0; auxLinha++, auxColuna++) {
				if (matrizJogo[auxLinha][auxColuna] == -1) {
					somaDiagonal += 0;
				} else {
					somaDiagonal += matrizJogo[auxLinha][auxColuna];
				}
			}
			for (int auxColuna = coordY, auxLinha = coordX; auxColuna < matriz && auxZerou == 0; auxColuna++) {
				if (matrizJogo[auxLinha][auxColuna] == -1) {
					somaLado += 0;
				} else {
					somaLado += matrizJogo[auxLinha][auxColuna];
				}
			}
			if (somaBaixo == somaDiagonal && somaBaixo == somaLado) {
				auxZerou++;
			} else if (matrizJogo[coordX][coordY] == -1) {
				System.out.print("\nEssa casa ja foi selecionada.");
			} else {
				System.out.printf("\nBoa jogada, a casa (%d,%d) nao tinha bomba.", coordX, coordY);
				matrizJogo[coordX][coordY] = -1;
			}
		}
		if (auxZerou > 0) {
			System.out.print("\nBomba encontrada.");
			System.out.println("\nVoce perdeu.");
		} else {
			System.out.println("\nVoce e uma pessoa de sorte.");
		}
	}
}
