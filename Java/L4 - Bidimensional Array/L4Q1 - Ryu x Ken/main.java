import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner (System.in);
		int matriz = in.nextInt();
		double vidaRyu = in.nextInt();
		double vidaKen = in.nextInt();
		int[][] matrizRyu = new int[matriz][matriz];
		int[][] matrizKen = new int[matriz][matriz];
		double ataqueRyu = 0;
		double ataqueKen = 0;
		double defesaRyu = 0;
		double defesaKen = 0;
		for (int auxLinha = 0; auxLinha < matriz; auxLinha++) {
			for (int auxColuna = 0; auxColuna < matriz; auxColuna++) {
				matrizRyu[auxLinha][auxColuna] = in.nextInt();
			}
		}for (int auxLinha = 0; auxLinha < matriz; auxLinha++) {
			for (int auxColuna = 0; auxColuna < matriz; auxColuna++) {
				matrizKen[auxLinha][auxColuna] = in.nextInt();
			}
		}for (int auxLinha = 0, auxColuna = 0; auxLinha < matriz; auxLinha++, auxColuna++) {
			ataqueRyu+=matrizRyu[auxLinha][auxColuna]; 
		}for (int auxLinha = 0, auxColuna = 0; auxLinha < matriz; auxLinha++, auxColuna++) {
			ataqueKen+=matrizKen[auxLinha][auxColuna]; 
		}for (int auxLinha = 0, auxColuna = matriz-1; auxLinha < matriz; auxLinha++, auxColuna--) {
			defesaRyu+=matrizRyu[auxLinha][auxColuna]; 
		}for (int auxLinha = 0, auxColuna = matriz-1; auxLinha < matriz; auxLinha++, auxColuna--) {
			defesaKen+=matrizKen[auxLinha][auxColuna]; 
		}int acoes = in.nextInt();
		for (int aux = 0; aux < acoes; aux++) {
			String acaoRyu = in.next();
			String acaoKen = in.next();
			if (acaoRyu.equals("A") && acaoKen.equals("A")) {
				if (ataqueRyu > ataqueKen) {
					vidaKen-=(ataqueRyu-ataqueKen);
				}else if (ataqueKen > ataqueRyu) {
					vidaRyu-=(ataqueKen-ataqueRyu);
				}
			}else if (acaoRyu.equals("A") && acaoKen.equals("D")) {
				if (ataqueRyu > defesaKen) {
					vidaKen-=(ataqueRyu-defesaKen)/2;
				}else if (defesaKen > ataqueRyu) {
					vidaRyu+=0;
				}
			}else if (acaoRyu.equals("D") && acaoKen.equals("A")) {
				if (defesaRyu > ataqueKen) {
					vidaKen+=0;
				}else if (ataqueKen > defesaRyu) {
					vidaRyu-=(ataqueKen-defesaRyu)/2;
				}
			}else if (acaoRyu.equals("D") && acaoKen.equals("D")) {
				vidaKen+=0;
				vidaRyu+=0;
			}
		}if (vidaRyu > vidaKen) {
			System.out.println("Ryu ganhou a batalha.");
		}else if (vidaKen > vidaRyu) {
			System.out.println("Ken ganhou a batalha.");
		}else {
			System.out.print("Houve empate.");
		}
	}
}