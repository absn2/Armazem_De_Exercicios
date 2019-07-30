import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Pilha pilha = new Pilha();
		String parenteses = in.nextLine();
		char fila[] = parenteses.toCharArray();
		int resultado = 0;
		for (int aux = 0; aux < fila.length; aux++) {
			char auxChar = fila[aux];
			if (auxChar == '(') {
				pilha.push(fila[aux]);
			} else {
				if (pilha.length() > 0) {
					pilha.pop();
					resultado = resultado + 2;
				}
			}

		}
		System.out.print(resultado);
	}
}
class Pilha {
	private No topo;
	private int tamanho;
	
	public Pilha() {
		topo = null;
		tamanho = 0;
	}
	
	public int length() {
		return this.tamanho;
	}
	public void push(Object elemento) {
		No novo = new No (elemento, topo);
		topo = novo;
		tamanho++;
	}
	
	 public Object pop() {
		if (tamanho == 0) {
			System.out.println("EMPTY");
			return null;
		} else {
			Object aux = topo.getTopo();
			this.topo = this.topo.getAnterior();
			tamanho--;
			return aux;
		}
	}
}
class No {
	private Object element;
	private No elementAnterior;

	public No(Object element, No elementAnterior) {
		this.element = element;
		this.elementAnterior = elementAnterior;
	}

	public No getAnterior() {
		return elementAnterior;
	}

	public Object getTopo() {
		return element;
	}

}