/*
Antonio B. S. Netto
absn2
*/
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int getLongestSC (string word1, string word2, int** matrix, int columnLength, int rowLength) {
    for (int i = 1; i < rowLength; i ++) {
        for (int j = 1; j < columnLength; j++) {
            if (word1[j-1] == word2[i-1]) {
                matrix[i][j] = matrix[i-1][j-1]+1;
            } else {
                matrix[i][j] = max(matrix[i-1][j],matrix[i][j-1]);
            }
        }
    }
   return matrix[rowLength-1][columnLength-1];
}

int** initialize(int**matrix,int y, int x) {
    matrix = new int*[x];
    for (int i = 0; i < x; i++) {
        matrix[i] = new int[y];
        for (int j = 0; j < y; j++) {
            matrix[i][j] = 0;
        }
    }
    return matrix;
}

int main() {
    string word1;
    while (getline(cin,word1)) {
        string word2;
        getline(cin,word2);
        int columnLength = word1.length()+1;
        int rowLength = word2.length()+1;
        int ** matrix;
        matrix = initialize(matrix,columnLength,rowLength);
        int result = getLongestSC(word1,word2,matrix,columnLength,rowLength);
        cout << result << endl;
    }
    return 0;
}