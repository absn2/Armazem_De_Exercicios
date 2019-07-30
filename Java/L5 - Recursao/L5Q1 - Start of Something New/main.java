import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		for (int aux = 0; aux < 2; aux++) {
			double vergonha = in.nextDouble();
			if (aux == 0) {
				String nome = "Troy";
				if (vergonha > bebida(in.nextDouble())) {
				    System.out.printf("\nNao foi dessa vez!! %s nao teve coragem o suficiente.", nome);
			    } else {
				    System.out.printf("\nEsse pode ser o comeco de algo novo!! %s vai cantar!!", nome);
			    }
			}
			else {
				String nome = "Gabriella";
				if (vergonha > bebida(in.nextDouble())) {
				    System.out.printf("\nNao foi dessa vez!! %s nao teve coragem o suficiente.", nome);
			    } else {
				    System.out.printf("\nEsse pode ser o comeco de algo novo!! %s vai cantar!!", nome);
			    }
			}
		}
	}

	static double bebida(double i) {
		double resultado = 0;
		if (i == 0) {
			resultado = 0;
		} else if (i == 1) {
			resultado = 1;
		} else {
			resultado = bebida(i - 1) + bebida(i - 2);
		}
		return resultado;
	}
}