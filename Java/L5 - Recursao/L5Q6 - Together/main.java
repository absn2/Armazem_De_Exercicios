import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int quantPessoas = in.nextInt();
		int quantAcoes = in.nextInt();
		int posicaoNome = 0;
		int posicaoNome2 = 0;
		in.nextLine();
		boolean[][] pessoasMic = new boolean[quantPessoas][quantPessoas];
		String[] pessoas = new String[quantPessoas];
		for (int aux = 0; aux < quantPessoas; aux++) {
			pessoas[aux] = in.nextLine();
		}
		for (int aux = 0; aux < quantAcoes; aux++) {
			pessoasMic[in.nextInt()][in.nextInt()] = true;
		}
		in.nextLine();
		for (int aux = 0; aux < 2; aux++) {
			if (aux == 0) {
				String nome = in.nextLine();
				posicaoNome = posicaoNomeRecur(nome, pessoas, quantPessoas, 0);
			} else {
				String nome = in.nextLine();
				posicaoNome2 = posicaoNomeRecur(nome, pessoas, quantPessoas, 0);
			}
		}
		if (passarMic(pessoasMic, posicaoNome, posicaoNome2, quantPessoas, 0, posicaoNome, 0) == true) {
			System.out.print("We're all in this together!");
		} else {
			System.out.print("Mentira, nenhum filme da Disney da errado, nunca.");
		}
	}

	static boolean passarMic(boolean[][] pessoasMic, int posicaoNome, int posicaoNome2, int quantPessoas, int zero, int falso, int voltar) {
		 if (pessoasMic[falso][posicaoNome2] == true) {
			return true;
		} else if (falso == posicaoNome2) {
			return true;
		} else if (zero == quantPessoas) {
			if (voltar+1 == quantPessoas || posicaoNome == 0 || pessoasMic[posicaoNome-1][voltar+1] == false) {
				return false;
			} else if (pessoasMic[posicaoNome-1][voltar+1] == true ) {
				return passarMic(pessoasMic, 0, posicaoNome2, quantPessoas, voltar+1, falso, 0);
			}
			return passarMic(pessoasMic, 0, posicaoNome2, quantPessoas, voltar+1, falso, 0);
		} else if (zero == posicaoNome+1) {
			if (pessoasMic[posicaoNome][zero] == false) {
				return passarMic(pessoasMic, posicaoNome, posicaoNome2, quantPessoas, zero + 1, falso, voltar);
			} else {
				return passarMic(pessoasMic, posicaoNome+1, posicaoNome2, quantPessoas, 0, falso, voltar = zero);
			}
		} else if (zero > posicaoNome+1 && voltar == 0) {
			return passarMic(pessoasMic, zero, posicaoNome2, quantPessoas, 0, falso, voltar);
		} else if (zero == 0 && posicaoNome == posicaoNome2) {
			return pessoasMic[posicaoNome2 - 1][posicaoNome2];
		} else {
			return passarMic(pessoasMic, posicaoNome, posicaoNome2, quantPessoas, zero + 1, falso, voltar);
		}
	}
	static int posicaoNomeRecur(String nome, String[] pessoas, int quantPessoas, int zerou) {
		if (pessoas[zerou].equals(nome)) {
			return zerou;
		} else {
			return posicaoNomeRecur(nome, pessoas, quantPessoas, zerou + 1);
		}
	}
}