#include <iostream>
using namespace std;

int main() {
    int numero,resultadoF1, resultadoF2;
    cin >> numero;
    if (numero == 1) {
        cout << "-1" << endl;
    } else {
        if (numero %2 == 0) {
            resultadoF1 = numero;
            resultadoF2 = numero;
        } else {
            resultadoF1 = numero - 1;
            for (int aux = resultadoF1; aux > 0; aux--) {
                if (resultadoF1 % aux == 0) {
                    resultadoF2 = aux;
                    break;
                }
            }
        }
        cout << resultadoF1 << " " << resultadoF2 << endl;
    }
    return 0;
}