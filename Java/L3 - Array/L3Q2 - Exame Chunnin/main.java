import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner (System.in);
		String [] lutadores = new String [8];
		String ninja1 = in.nextLine();
		lutadores[0] = ninja1;
		String ninja2 = in.nextLine();
		lutadores[1] = ninja2;
		String ninja3 = in.nextLine();
		lutadores[2] = ninja3;
		String ninja4 = in.nextLine();
		lutadores[3] = ninja4;
		String ninja5 = in.nextLine();
		lutadores[4] = ninja5;
		String ninja6 = in.nextLine();
		lutadores[5] = ninja6;
		String ninja7 = in.nextLine();
		lutadores[6] = ninja7;
		String ninja8 = in.nextLine();
		lutadores[7] = ninja8;
		System.out.print("Bem vindos ao Exame Chunnin!\n");
		int index1 = in.nextInt();
		int index2 = in.nextInt();
		System.out.printf("Quartas de final 1: %s x %s\n", lutadores[index1], lutadores[index2]);
		int index3 = in.nextInt();
		int index4 = in.nextInt();
		System.out.printf("Quartas de final 2: %s x %s\n", lutadores[index3], lutadores[index4]);
		int index5 = in.nextInt();
		int index6 = in.nextInt();
		System.out.printf("Quartas de final 3: %s x %s\n", lutadores[index5], lutadores[index6]);
		int index7 = in.nextInt();
		int index8 = in.nextInt();
		System.out.printf("Quartas de final 4: %s x %s\n", lutadores[index7], lutadores[index8]);
		String quartas1 = in.next();
		String quartas2 = in.next();
		String quartas3 = in.next();
		String quartas4 = in.next();
		String [] quartas = new String [4]; // quais das quartas vao pra semis
		if (quartas1.equals("A")) {
			quartas[0] = lutadores[index1];
		}else if (quartas1.equals("B")) {
			quartas[0] = lutadores[index2];
		}if (quartas2.equals("A")) {
			quartas[1] = lutadores[index3];
		}else if (quartas2.equals("B")) {
			quartas[1] = lutadores[index4];
		}if (quartas3.equals("A")) {
			quartas[2] = lutadores[index5];
		}else if (quartas3.equals("B")) {
			quartas[2] = lutadores[index6];
		}if (quartas4.equals("A")) {
			quartas[3] = lutadores[index7];
		}else if (quartas4.equals("B")) {
			quartas[3] = lutadores[index8];
		}System.out.printf("Semifinal 1: %s x %s\n", quartas[0], quartas[1]);
		System.out.printf("Semifinal 2: %s x %s\n", quartas[2], quartas[3]);	
		String [] semis = new String [2]; // quais das semis vao pra final
		String semi1 = in.next();
		String semi2 = in.next();
		if (semi1.equals("X")) {
			semis[0] = quartas[0];
		}else if (semi1.equals("Y")) {
			semis[0] = quartas[1];
		}if (semi2.equals("X")) {
			semis[1] = quartas[2];
		}else if (semi2.equals("Y")) {
			semis[1] = quartas[3];
		}System.out.printf("Final: %s x %s\n", semis[0], semis[1]);
		String finalResultado = in.next();
		if (finalResultado.equals("#")) {
			String campeao;
			campeao = semis[0];
			System.out.printf("O grande vencedor e %s!", campeao);
		}else if (finalResultado.equals("%")) {
		    String campeao;
			campeao = semis[1];
			System.out.printf("O grande vencedor e %s!", campeao);
		}
	}
}