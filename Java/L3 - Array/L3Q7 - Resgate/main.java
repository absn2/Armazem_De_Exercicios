import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner (System.in);
		int quantidade = in.nextInt();
		int[] poderConjunto = new int [quantidade];
		int[] auxFinal = new int [quantidade];
		int [] auxFf = new int [quantidade];
		int[] posicao = new int [quantidade]; 
		int resultadoFinal = 0; // primeira posicao
		int posicaoFinal = 0; // ultima posicao
		int comparando = 0; // comparar somas
		int auxZerou = 0; // numero negativo
		for (int aux = 0; aux < quantidade; aux++) {
			poderConjunto[aux] = in.nextInt(); // armazenar os resultados
		}for (int aux = 0; aux < quantidade; aux++) {
			if (poderConjunto[aux] < 0) { // tirar os resultados que s?o todos negativos
				auxZerou++;
			}else {
				continue;
			}
		} if (auxZerou >= quantidade) {
			System.out.println("E uma armadilha");
		} else {
			for (int auxBubble = 0; auxBubble < quantidade; auxBubble++) {
				for (int aux = auxBubble; aux < quantidade; aux++) {
					auxFinal[auxBubble]+=poderConjunto[aux];
				}for (int aux = auxBubble; aux < quantidade; aux++) {
					auxFf[auxBubble]+=poderConjunto[aux];
					if (auxFf[auxBubble] > auxFinal[auxBubble] || auxFf[auxBubble] == auxFinal[auxBubble]) {
						auxFinal[auxBubble] = auxFf[auxBubble];
						posicao[auxBubble] = aux+1;
					}else {
						continue;
					}
				}if (auxBubble == 0) {
					comparando = auxFinal[auxBubble];
					resultadoFinal = auxBubble+1;
					posicaoFinal = posicao[auxBubble];
				}else if (auxFinal[auxBubble] > comparando || auxFinal[auxBubble] == comparando) { // se for maior ou da preferencia pelos os ultimos
					comparando = auxFinal[auxBubble];
					resultadoFinal = auxBubble+1;
					posicaoFinal = posicao[auxBubble];
				}
				}if (resultadoFinal == posicaoFinal && resultadoFinal != 0) {
					System.out.printf("Naruto deve libertar somente a posicao %d", resultadoFinal);
				}else if (resultadoFinal > 0) {
					System.out.printf("Naruto deve libertar da posicao %d ate a posicao %d", resultadoFinal, posicaoFinal);
				}
		} 
	}
}