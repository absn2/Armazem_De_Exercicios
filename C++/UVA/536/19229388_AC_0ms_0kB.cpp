#include <iostream>
using namespace std;

struct Node {
    int key;
    char letter;
    Node *leftNode;
    Node *rightNode;

    Node (int key, char letter) {
        this->key = key;
        this->letter = letter;
        this->leftNode = NULL;
        this->rightNode = NULL;
    }

    int getKey() {
        return this->key;
    }

    char getLetter() {
        return this->letter;
    }
};

struct BST {
    Node *root;
    int length;

    BST () {
        this->root = NULL;
        this->length = 0;
    }

    void insertion(Node *node, int key) {
        this->root = insertionHelp(this->root, key, node);
        this->length++;
    }

    Node* insertionHelp (Node *root, int key, Node *node) {
        if (root == NULL) {
            return node;
        } else if (root->getKey() > key) {
            root->leftNode = insertionHelp(root->leftNode, key, node);
        } else {
            root->rightNode = insertionHelp(root->rightNode, key, node);
        }
        return root;
    }

    void printPostOrder() {
        printPostOrderHelp(this->root);
    }

    void printPostOrderHelp(Node *root) {
        if (root != nullptr) {
            printPostOrderHelp(root->leftNode);
            printPostOrderHelp(root->rightNode);
            cout << root->getLetter();
        }
     }
};

int main()
{
    string line;
    while (getline(cin, line)) {
        BST *bst = new BST();
        string preord = "";
        string inord = "";
        bool blank = false;
        for (int i = 0; i < line.length(); i++) {
            if (blank) {
                inord += line[i];
            }else if (line[i] == ' ') {
                blank = true;
            } else if (!blank) {
                preord += line[i];
            }
        }
        for (int i = 0; i < preord.length(); i++) {
            int key = 0;
            for (int j = 0; j < inord.length(); j++) {
                if (inord[j] == preord[i]) {
                    key = j;
                    break;
                }
            }
            Node *node = new Node(key, preord[i]);
            bst->insertion(node, key);
        }
        bst->printPostOrder();
        delete bst;
        cout << "\n";
    }
}
