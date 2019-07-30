import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
   Scanner in = new Scanner(System.in);
		String[][] tabuleiro = new String[8][8];
		int coordX = 0;
		int coordY = 0;
		int auxCapturou = 0;
		int auxZerou = 0;
		for (int auxLinha = 0; auxLinha < tabuleiro.length; auxLinha++) {
			for (int auxColuna = 0; auxColuna < tabuleiro.length; auxColuna++) {
				tabuleiro[auxLinha][auxColuna] = in.next();
				if (tabuleiro[auxLinha][auxColuna].equals("#")) {
					coordX = auxLinha;
					coordY = auxColuna;
				} else {
					continue;
				}
			}
		}
		int acoes = in.nextInt();
		for (int aux = 0; aux < acoes && auxZerou == 0; aux++) {
			String movimento = in.next();
			if (movimento.equals("D")) {
				if (coordX-2 < 0) {
					if (tabuleiro[coordX-1][coordY+1].equals("%")) {
						System.out.print("\nVoce nao pode capturar essa peca.");
					} else if (tabuleiro[coordX-1][coordY+1].equals("*")) {
						tabuleiro[coordX][coordY] = "*";
						tabuleiro[coordX - 1][coordY + 1] = "#";
						System.out.printf("\nVoce avancou para a casa (%d,%d).", coordX - 1, coordY + 1);
					}
				} else {
					if (tabuleiro[coordX-1][coordY+1].equals("%") && tabuleiro[coordX-2][coordY+2].equals("%") || tabuleiro[coordX-1][coordY+1].equals("%") && coordY+2 == tabuleiro.length) {
						System.out.print("\nVoce nao pode capturar essa peca.");
					} else if (tabuleiro[coordX - 1][coordY + 1].equals("%") && tabuleiro[coordX - 2][coordY + 2].equals("*")) {
						tabuleiro[coordX][coordY] = "*";
						tabuleiro[coordX - 1][coordY + 1] = "*";
						tabuleiro[coordX - 2][coordY + 2] = "#";
						auxCapturou += 1;
						System.out.printf("\nVoce capturou uma peca na casa (%d,%d) e avancou para a casa (%d,%d).", coordX - 1, coordY + 1, coordX - 2, coordY + 2);
						coordX = coordX - 2;
						coordY = coordY + 2;
					} else if (coordY-2 >= 0 && tabuleiro[coordX - 1][coordY + 1].equals("*") && tabuleiro[coordX - 1][coordY - 1].equals("%") && tabuleiro[coordX - 2][coordY - 2].equals("*")) {
						tabuleiro[coordX][coordY] = "*";
						tabuleiro[coordX - 1][coordY + 1] = "#";
						auxZerou += 1;
						System.out.printf("\nVoce avancou para a casa (%d,%d).", coordX - 1, coordY + 1);
						System.out.printf("\nVoce deveria ter capturado a peca na casa (%d,%d).", coordX - 1, coordY - 1);
					} else {
						tabuleiro[coordX][coordY] = "*";
						tabuleiro[coordX - 1][coordY + 1] = "#";
						System.out.printf("\nVoce avancou para a casa (%d,%d).", coordX - 1, coordY + 1);
						coordX = coordX - 1;
						coordY = coordY + 1;
					}
				}
			} else if (movimento.equals("E")) {
				if (coordX-2 < 0 || coordY-2 < 0) {
					if (tabuleiro[coordX-1][coordY-1].equals("%")) {
						System.out.print("\nVoce nao pode capturar essa peca.");
					} else if (tabuleiro[coordX-1][coordY-1].equals("*")) {
						tabuleiro[coordX][coordY] = "*";
						tabuleiro[coordX - 1][coordY - 1] = "#";
						System.out.printf("\nVoce avancou para a casa (%d,%d).", coordX - 1, coordY - 1);
					}
				}
				else {
					if (tabuleiro[coordX - 1][coordY - 1].equals("%") && tabuleiro[coordX - 2][coordY - 2].equals("%")) {
						System.out.print("\nVoce nao pode capturar essa peca.");
					} else if (tabuleiro[coordX - 1][coordY - 1].equals("%") && tabuleiro[coordX - 2][coordY - 2].equals("*")) {
						tabuleiro[coordX][coordY] = "*";
						tabuleiro[coordX - 1][coordY - 1] = "*";
						tabuleiro[coordX - 2][coordY - 2] = "#";
						auxCapturou += 1;
						System.out.printf("\nVoce capturou uma peca na casa (%d,%d) e avancou para a casa (%d,%d).", coordX - 1, coordY - 1, coordX - 2, coordY - 2);
						coordX = coordX - 2;
						coordY = coordY - 2;
					} else if (tabuleiro[coordX - 1][coordY - 1].equals("*") && tabuleiro[coordX - 1][coordY + 1].equals("%") && tabuleiro[coordX - 2][coordY + 2].equals("*")) {
						tabuleiro[coordX][coordY] = "*";
						tabuleiro[coordX - 1][coordY - 1] = "#";
						auxZerou += 1;
						System.out.printf("\nVoce avancou para a casa (%d,%d).", coordX - 1, coordY - 1);
						System.out.printf("\nVoce deveria ter capturado a peca na casa (%d,%d).", coordX - 1, coordY + 1);
					} else {
						tabuleiro[coordX][coordY] = "*";
						tabuleiro[coordX - 1][coordY - 1] = "#";
						System.out.printf("\nVoce avancou para a casa (%d,%d).", coordX - 1, coordY - 1);
						coordX = coordX - 1;
						coordY = coordY - 1;
					}
				}
			}
		}for (int auxLinha = 0; auxLinha < tabuleiro.length; auxLinha++) {
			for (int auxColuna = 0; auxColuna < tabuleiro.length; auxColuna++) {
				if (auxLinha == 0 && auxColuna == 0) {
					System.out.print("\n"+tabuleiro[auxLinha][auxColuna]+" ");
				}
				else if (auxColuna == tabuleiro.length - 1) {
					System.out.print(tabuleiro[auxLinha][auxColuna]+"\n");
				} else {
					System.out.print(tabuleiro[auxLinha][auxColuna]+" ");
				}
			}
		}System.out.printf("Voce capturou %d pecas.\n", auxCapturou);
		if (auxZerou != 0) {
			System.out.print("Deu sopro.");
		}
	}
}