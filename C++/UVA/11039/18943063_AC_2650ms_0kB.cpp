#include <iostream>
using namespace std;

int *insertionSort(int predio[], int tamanho) {
    for (int i = 1; i < tamanho; i++) {
        int v = predio[i];
        int j = i - 1;
        while (j >= 0 && predio[j] < v) {
            predio[j+1] = predio[j];
            j = j - 1;
        }
        predio[j+1] = v;
    }
    return predio;
}
int *insertionSortNegativo(int predio[], int tamanho) {
    for (int i = 1; i < tamanho; i++) {
        int v = predio[i];
        int j = i - 1;
        while (j >= 0 && predio[j] > v) {
            predio[j+1] = predio[j];
            j = j - 1;
        }
        predio[j+1] = v;
    }
    return predio;
}

int *realocarNegativos (int predio[], int predioVermelho[], int tamanho) {
    for (int aux = 0, quantVermelho = 0; aux < tamanho; aux++) {
        int auxAux = predio[aux] * -1;
        if (auxAux == predioVermelho[quantVermelho]) {
            predio[aux] = predioVermelho[quantVermelho];
            quantVermelho++;
        } else {
            continue;
        }
    }
    return predio;
}



int main () {
    int casos;
    cin >> casos;
    while (casos > 0) {
        int tamanho = 0,variavel = 0,quantVermelho = 0;
        cin >> tamanho;
        int predio[tamanho] = {0};
        int predioVermelho[tamanho] = {0};
        for (int aux = 0; aux < tamanho; aux++) {
             cin >> variavel;
             if (variavel > 0) {
                predio[aux] = variavel;
             } else {
                predio[aux] = variavel*-1;
                predioVermelho[quantVermelho] = variavel;
                quantVermelho++;
             }
        }
        insertionSort(predio, tamanho);
        insertionSortNegativo(predioVermelho, tamanho);
        realocarNegativos(predio, predioVermelho, tamanho);
        int primeiro = predio[0];
        int contador = 1;
        if (primeiro > 0) {
            bool achou = false;
            for (int aux = 1; aux < tamanho; aux ++) {
                if (predio[aux] < 0 && !achou) {
                    contador++;
                    achou = true;
                } else if (predio[aux] > 0 && achou) {
                    contador++;
                    achou = false;
                }
            }
        } else {
            bool achou = false;
            for (int aux = 1; aux < tamanho; aux ++) {
                if (predio[aux] > 0 && !achou) {
                    contador++;
                    achou = true;
                } else if (predio[aux] < 0 && achou) {
                    contador++;
                    achou = false;
                }
            }
        }
        cout << contador << endl;
        casos--;
    }
    return 0;
}