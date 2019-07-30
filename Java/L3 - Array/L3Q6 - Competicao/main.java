import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
     Scanner in = new Scanner (System.in);
		int[] alvo = new int [in.nextInt()];
		int quantKunais = in.nextInt();
		int aux = 0;
		int[] sasuke = new int [quantKunais];
		int[] itachi = new int [quantKunais];
		int somaSasuke = 0;
		int somaItachi = 0;
		for (aux = 0; aux < quantKunais; aux++) { // posicao kunai sasuke
			sasuke[aux] = in.nextInt();
		}for (aux = 0; aux < quantKunais; aux++) {
			itachi[aux] = in.nextInt(); // posicao kunai itachi	
		}if (alvo.length % 2 == 0) { // alvo par
			for (int somaAux = 0,auxAlvo = 0; auxAlvo < alvo.length/2; auxAlvo++) {
				somaAux+=1;
				alvo[auxAlvo] = somaAux;
				alvo[alvo.length-1-auxAlvo] = somaAux;
				}
	    } else if (alvo.length%2 != 0) { // alvo impar
	    	int somaAux = 0;
	    	for (int auxAlvo = 0; auxAlvo < alvo.length/2; auxAlvo++) {
				somaAux++;
				alvo[auxAlvo] = somaAux;
				alvo[alvo.length-1-auxAlvo] = somaAux;
				}
	    	alvo[alvo.length/2] = somaAux+1;
	    }for (int auxB = 0; auxB < sasuke.length; auxB++) { // remover coencidencia do sasuke
	    	for (aux = 0; aux < sasuke.length; aux ++) {
	    		if (sasuke[auxB]==sasuke[aux] && auxB != aux) {
	    			sasuke[aux] = 0;
	    		}else {
	    			continue;
	    		}
	    	}
	    }for (aux = 0; aux < sasuke.length; aux++) { // soma do sasuke
	    	if (sasuke[aux] > alvo.length || sasuke[aux] <= 0) {
	    		somaSasuke+=0;
	    	}else {
	    		somaSasuke+=alvo[sasuke[aux]-1];
	    	}
	    }for (int auxB = 0; auxB < itachi.length; auxB++) { // remover coencidencia do tiachi
	    	for (aux = 0; aux < itachi.length; aux ++) {
	    		if (itachi[auxB]==itachi[aux] && auxB != aux) {
	    			itachi[aux] = 0;
	    		}else {
	    			continue;
	    		}
	    	}
	    }for (aux = 0; aux < itachi.length; aux++) { // soma do itachi
	    	if (itachi[aux] > alvo.length || itachi[aux] <= 0) {
	    		somaItachi+=0;
	    	}else {
	    		somaItachi+= alvo[itachi[aux]-1];
	    	}
	    }if (somaItachi == 0 && somaSasuke >0 ) {
	    	System.out.printf("Sasuke: %d\n", somaSasuke);
	    	System.out.printf("Itachi: %d\n", somaItachi);
	    	System.out.print("Sasuke Uchiha\n");
	    	System.out.print("Um genjutsu desse nivel nao funciona em mim");
	    }if (somaItachi > 0 && somaSasuke == 0) {
	    	System.out.printf("Sasuke: %d\n", somaSasuke);
	    	System.out.printf("Itachi: %d\n", somaItachi);
	    	System.out.print("Itachi Uchiha\n");
	    	System.out.print("Voce e fraco, lhe falta odio");
	    }if (somaItachi == 0 && somaSasuke == 0) {
	    	System.out.printf("Sasuke: %d\n", somaSasuke);
	    	System.out.printf("Itachi: %d\n", somaItachi);
	    	System.out.print("Os Uchihas nem sao tao bons mesmo");
	    }if (somaItachi == somaSasuke && somaItachi != 0) {
	    	System.out.printf("Sasuke: %d\n", somaSasuke);
	    	System.out.printf("Itachi: %d\n", somaItachi);
	    	System.out.print("O empate nunca existiu, voce esta preso num genjutsu");
	    }if (somaItachi > somaSasuke && somaSasuke != 0) {
	    	System.out.printf("Sasuke: %d\n", somaSasuke);
	    	System.out.printf("Itachi: %d\n", somaItachi);
	    	System.out.print("Itachi Uchiha\n");
	    }if (somaSasuke > somaItachi && somaItachi != 0) {
	    	System.out.printf("Sasuke: %d\n", somaSasuke);
	    	System.out.printf("Itachi: %d\n", somaItachi);
	    	System.out.print("Sasuke Uchiha\n");
	    }
	}
}