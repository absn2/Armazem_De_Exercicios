#include <iostream>

using namespace std;

int main (){
    bool parou = false;
    while (!parou) {
        int tamanho;
        string rua;
        cin >> tamanho;
        if (tamanho == 0) {
            parou = true;
        } else {
            cin >> rua;
            int contador = 1;
            int contadorAux = 0;
            bool achouR = false;
            bool achouD = false;
            for (int aux = 0; aux < tamanho; aux++) {
                if (rua[aux] == 'R') {
                    if (!achouD) {
                        achouR = true;
                        contador = 1;
                    } else if (achouD) {
                        if (contadorAux > contador && contadorAux != 0) {
                            contadorAux = contador;
                        } else if (contadorAux == 0) {
                            contadorAux = contador;
                        }
                        contador = 1;
                        achouR = true;
                        achouD = false;
                    }
                } else if (rua[aux] == 'D') {
                    if (!achouR) {
                        contador = 1;
                        achouD = true;
                    } else if (achouR) {
                        if (contadorAux > contador && contadorAux != 0) {
                            contadorAux = contador;
                        } else if (contadorAux == 0) {
                            contadorAux = contador;
                        }
                        contador = 1;
                        achouR = false;
                        achouD = true;
                    }
                } else if (rua[aux] == 'Z') {
                    contadorAux = 0;
                    break;
                } else if (achouR || achouD) {
                    contador++;
                }
            }
            cout << contadorAux << endl;
        }
    }
    return 0;
}