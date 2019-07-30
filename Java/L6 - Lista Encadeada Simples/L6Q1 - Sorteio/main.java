import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		Lista carrinhos = new Lista();
		while (in.hasNext()) {
			int carro = in.nextInt();
			carrinhos.inserir(carro);
		}
		int procurado = carrinhos.procurar();
		int[] sorteio = carrinhos.sorteio(procurado, 1);
		if (sorteio[0] == 0) {
			System.out.print("Nenhum carrinho foi sorteado");
		} else {
			System.out.printf("O bilhete sorteado e o %d e esta no carrinho %d", sorteio[1], sorteio[0]);
		}
	}
}
class Lista {
   private int carrinho;
		private Lista carrinhoProximo;
		
		public Lista() {
			this.carrinho = 0;
			this.carrinhoProximo = null;
		}
		public void inserir (int valor) {
			if (this.carrinho == 0) {
				this.carrinho = valor;
				this.carrinhoProximo = new Lista();
			}
			else {
				this.carrinhoProximo.inserir(valor);
			}
		}
		public int procurar () {
			int resultado = 0;
			if (this.carrinho != -1) {
				return this.carrinhoProximo.procurar();
			} 
			else {
				resultado = this.carrinhoProximo.carrinho;
				return resultado;
			}
		}
		public int[] sorteio (int resultado, int contador) {
			if (this.carrinho == resultado) {
				return new int[] {contador, resultado};
			} 
			else if (this.carrinho == -1) {
				return new int [] {0, 0};
			}
			else {
				return this.carrinhoProximo.sorteio(resultado, contador+1);
			}
		}
	}