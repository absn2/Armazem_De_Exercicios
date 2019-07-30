#include <iostream>
using namespace std;

int main() {
    string p1,p2;
    cin >> p1;
    cin >> p2;
    int contador = 0;
    if (p1 == p2) {
        cout << 0;
    } else {
        for (int aux = 0; p1 != p2; aux++) {
            if (p1[p1.length()-1-aux] == p2[p2.length()-1-aux]) {
                contador++;
            } else {
                break;
            }
		}
		cout << p1.length() - contador + p2.length() - contador;
    }
    return 0;
}