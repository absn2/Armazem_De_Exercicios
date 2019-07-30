import java.util.*;

public class mainasd {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numero = in.nextInt();
		int resultadoF1 = 0;
		int resultadoF2 = 0;
		if (numero == 1) {
			System.out.print("-1");
		} else {
			if (numero % 2 == 0) {
				resultadoF1 = numero;
				for (int aux = resultadoF1; aux > 0; aux--) {
					if (resultadoF1 % aux == 0) {
						resultadoF2 = aux;
						break;
					}
				}
			} else {
				resultadoF1 = numero - 1;
				for (int aux = resultadoF1; aux > 0; aux--) {
					if (resultadoF1 % aux == 0) {
						resultadoF2 = aux;
						break;
					}
				}
			}
			System.out.println(resultadoF1 + " " + resultadoF2);
		}
	}
}