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

int *maiorPredio(int predio[], int predioMaior[], int predioMenor[], int tamanho) {
    predio[0] = predioMaior[0];
    for (int aux = 1, auxVermelho = 0, auxAzul = 1; aux < tamanho; aux++) {
            if (aux % 2 != 0) {
                bool achou = false;
                while (predioMenor[auxVermelho] != 0) {
                    if (predioMenor[auxVermelho] < predio[aux-1]) {
                        predio[aux] = predioMenor[auxVermelho];
                        auxVermelho++;
                        achou = true;
                        break;
                    } else {
                        auxVermelho++;
                    }
                }
                if (achou) {
                    continue;
                } else {
                    break;
                }
            } else {
                    bool achou = false;
                    while (predioMaior[auxAzul] != 0) {
                        if (predioMaior[auxAzul] < predio[aux-1]) {
                            predio[aux] = predioMaior[auxAzul];
                            auxAzul++;
                            achou = true;
                            break;
                        } else {
                            auxAzul++;
                        }
                    }
                    if (achou) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
    return predio;
}

int main () {
    int casos;
    cin >> casos;
    while (casos > 0) {
        int tamanho = 0,quantAzul = 0,quantVermelho = 0,variavel;
        cin >> tamanho;
        int predioAzul[tamanho] = {0};
        int predioVermelho[tamanho] = {0};
        int predioFinal[tamanho] = {0};
        for (int aux = 0; aux < tamanho; aux++) {
            cin >> variavel;
            if (variavel > 0) {
                predioAzul[quantAzul] = variavel;
                quantAzul++;
            } else {
                variavel = (variavel * (-1));
                predioVermelho[quantVermelho] = variavel;
                quantVermelho++;
            }
        }
        insertionSort(predioAzul, quantAzul);
        insertionSort(predioVermelho, quantVermelho);
        if (predioAzul[0] > predioVermelho[0]) {
            maiorPredio(predioFinal, predioAzul, predioVermelho, tamanho);
        } else {
            maiorPredio(predioFinal, predioVermelho, predioAzul, tamanho);
        }
        int contador = 0;
        int aux = 0;
        while (predioFinal[aux] != 0) {
            contador++;
            aux++;
        }
        cout << contador << endl;
        casos--;
    }
    return 0;
}