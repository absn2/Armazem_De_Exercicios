import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean parou = false;
		while (!parou) {
			int tamanho = in.nextInt();
			if (tamanho == 0) {
				parou = true;
			} else {
                                String discartados = "";
				Pilha pilha = new Pilha();
				for (int aux = 0; aux < tamanho; aux++) {
					pilha.push(tamanho - aux);
				}
				while (pilha.length() >= 2) {
					Object aux = pilha.pop();
					if (pilha.length() != 1) {
						discartados = discartados + " " + aux + ",";
					} else {
						discartados = discartados + " " + aux;
					}
					Object array[] = pilha.createArray(pilha.length());
					pilha.clear();
					for (int aux2 = 0; aux2 < array.length; aux2++) {
						pilha.push(array[array.length - aux2 - 1]);
					}

				}
				Object elemento = pilha.imprimir();
				System.out.printf("Discarded cards:%s\n", discartados);
				System.out.printf("Remaining card: %d\n", elemento);
			}
		}

	}
}
class Pilha {
	private No topo;
	private int tamanho;

	public Pilha() {
		this.topo = null;
		this.tamanho = 0;
	}

	public int length() {
		return this.tamanho;
	}

	public void push(Object elemento) {
		No novoNo = new No(elemento, topo);
		topo = novoNo;
		tamanho++;
	}

	public Object pop() {
		if (tamanho == 0) {
			return null;
		} else {
			Object aux = topo.getTopo();
			this.topo = this.topo.getAnterior();
			tamanho--;
			return aux;
		}
	}

	public Object[] createArray(int tamanho) {
		No auxNo = this.topo.getAnterior();
		int aux = 0;
		Object array[] = new Object[tamanho];
		while (auxNo != null) {
			array[aux] = auxNo.getTopo();

			auxNo = auxNo.getAnterior();
			aux++;
		}
		array[array.length - 1] = this.topo.getTopo();
		return array;

	}

	public void clear() {
		this.topo = null;
		this.tamanho = 0;
	}

	public Object imprimir() {
		return this.topo.getTopo();
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
	
	public void setTopo (Object element) {
		this.element = element;
	}

}