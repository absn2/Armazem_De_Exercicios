import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      Scanner in = new Scanner (System.in);
			int quantNinjas = in.nextInt();
			int auxSapo = 0;
			int auxCobra = 0;
			int auxLesmas = 0;
			int auxMacacos = 0;
			int auxCaes = 0;
			int auxZerou = 0;
			String sapo = "Sapos:\n";
			String cobra = "Cobras:\n";
			String lesma = "Lesmas:\n";
			String macaco = "Macacos:\n";
			String cao = "Caes:\n";
			if (quantNinjas <= 0) {
				System.out.println("Nao havera Jounins forte esse ano");
			}else {
			    String[] sapos = new String [quantNinjas];
				String[] cobras = new String [quantNinjas];
				String[] lesmas = new String [quantNinjas];
				String[] macacos = new String [quantNinjas];
				String[] caes = new String [quantNinjas];
			    while (in.hasNext()) {
					String nome = in.nextLine();
					String caracteristica = "";
					String[] nomeD = new String [2];
					if (nome.contains(" ")) {
						nomeD = nome.split(" ");
						nome = nomeD[0];
						if (nomeD.length == 1) {
							caracteristica = "";
						}else {
							caracteristica = nomeD[1];
						}
					}else {
						caracteristica = "";
					}
					if (caracteristica.equals("Coragem") || caracteristica.equals("Determinacao") || caracteristica.equals("Conviccao")) {
						nome = "- "+nome;
						sapos[auxSapo] = nome;
						auxSapo++;
					}else if (caracteristica.equals("Ambicao") || caracteristica.equals("Astucia") || caracteristica.equals("Expertise")) {
						nome = "- "+nome;
						cobras[auxCobra] = nome;
						auxCobra++;
					}else if (caracteristica.equals("Analise") || caracteristica.equals("Suporte") || caracteristica.equals("Tecnica")) {
						nome = "- "+nome;
						lesmas[auxLesmas] = nome;
						auxLesmas++;
					}else if (caracteristica.equals("Agilidade") || caracteristica.equals("Inteligencia") || caracteristica.equals("Destreza")) {
						nome = "- "+nome;
						macacos[auxMacacos] = nome;
						auxMacacos++;
					}else if (caracteristica.equals("Experiencia") || caracteristica.equals("Perspicacia") || caracteristica.equals("Pericia")) {
						nome = "- "+nome;
						caes[auxCaes] = nome;
						auxCaes++;
					}else if (caracteristica.equals("")) {
						auxZerou++;
					}
			    }if (auxZerou < quantNinjas) {
			    	for (int soma = 0; soma < auxSapo; soma++) {
			    		sapo = sapo+sapos[soma]+"\n";
				   }System.out.print(sapo);
				    for (int soma = 0; soma < auxCobra; soma++) {
						cobra = cobra+cobras[soma]+"\n";	
					}System.out.print(cobra);
						for (int soma = 0; soma < auxLesmas; soma++) {
					lesma = lesma+lesmas[soma]+"\n";	
					}System.out.print(lesma);
					for (int soma = 0; soma < auxMacacos; soma++) {
						macaco = macaco+macacos[soma]+"\n";	
					}System.out.print(macaco);
					for (int soma = 0; soma < auxCaes; soma++) {
						cao = cao+caes[soma]+"\n";	
					}System.out.print(cao);	
			    } else if (auxZerou >= quantNinjas) {
			    	System.out.println("Nao havera Jounins forte esse ano");
			    }	
			}
		}
	}