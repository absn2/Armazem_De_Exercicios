#include <iostream>
using namespace std;

struct HashTable {
    string *table;
    int length;

    HashTable() {
        this->table = new string[101];
        this->length = 0;
    }
    int setKey (string element) {
        int result = 0;
        for (int i = 0; i < element.length(); i++) {
            result += element[i]*(i+1);
        }
        result = result * 19;
        return result;
    }

    int key (int preKey, int aux) {
        int result = preKey % aux;
        return result;

    }
    void insertion (int key, string element) {
        bool stop = false;
        int j = 1;
        int aux = key;
        if (element == "") {
            stop = true;
        }
        while (!stop) {
            if (this->table[aux] == "" || this->table[aux] == "-1") {
                this->table[aux] = element;
                this->length++;
                stop = true;
            } else if (j == 20) {
                stop = true;
            } else {
                aux = (key+(j*j)+(23*j)) % 101;
                j++;
            }
        }
    }

    void del (int key, string element) {
        int aux = key;
        bool stop = false;
        int j = 1;
        if (element == "") {
            stop = true;
        }
        while (!stop) {
            if (this->table[aux] == element) {
                this->table[aux] = "-1";
                this->length--;
                stop = true;
            } else if (j == 20) {
                stop = true;
            } else {
                aux = (key+(j*j)+(23*j)) % 101;
                j++;
            }
        }
    }

    bool find (int key, string element) {
        bool stop = false;
        int j = 1;
        int aux = key;
        while (!stop) {
            if (this->table[aux] == element) {
                return true;
            } else if (j == 20) {
                return false;
            } else {
                aux = (key+(j*j)+(23*j)) % 101;
                j++;
            }
        }
        return false;
    }

    void output() {
        for (int aux = 0; aux < 101; aux++) {
            if (this->table[aux] != "" && this->table[aux] != "-1") {
                cout << aux << ":" << this->table[aux] << endl;
            }
        }

    }

    void lengthOut () {
        cout << this->length << endl;
    }
};

int main () {
    int cases;
    cin >> cases;
    while (cases > 0) {
        int lines;
        cin >> lines;
        HashTable *hashTable = new HashTable();
        for (int i = 0; i < lines; i++) {
            string auxString;
            cin >> auxString;
            string operation = auxString.substr(0,3);
            string element = auxString.substr(4);
            if (operation == "ADD") {
                int preKey = hashTable->setKey(element);
                int key = hashTable->key(preKey, 101);
                if (!hashTable->find(key, element)) {
                    hashTable->insertion(key, element);
                }
            } else {
                int preKey = hashTable->setKey(element);
                int key = hashTable->key(preKey, 101);
                if (hashTable->find(key, element)) {
                    hashTable->del(key, element);
                }
            }
        }
        hashTable->lengthOut();
        hashTable->output();
        delete hashTable;
        cases--;
    }
    return 0;
}