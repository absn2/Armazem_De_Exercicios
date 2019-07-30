/*
Antonio B. S. Netto
absn2
*/
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

struct Radio {
    bool *visited;
    int *arrayNumber;
    bool check;
    int compare;
    int size;
    int sum;
    int sumToGet;

    Radio(int size, int sumToGet, int arrayNumber[]) {
        this->visited = new bool[size];
        this->arrayNumber = new int[size];
        for (int i = 0; i < size; i++) {
            this->visited[i] = 0;
            this->arrayNumber[i] = arrayNumber[i];
        }
        this->check = false;
        this->size = size;
        this->sumToGet = sumToGet;
        this->sum = 0;
        this->compare = 0;
    }

    void printVisted(bool visited[]) {
        cout << "ARRAY DE BOOLEANOS:" << endl;
        for (int i = 0; i < this->size;i++) {
            cout << visited[i] << " ";
        }
        cout << endl;
        cout << endl;
    }

    int getSizeArray(bool visited[]) {
        int aux = 0;
        for (int i = 0; i < this->size; i++) {
            if (visited[i] == true) {
                aux++;
            }
        }
        return aux;
    }


    void backTracking (int index, int sumTemp, bool visited[]) {
        if (this->arrayNumber[index]+sumTemp <= this->sumToGet) {
            sumTemp += this->arrayNumber[index];
            visited[index] = 1;
            if (sumTemp == this->sumToGet) {
                int aux = getSizeArray(visited);
                if (sumTemp > this->sum || aux > this->compare) {
                    this->sum = sumTemp;
                    this->compare = aux;
                    setVisited(visited);
                    this->check = true;
                }
                visited[index] = 0;
                return;
            } else {
                if (sumTemp >= this->sum && !this->check) {
                    int aux = getSizeArray(visited);
                    if (sumTemp > this->sum) {
                        this->sum = sumTemp;
                        this->compare = aux;
                        setVisited(visited);
                    } else if (sumTemp == this->sum) {
                        if (aux > this->compare) {
                            this->sum = sumTemp;
                            this->compare = aux;
                            setVisited(visited);
                        }
                    }
                }
                if (index+1 == this->size) {
                    visited[index] = 0;
                    return;
                }
                backTracking(index+1,sumTemp,visited);
                visited[index] = 0;
                sumTemp -= this->arrayNumber[index];
                backTracking(index+1,sumTemp,visited);
            }
        } else {
            if (index+1==this->size) {
                return;
            } else {
                backTracking(index+1,sumTemp,visited);
            }
        }
    }

    void setVisited (bool visited []) {
        for (int i = 0; i < this->size; i++) {
            this->visited[i] = visited[i];
        }
    }

    void print() {
        for (int i = 0; i < this->size; i ++) {
            if (this->visited[i] == 1) {
                cout << this->arrayNumber[i] << " ";
            }
        }
        cout << "sum:" << this->sum;
        cout << endl;
    }

};

int main() {
    int sumToGet;
    while (cin >> sumToGet) {
        int numberLength;
        cin >> numberLength;
        int arrayNumber[numberLength];
        bool visitedTemp[numberLength];
        for (int i = 0; i < numberLength; i++) {
            visitedTemp[i] = 0;
        }
        for (int i = 0; i < numberLength; i ++) {
            int number;
            cin >> number;
            arrayNumber[i] = number;
        }
        Radio* radio = new Radio(numberLength,sumToGet,arrayNumber);
        radio->backTracking(0,0,visitedTemp);
        radio->print();
        delete radio;

    }
    return 0;
}