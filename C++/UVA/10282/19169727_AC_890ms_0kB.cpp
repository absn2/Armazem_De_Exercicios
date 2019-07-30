#include <iostream>
using namespace std;

struct Node {

    int key;
    string translated;
    string foreign;
    Node *leftNode;
    Node *rightNode;

    Node (int key, string translated, string foreign) {
        this->key = key;
        this->translated = translated;
        this->foreign = foreign;
        this->leftNode = NULL;
        this->rightNode = NULL;
    }

    string getTranslated() {
        return this->translated;
    }

    int getKey() {
        return this->key;
    }

    string getForeign() {
        return this->foreign;
    }

};

struct BST {

    Node *root;
    int nodecount;

    BST () {
        this->root = NULL;
        this->nodecount = 0;
    }

    string find (int key, string foreign) {
        return findHelp(this->root, key, foreign);
    }

    string findHelp(Node *root, int key, string foreign) {
        if (root == NULL) {
            return "eh";
        } else if (root->getKey() > key) {
            return findHelp(root->leftNode, key, foreign);
        } else if (root->getKey() == key) {
            if (root->getForeign() == foreign) {
                return root->getTranslated();
            } else {
                return findHelp(root->rightNode, key, foreign);
            }
        } else {
            return findHelp(root->rightNode, key, foreign);
        }
    }

    void insert(int key, Node *node) {
        this->root = insertHelp(this->root, key, node);
        this->nodecount++;
    }

    Node* insertHelp (Node *root, int key, Node *node) {
        if (root == NULL) {
            return node;
        } else if (root->getKey() > key) {
            root->leftNode = insertHelp(root->leftNode, key, node);
        } else {
            root->rightNode = insertHelp(root->rightNode, key, node);
        }
        return root;
    }
};

int getKey (string foreign) {
    int resultado = 0;
    for (int i = 0; i < foreign.length(); i++) {
        resultado += (foreign[i]*(i+1));
    }
    resultado = resultado * 19;
    resultado = resultado % 100000;
    return resultado;
}
int main () {
    bool stop = false;
    BST *bst = new BST();
    while (!stop) {
        bool blank = false;
        string line = "";
        string translated = "";
        string foreign = "";
        getline(cin, line);
        if (line == "") {
            stop = true;
        } else {
            for (int i = 0; i < line.length(); i++) {
                if (line[i]==' ') {
                    blank = true;
                } else if (!blank) {
                    translated = translated + line[i];
                } else if (blank) {
                    foreign = foreign + line[i];
                }
            }
            int key = getKey(foreign);
            Node *node = new Node(key, translated, foreign);
            bst->insert(key, node);
        }
    }
    string line;
    while (cin >> line) {
        int key = getKey(line);
        cout << bst->find(key, line) << "\n";
    }
    return 0;
}