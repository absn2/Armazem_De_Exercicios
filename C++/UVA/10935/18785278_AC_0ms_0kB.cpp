#include <iostream>
#include <sstream>
using namespace std;

struct No {
    int numero;
    No *nextNo;

    No(int numero) {
        this->numero = numero;
        this->nextNo = NULL;
    }

    int getValor() {
        return this->numero;
    }
};

struct Fila {
    int tamanho;
    No *inicioFila;
    No *finalFila;

    Fila() {
        this->tamanho=0;
        this->inicioFila = NULL;
        this->finalFila = NULL;
    }

    void enqueue (No *carta) {
        if (this->tamanho == 0) {
            this->inicioFila = carta;
            this->finalFila = carta;
        } else {
            this->finalFila->nextNo = carta;
            this->finalFila = this->finalFila->nextNo;
        }
        this->tamanho++;
    }

    int dequeue() {
        if (this->tamanho != 0) {
            int aux = this->inicioFila->getValor();
            this->inicioFila = this->inicioFila->nextNo;
            this->tamanho--;
            return aux;
        }
    }

    int getFrontValue() {
        return this->inicioFila->getValor();
    }

    int getTamanho() {
        return this->tamanho;
    }

    void inverter() {
        No *aux = this->inicioFila;
        this->inicioFila = this->inicioFila->nextNo;
        this->finalFila->nextNo = aux;
        this->finalFila = this->finalFila->nextNo;
        this->finalFila->nextNo = NULL;
    }
};

int main() {
    bool parou = false;
    while (!parou) {
        Fila *fila = new Fila();
        int numero;
        string discardado = "Discarded cards:";
        string remaning = "Remaining card:";
        cin >> numero;
        if (numero == 0) {
            break;
        } else {
            for (int aux = 0; aux < numero; aux++) {
                No *carta = new No(aux + 1);
                fila->enqueue(carta);
            }
            while (fila->getTamanho() >= 2) {
                int aux = fila->dequeue();
                if (fila->getTamanho() == 1) {
                    string auxString;
                    ostringstream convert;
                    convert << aux;
                    auxString = convert.str();
                    discardado += " " + auxString;
                } else {
                    string auxString;
                    ostringstream convert;
                    convert << aux;
                    auxString = convert.str();
                    discardado += " " + auxString + ",";
                    fila->inverter();
                }
            }
            int aux = fila->getFrontValue();
            string auxString;
            ostringstream convert;
            convert << aux;
            auxString = convert.str();
            remaning += " "+auxString;
            cout << discardado << "\n";
            cout << remaning << "\n";
        }
    }
    return 0;
}
