import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean parou = false;
		Lista pedidos = new Lista();
		while (parou == false) {
			String pedido = in.nextLine();
			if (pedido.equals("The End")) {
				parou = true;
			} else {
				pedidos.inserir(pedido);
			}
		}
		while (in.hasNext()) {
			String remover = in.nextLine();
			pedidos.remover(remover);
		}
		String imprimir = "";
		imprimir = pedidos.imprimir(imprimir);
		if (imprimir.equals("")) {
			System.out.print("U gotta null pointer ma man");
		} else {
			System.out.print(imprimir);
		}
	}
}
class Lista {
	private String pedido;
	private Lista pedidoProximo;

	public Lista() {
		this.pedido = null;
		this.pedidoProximo = null;
	}

	public void inserir(String pedido) {
		if (this.pedido == null) {
			this.pedido = pedido;
			this.pedidoProximo = new Lista();
		} else {
			this.pedidoProximo.inserir(pedido);
		}
	}

	public void remover(String pedido) {
		if (pedido != null) {
			if (this.pedido.equals(pedido)) {
				this.pedido = this.pedidoProximo.pedido;
				this.pedidoProximo = this.pedidoProximo.pedidoProximo;
			} else {
			    this.pedidoProximo.remover(pedido);
			}
		}
	}

	public String imprimir(String resultado) {
		if (this.pedido != null) {
			resultado += this.pedido + "\n";
			return this.pedidoProximo.imprimir(resultado);
		}
		return resultado;

	}
}