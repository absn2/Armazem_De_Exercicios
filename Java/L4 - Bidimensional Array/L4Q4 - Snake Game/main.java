import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
  Scanner in = new Scanner(System.in);
		int matriz = in.nextInt();
		int acoes = in.nextInt();
		String[][] mapa = new String[matriz][matriz];
		int cobraX = 0;
		int cobraY = 0;
		int auxZerou = 0;
		for (int auxLinha = 0; auxLinha < matriz; auxLinha++) {
			for (int auxColuna = 0; auxColuna < matriz; auxColuna++) {
				mapa[auxLinha][auxColuna] = in.next();
				if (mapa[auxLinha][auxColuna].equals("#")) {
					cobraX = auxLinha;
					cobraY = auxColuna;
				}
			}
		}
		for (int aux = 0; aux < acoes && auxZerou == 0; aux++) {
			String cobraMoves = in.next();
			if (cobraMoves.equals("D")) { // cobra se movimenta para direita
				if (cobraY + 1 == matriz) {
					if (mapa[cobraX][0].equals("@")) {
						auxZerou = 1;
					} else {
						mapa[cobraX][0] = "#";
						mapa[cobraX][matriz - 1] = "*";
						cobraY = 0;
					}
				} else if (mapa[cobraX][cobraY+1].equals("@")) {
					auxZerou = 1;
				} else {
					mapa[cobraX][cobraY + 1] = "#";
					mapa[cobraX][cobraY] = "*";
					cobraY = cobraY + 1;
				}
			} else if (cobraMoves.equals("E")) { // cobra se movimenta esquerda
				if (cobraY - 1 < 0) {
					if (mapa[cobraX][matriz - 1].equals("@")) {
						auxZerou = 1;
					} else {
						mapa[cobraX][matriz - 1] = "#";
						mapa[cobraX][0] = "*";
						cobraY = matriz-1;
					}
				} else if (mapa[cobraX][cobraY-1].equals("@")) {
					auxZerou = 1;
				} else {
					mapa[cobraX][cobraY-1] = "#";
					mapa[cobraX][cobraY] = "*";
					cobraY = cobraY - 1;
				}
			} else if (cobraMoves.equals("C")) { // cobra se movimenta pra cima
				if (cobraX - 1 < 0) {
					if (mapa[matriz - 1][cobraY].equals("@")) {
						auxZerou = 1;
					} else {
						mapa[matriz - 1][cobraY] = "#";
						mapa[0][cobraY] = "*";
						cobraX = matriz-1;
					}
				} else if (mapa[cobraX - 1][cobraY].equals("@")) {
					auxZerou = 1;
				} else {
					mapa[cobraX - 1][cobraY] = "#";
					mapa[cobraX][cobraY] = "*";
					cobraX = cobraX - 1;
				}
			} else if (cobraMoves.equals("B")) { // cobra se movimenta pra baixo
				if (cobraX + 1 == matriz) {
					if (mapa[0][cobraY].equals("@")) {
						auxZerou = 1;
					} else {
						mapa[0][cobraY] = "#";
						mapa[cobraX][cobraY] = "*";
						cobraX = 0;
					}
				} else if (mapa[cobraX + 1][cobraY].equals("@")) {
					auxZerou = 1;
				} else {
					mapa[cobraX + 1][cobraY] = "#";
					mapa[cobraX][cobraY] = "*";
					cobraX = cobraX + 1;
				}
			}
		}
		for (int auxLinha = 0; auxLinha < matriz; auxLinha++) { // para imprimir
			for (int auxColuna = 0; auxColuna < matriz; auxColuna++) {
				if (auxColuna == matriz - 1) {
					System.out.print(mapa[auxLinha][auxColuna] + "\n");
				} else {
					System.out.print(mapa[auxLinha][auxColuna] + " ");
				}
			}
		}
		if (auxZerou > 0) {
			System.out.print("Game over.");
		}
	}
}