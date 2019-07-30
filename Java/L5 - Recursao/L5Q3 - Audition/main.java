import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			double nivelProf = in.nextDouble();
			int participantes = in.nextInt();
			String auxNome = null;
			double auxResultado = 0;
			double resultado = 0;
			in.nextLine();
			double[] valor = new double [participantes];
			String[] nomeArray = new String [participantes];
			for (int aux = 0; aux < participantes; aux++) {
				String nome = in.nextLine();
				resultado = somaLetras(nome, nome.length() - 1);
				resultado = resultado * nivelProf;
				if (nome.equals("Troy Bolton") || nome.equals("Gabriella Montez") || nome.equals("Sharpay Evans")
						|| nome.equals("Ryan Evans")) {
					resultado += 350;
				}valor[aux] = resultado;
				nomeArray[aux] = nome;
				nivelProf = nivelProf * 0.99;
			}String nomeVencedor = nomeMaximo(valor, participantes, nomeArray);
			System.out.printf("O grande vencedor(a) do papel principal desse ano foi %s!", nomeVencedor);
		}
		
		static String nomeMaximo (double[] valor, int participantes, String[] nomeArray) { // boobleSort
		    double auxValor = 0;
		    String auxNome = null;
			for (int auxBubble = 0; auxBubble < participantes; auxBubble++) {
		        for (int aux = 0; aux < participantes-1; aux++) {
		            if (valor[aux] < valor[aux+1]) {
		        	    auxValor = valor[aux];
		        	    valor[aux] = valor[aux+1];
		        	    valor[aux+1] = auxValor;
		        	    auxNome = nomeArray[aux];
		        	    nomeArray[aux] = nomeArray[aux+1];
		        	    nomeArray[aux+1] = auxNome;
		            } else {
		        	    continue;
		            }
		        }  
		    }   
		    return nomeArray[0];
		}
		
		static double somaLetras(String nome, int tamanhoNome) { // funcao recursiva
			if (tamanhoNome == 0) {
				return nome.charAt(0);
			} else {
				return nome.charAt(tamanhoNome) + somaLetras(nome, tamanhoNome - 1);
			}
		}
	}