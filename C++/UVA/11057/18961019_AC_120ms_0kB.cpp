#include <iostream>
using namespace std;

int *insertionSort(int livros[], int tamanho) {
    for (int i = 1; i < tamanho; i++) {
        int v = livros[i];
        int j = i - 1;
        while (j >= 0 && livros[j] > v) {
            livros[j+1] = livros[j];
            j = j - 1;
        }
        livros[j+1] = v;
    }
    return livros;
}

int buscaBinaria(int livros[], int tamanho, int procurado, int indice) {
    int i = 0;
    int r = tamanho - 1;
    while (i <= r) {
        int m = (i+r) / 2;
        if (livros[m] == procurado && m != indice) {
            return procurado;
        } else if (livros[m] > procurado) {
            r = m - 1;
        } else {
            i = m + 1;
        }
    }
    return -1;
}

int main () {
    int tamanho;
    while (cin >> tamanho) {
        bool primeiro = false;
        int livros[tamanho];
        int salario = 0,procurado = 0,diferenca = 0,diferencaFinal = 0,atual = 0,resultado1 = 0,resultado2 = 0;
        for (int i = 0; i < tamanho; i++) {
            cin >> livros[i];
        }
        cin >> salario;
        insertionSort(livros, tamanho);
        for (int i = 0; i < tamanho; i++) {
            procurado = salario - livros[i];
            atual = livros[i];
            if (procurado <= 0) {
                continue;
            } else {
                int achado = buscaBinaria(livros, tamanho, procurado, i);
                if (achado != -1) {
                    diferenca = achado - atual;
                    if (diferenca < 0) {
                        continue;
                    } else {
                        if (!primeiro) {
                            primeiro = true;
                            diferencaFinal = diferenca;
                            resultado1 = atual;
                            resultado2 = achado;
                        } else if (diferenca < diferencaFinal && primeiro) {
                            diferencaFinal = diferenca;
                            resultado1 = atual;
                            resultado2 = achado;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        cout << "Peter should buy books whose prices are " << resultado1 << " and " << resultado2 << "." << endl;
        cout << "\n";
    }
    return 0;
}