import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
     Scanner in = new Scanner (System.in);
		int[] tamanho = new int [in.nextInt()];
		int valor[] = new int [tamanho.length];
		int aux = 0;
		int resultante = 0;
		int loop = 0;
		boolean confirma = true;
		while (aux < tamanho.length) {
			valor[aux] = in.nextInt();
			aux++;
		}int valorDesejo = in.nextInt();
		for (aux = 0; aux < tamanho.length && confirma == true; aux++) {
			valorDesejo-=valor[aux];
			resultante+=valor[aux];
			if (valorDesejo == 0) {
			System.out.printf("%d %d", aux, loop);
			confirma = false;
			}
		}if (valorDesejo < 0 && resultante >= 0 && confirma == true || valorDesejo >= 0 && resultante <= 0 && confirma == true|| resultante == 0 && valorDesejo > 0 && confirma == true) {
		 System.out.println("Esse numero deve estar errado...");
		}else {
			confirma = true;
			if (valorDesejo > resultante && resultante > 0 || valorDesejo < resultante && resultante < 0) {
				for(loop = 1; valorDesejo > 0 && resultante >0|| valorDesejo < 0 && resultante < 0; loop++) {
					for(aux = 0; aux < tamanho.length && confirma == true; aux++) {
						valorDesejo = valorDesejo - valor[aux];
						if (valorDesejo == 0) {
							confirma = false;
							System.out.printf("%d %d", aux, loop);
						}
					}
			    } if (valorDesejo!=0) {
			    	System.out.println("Esse numero deve estar errado...");
			    }
			}else if (valorDesejo <= resultante && valorDesejo >0 || valorDesejo >= resultante && valorDesejo <0) {
				loop = 1;
				confirma = true;
				for (aux=0; aux < tamanho.length && confirma == true; aux++) {
					   valorDesejo = valorDesejo - valor[aux];
					   if (valorDesejo == 0) {
					   System.out.printf("%d %d", aux, loop);
							confirma = false;
						}
				}if (valorDesejo < 0 && resultante >= 0 || valorDesejo > 0 && resultante <0) {
				System.out.println("Esse numero deve estar errado...");
			}
		}
		
	}
		}
}