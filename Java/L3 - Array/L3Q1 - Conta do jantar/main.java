import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
     Scanner in = new Scanner (System.in);
		int dinheiro = in.nextInt(); // dinheiro
		int [] tigelas = new int[in.nextInt()]; // dias
		int auxDias = tigelas.length;
		int auxArray = 0;
		int soma = 0;//
		while (auxDias > 0) {
			int tigelasdia = in.nextInt(); // qntas tigelas no dia;
			if (tigelasdia == 1) {
				tigelasdia = 10;
			}else if (tigelasdia >=2 && tigelasdia <=10) {
				tigelasdia = (9*tigelasdia);
			}else if (tigelasdia > 10) {
				tigelasdia =  (tigelasdia*8);
			}
			tigelas[auxArray] = tigelasdia;
			auxDias--;
			auxArray++;
		} for (int aux = 0; aux < tigelas.length; aux++) {
			soma+=tigelas[aux];
		}
		if (soma == 0) {
			System.out.println("Naruto nao apareceu para comer");
		}else if (soma <= dinheiro) {
			System.out.println("Naruto conseguiu pagar a sua conta!");
		}else if (soma > dinheiro) {
			soma = soma - dinheiro;
			System.out.printf("Naruto, faltam %d ryos!", soma);
		}
	}

}

    
