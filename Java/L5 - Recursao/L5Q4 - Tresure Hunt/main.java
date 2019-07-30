import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		int corredor = in.nextInt();
		int quantArmarios = in.nextInt();
		if (corredor == 0 || quantArmarios == 0) {
			System.out.print("Sharpay endoidou!");
		} else {
			int[][] escola = new int [corredor][quantArmarios];
			for (int auxLinha = 0; auxLinha < corredor; auxLinha++) {
				for (int auxColuna = 0; auxColuna < quantArmarios; auxColuna++) {
					escola[auxLinha][auxColuna] = in.nextInt();
				}
			}if (funcaoEscola(escola, corredor, quantArmarios, 0, 0, 0)[0] == -1) {
				System.out.print("Voce foi descoberto! Corra dancando Bop To the Top!!");
			}else if (funcaoEscola(escola, corredor, quantArmarios, 0, 0, 0)[0] == -2) {
				System.out.print("Sharpay endoidou!");
			} else {
				int resultadoFinalX = funcaoEscola(escola, corredor, quantArmarios, 0, 0, 0)[0] + 1;
				int resultadoFinalY = funcaoEscola(escola, corredor, quantArmarios, 0, 0, 0)[1] + 1;
				System.out.printf("O armario a ser invadido fica no corredor %d, e e o armario de numero %d.", resultadoFinalX, resultadoFinalY);
			}
		}
	}
	static int[] funcaoEscola (int[][] escola, int corredor, int quantArmarios, int coordX, int coordY, int procurado) {
		if (escola[coordX][coordY] == procurado) {
			return new int [] {coordX, coordY};
		} if (escola[coordX][coordY] == -1) {
			return new int [] {-1, -1};
		} else {
			if (coordX + 1 < corredor) {
				return funcaoEscola (escola, corredor, quantArmarios, coordX+1, coordY, procurado);
			} else if (coordY + 1 < quantArmarios) {
				return funcaoEscola (escola, corredor, quantArmarios, 0, coordY+1, procurado);
			}
		}
		return new int[] {-2,0};
	}
}