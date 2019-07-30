import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner (System.in);
		 int aux = 0;
		 int auxResultadoFinal = 0;
		 int auxZerou = 0;
		 int auxPrint = 0;
		 String auxResultado;
		 String colunajutsu = in.nextLine(); // se inverte ou nao
		 int ninjas = in.nextInt(); // quantidade de ninjas
		 String[] resultado = new String [ninjas];
		 String[] ninjasA = new String [ninjas];
		 int[] potencialA = new int [ninjas];
		 if (colunajutsu.equals("Tudo certo") && ninjas > 0) {
			 while (in.hasNext()) {
				 String nome = in.next();
				 int chackra = in.nextInt(); // qnt de chackra
				 int jutsu = in.nextInt(); // qnt de jutsu
				 int potencial = chackra - jutsu;
				 potencialA[aux] = potencial;
				 if (potencial > 0) {
					 resultado[aux] =nome+" esta classificado(a)";
					 auxPrint++;
				 }else {
					 resultado[aux] =nome+" esta desclassificado(a)";
					 auxZerou++;
				 }
				 aux++;
			 }	 
		 }else if (colunajutsu.equals("Esse naruto...") && ninjas > 0) {
			 int[] jutsuA = new int [ninjas]; 
			 int[] chackraA = new int [ninjas]; // armezana os jutsus para inverter
			 while (in.hasNext()) {
				 String nome = in.next();
				 ninjasA[aux] = nome;
				 int chackra = in.nextInt();
				 int jutsu = in.nextInt();
				 jutsuA[ninjas-1-aux] = jutsu;
				 chackraA[aux] = chackra;
				 aux++;
		   }for (int auxFor = 0; auxFor < ninjas; auxFor++) {
			   potencialA[auxFor] = chackraA[auxFor] - jutsuA[auxFor];
			   if (potencialA[auxFor] > 0) {
				   resultado[auxFor] =ninjasA[auxFor]+" esta classificado(a)";
				   auxPrint++;
				 }else {
					resultado[auxFor] =ninjasA[auxFor]+" esta desclassificado(a)";
					auxZerou++;
				 }
			   }
		   }
		 //bubblesort 
		 for (int auxBooble1 = 0;auxBooble1 < ninjas; auxBooble1++) {
		    for (int auxBooble = 0, auxPotencia = 0; auxBooble < ninjas-1; auxBooble++) {
			  if (potencialA[auxBooble] < potencialA[auxBooble+1]) {
				 auxPotencia = potencialA[auxBooble];
				 auxResultado = resultado[auxBooble];
				 potencialA[auxBooble] = potencialA[auxBooble+1];
				 resultado[auxBooble] = resultado[auxBooble+1];
				 potencialA[auxBooble+1] = auxPotencia;
				 resultado[auxBooble+1] = auxResultado;
		     }
		    }
		 }
		 while (auxResultadoFinal < ninjas) {
			System.out.println(resultado[auxResultadoFinal]);
			auxResultadoFinal++;
		}if (auxZerou < ninjas) {
		System.out.printf("\nKakashi tera um total de %d aluno(s) nesse semestre", auxPrint);
		} else {
		    System.out.printf("\nEsse semestre ninguem veio treinar na aldeia da folha");
		}
		
		}
	}
	