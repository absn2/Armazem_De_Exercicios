import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int quantListas = in.nextInt();
		int acumulativo = 0;
		boolean parou = false;
		Lista estante = new Lista();
		if (quantListas == 0) {
			System.out.print("Nao tem livros por aqui");
		} else {
			for (int aux = 0; aux < quantListas && parou == false; aux++) {
				int quantLivros = in.nextInt();
				in.nextLine();
				for (int auxLista = 0; auxLista < quantLivros; auxLista++) {
					String livro = in.nextLine();
					estante.inserir(livro);
				}
				int contador = 1;
				int[] procurado = estante.procurar(aux+1, contador, acumulativo);
				acumulativo+= quantLivros;
				if (procurado[0] == 0) {
					continue;
				} else {
					System.out.printf("Og Loc, o livro ta na estante %d, na posicao %d", procurado[0], procurado[1]);
					parou = true;
				}
			}
			if (parou == false) {
				System.out.print("Og Loc, o livro nao esta aqui!");
			}
		}

	}
}
class Lista {
        private String livro;
		private Lista livroProximo;
		
		public Lista() {
			this.livro = null;
			this.livroProximo = null;
		}
		public void inserir (String nome) {
			if (this.livro == null) {
				this.livro = nome;
				this.livroProximo = new Lista();
			}
			else {
				this.livroProximo.inserir(nome);
			}
		}
		public int[] procurar (int quantListas, int contador, int acumulativo) {
			if (this.livro != null) {
			    if (!this.livro.equals("Livro de Rimas")) {
				    return this.livroProximo.procurar(quantListas, contador+1, acumulativo);
			    } else {
			        if (quantListas != 1) {
			        	return new int [] {quantListas, contador - acumulativo};
			        } else {
			        	return new int [] {quantListas, contador};
			        }
			    }
	        }
	        else {
	            return new int [] {0,0};
	        }
		}
}
	 