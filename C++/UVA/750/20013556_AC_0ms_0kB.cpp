/*
Antonio B. S. Netto
absn2
*/
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int **matriz;
    int sum;

    Node (int **matriz) {
        this->sum = 0;
        this->matriz = new int*[8];
        for (int i = 0; i < 8; i ++) {
            this->matriz[i] = new int [8];
            for (int j = 0; j < 8; j++) {
                this->matriz[i][j] = matriz[i][j];
            }
        }
    }

    void print () {
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (matriz[i][j] > 0) {
                    int aux = i + 1;
                    if (j == 7) {
                        cout << aux;
                    } else {
                        cout << aux << " ";
                    }
                }
            }
        }
    }

     void sumAll () {
        int sum = 0;
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (matriz[i][j] > 0) {
                    int aux = i + 1;
                    sum += aux * (pow(10,7-j));
                }
            }
        }
        this->sum = sum;
    }

};

struct Table {
    int ** matriz;
    Node **solution;
    int cursor;

    Table () {
        this->matriz = new int*[8];
        for (int i = 0; i < 8; i ++) {
            matriz[i] = new int [8];
            for (int j = 0; j < 8; j++) {
                matriz[i][j] = 0;
            }
        }
        this->solution = new Node*[1000];
        this->cursor = 0;
    }

    void setQueen(int row, int column, int index) {
        matriz[row][column] = index;
    }

    void setSolution(int **matriz) {
        this->solution[this->cursor] = new Node (matriz);
        this->cursor++;
    }

    void initializeBackTracking(int row, int columns) {
        if (row == 7) {
            backTracking(0,0,2);
        } else {
            backTracking(row+1,0,2);
        }

    }

    void desmarck(int row, int index) {
        int aux = 0;
        for (int j = 0; j < 8; j++) {
            if (matriz[row][j] == index) {
                matriz[row][j] = 0;
                aux = j;
                break;
            }
        }
        if (aux+1 <= 8) {
            bool stop = false;
            while(!stop) {
                if (aux+1 == 8) {
                    stop = true;
                    if (index != 2) {
                        if (row-1 < 0) {
                            desmarck(7,index-1);
                        } else {
                            desmarck(row-1,index-1);
                        }
                    }
                } else if (check(row,aux+1)) {
                    stop = true;
                    matriz[row][aux+1] = index;
                    if (row+1==8) {
                        backTracking(0,0,index+1);
                    } else {
                        backTracking(row + 1, 0, index + 1);
                    }
                }
                aux++;
            }
        } else {
            if (index > 2) {
                desmarck(row-1,index-1);
            }
        }
    }
    void print () {
        cout << "OLHA AQUI MATRIZ" << endl;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cout << matriz[i][j] << " ";
            }
            cout << endl;
            cout << endl;
        }
    }

    void backTracking (int row, int columns, int index) {
        if (check(row,columns)) {
            setQueen(row,columns,index);
            if (row+1 == 8 && index < 8) {
                backTracking(0,0,index+1);
            } else if (index == 8) {
                setSolution(matriz);
                this->matriz[row][columns] = 0;
                if (columns+1 < 8) {
                    backTracking(row,columns+1,index);
                } else {
                    if (row-1 < 0) {
                        desmarck(7,index-1);
                    } else {
                        desmarck(row-1,index-1);
                    }
                }
            } else {
                backTracking(row+1,0,index+1);
            }
        } else {
            if (columns == 7 && index > 2) {
                if (row - 1 < 0) {
                    desmarck(7,index-1);
                }else {
                    desmarck(row-1,index-1);
                }
            } else {
                backTracking(row,columns+1,index);
            }
        }
    }

    bool check (int row, int column) {
        int auxPosX = row;
        int auxPosY = column;
        bool check = true;
        while (auxPosX - 1 >= 0 && check) {
            if (matriz[auxPosX-1][column] > 0) {
                check = false;
                break;
            }
            auxPosX--;
        }
        auxPosX = row;
        while (auxPosX + 1 <= 7 && check) {
            if (matriz[auxPosX+1][column] > 0) {
                check = false;
                break;
            }
            auxPosX++;
        }
        auxPosX = row;
        while(auxPosX+1 <= 7 && auxPosY+1<=7 && check) {
            if (matriz[auxPosX+1][auxPosY+1] > 0) {
                check = false;
                break;
            }
            auxPosX++;
            auxPosY++;
        }
        auxPosX = row;
        auxPosY = column;
        while(auxPosX-1 >= 0 && auxPosY+1<=7 && check) {
            if (matriz[auxPosX-1][auxPosY+1] > 0) {
                check = false;
                break;
            }
            auxPosX--;
            auxPosY++;
        }
        auxPosX = row;
        auxPosY = column;
        while(auxPosX-1 >= 0 && auxPosY-1>=0 && check) {
            if (matriz[auxPosX-1][auxPosY-1] > 0) {
                check = false;
                break;
            }
            auxPosX--;
            auxPosY--;
        }
        auxPosX = row;
        auxPosY = column;
        while(auxPosX+1 <= 7 && auxPosY-1>=0 && check) {
            if (matriz[auxPosX+1][auxPosY-1] > 0) {
                check = false;
                break;
            }
            auxPosX++;
            auxPosY--;
        }
        return check;
    }

    void printSolution(int i, int cases) {
        lexicograph();
        cout <<"SOLN       COLUMN" << endl;
        cout <<" #      1 2 3 4 5 6 7 8";
        cout << "\n";
        cout << "\n";
        for (int i = 1; i <= this->cursor; i++) {
            if (i <= 9) {
                cout << " " << i << "      ";
            } else {
                cout << i << "      ";
            }
            this->solution[i-1]->print();
            cout << endl;
        }
        if (i != cases) {
            cout << "\n";
        }
    }

    void lexicograph() {
        for (int i = 0; i < this->cursor; i++) {
            this->solution[i]->sumAll();
        }
        for (int i = 1; i < this->cursor; i++) {
            int v = this->solution[i]->sum;
            Node* x = this->solution[i];
            int j = i - 1;
            while (j >= 0 && this->solution[j]->sum > v) {
                this->solution[j+1] = this->solution[j];
                j = j - 1;
            }
            this->solution[j+1] = x;
        }
    }
};

int main() {
    int cases;
    cin >> cases;
    for (int i = 1; i <= cases; i++) {
        int row,column;
        Table* table = new Table();
        cin >> row >> column;
        row--;
        column--;
        table->setQueen(row,column,1);
        table->initializeBackTracking(row,column);
        table->printSolution(i,cases);
    }
    return 0;
}
