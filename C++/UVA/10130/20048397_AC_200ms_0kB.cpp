/*
Antonio B. S. Netto
absn2
*/
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int ** initialize(int**matrix, int y, int x) {
    matrix = new int*[y];
    for (int i = 0; i < y; i++) {
        matrix[i] = new int[x];
        for (int j = 0; j < x; j++) {
            matrix[i][j] = 0;
        }
    }
    return matrix;
}

/*void print (int**matrix,int y, int x) {
    for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;

}*/

int knapsack(int**matrix, int quantObject, int maximumWeight,int*priceVector,int*weightVector) {
    for (int i = 1; i < quantObject; i++) {
        for (int j = 1; j < maximumWeight; j++) {
            if (weightVector[i-1] <= j) {
              matrix[i][j] = max( matrix[i-1][j], priceVector[i-1] + matrix[i-1][j-weightVector[i-1]]);
            } else {
                matrix[i][j] = matrix[i-1][j];
            }
        }
    }
    //print(matrix,quantObject,maximumWeight);
    return matrix[quantObject-1][maximumWeight-1];
}


int main()
{
    int cases;
    cin >> cases;
    for (int i = 0; i < cases; i++) {
        int quantObject,quantPeople,result = 0;
        cin >> quantObject;
        int *weightVector = new int[quantObject];
        int *priceVector = new int[quantObject];
        for (int j =  0; j < quantObject; j++) {
            int price,weight;
            cin >> price >> weight;
            priceVector[j] = price;
            weightVector[j] = weight;
        }
        cin >> quantPeople;
        for (int j = 0; j < quantPeople; j++) {
            int maximumWeight;
            cin >> maximumWeight;
            int **matrix;
            matrix = initialize(matrix,quantObject+1,maximumWeight+1);
            result += knapsack(matrix,quantObject+1,maximumWeight+1,priceVector,weightVector);
        }
        cout << result << endl;
    }
    return 0;
}
