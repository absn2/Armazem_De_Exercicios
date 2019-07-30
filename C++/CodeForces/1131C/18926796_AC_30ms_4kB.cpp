#include <iostream>
using namespace std;

int* insertionSort (int sizes[], int length) {
    for (int aux = 1; aux < length; aux++) {
        int now = sizes[aux];
        int before = aux-1;
        while (before >= 0 && sizes[before] > now) {
            sizes[before+1] = sizes[before];
            before = before - 1;
        }
        sizes[before+1] = now;
    }
    return sizes;
}

int* insertionBigger(int sizes[], int length, int resultado[]) {
    int pivo = length / 2;
    resultado[pivo] = sizes[length-1];
    int i = pivo+1;
    int j = pivo-1;
    for (int aux = 1; aux < length; aux++) {
        if (aux % 2 != 0) {
            if (i == length) {
                resultado[j] = sizes[length-1-aux];
                j--;
            } else {
                resultado[i] = sizes[length-1-aux];
                i++;
            }
        } else {
            if (j < 0) {
                resultado[i] = sizes[length-1-aux];
                i++;
            } else {
                resultado[j] = sizes[length-1-aux];
                j--;
            }
        }
    }
    return resultado;
}



int main() {
    int tam;
    cin >> tam;
    int sizes[tam];
    for (int aux = 0; aux < tam; aux++) {
        cin >> sizes[aux];
    }
    insertionSort(sizes, tam);
    int resultado[tam];
    insertionBigger(sizes, tam, resultado);
    for (int aux = 0; aux < tam; aux++) {
        if (aux == tam - 1) {
            cout << resultado[aux];
        } else {
            cout << resultado[aux] << " ";
        }
    }
    return 0;
}