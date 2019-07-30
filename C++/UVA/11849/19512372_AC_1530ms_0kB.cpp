#include <iostream>
using namespace std;

struct Node {
    int key;
    int height;
    Node *leftNode;
    Node *rigthNode;

    Node (int key) {
        this->key = key;
        this->height = 0;
        this->leftNode = NULL;
        this->rigthNode = NULL;
    }

    int getKey() {
        return this->key;
    }
};

struct AVL {

    Node *root;
    int length;
    AVL() {
        this->root = NULL;
        this->length = 0;
    }

    void insert (Node *node, int key) {
        this->root = insertHelp(this->root, key, node);
        this->length++;
    }

    Node* insertHelp (Node *root, int key, Node *node) {
        if (root == NULL) {
            return node;
        } else if (root->getKey() > key) {
            root->leftNode = insertHelp(root->leftNode, key, node);
        } else {
            root->rigthNode = insertHelp(root->rigthNode, key, node);
        }
        root->height = 1 + max(height(root->leftNode), height(root->rigthNode));
        int balance = getBalance(root);
        if (balance > 1 && key < root->leftNode->getKey()) {
            return rightRotate(root);
        } if (balance < -1 && key >= root->rigthNode->getKey()) {
            return leftRotate(root);
        } if (balance > 1 && key >= root->leftNode->getKey()) {
            root->leftNode = leftRotate(root->leftNode);
            return rightRotate(root);
        } if (balance < -1 && key < root->rigthNode->getKey()) {
            root->rigthNode = rightRotate(root->rigthNode);
            return leftRotate(root);
        }
        return root;
    }

    int height (Node *root) {
        if (root == NULL) {
            return -1;
        }
        return root->height;
    }

    int getBalance(Node *root) {
        if (root == NULL) {
            return 0;
        }
        return height(root->leftNode) - height(root->rigthNode);
    }
    int max (int height, int height2) {
        if (height > height2) {
            return height;
        } else {
            return height2;
        }
    }

    Node* rightRotate (Node* root) {
        Node *j = root->leftNode;
        Node *k = root->rigthNode;
        j->rigthNode = root;
        root->leftNode = k;
        root->height = max(height(root->leftNode), height(root->rigthNode)) + 1 ;
        j->height = max(height(j->leftNode), height(j->rigthNode)) + 1;
        return j;
    }

    Node* leftRotate (Node* root) {
        Node *r = root->rigthNode;
        Node *rl = r->leftNode;
        r->leftNode = root;
        root->rigthNode = rl;
        root->height = max(height(root->leftNode), height(root->rigthNode)) + 1 ;
        r->height = max(height(r->leftNode), height(r->rigthNode)) + 1;
        return r;
    }

    int search (int key){
        return searchHelp(this->root, key);
    }

    int searchHelp (Node* rt, int key) {
        if (rt == NULL) {
            return 0;
        } else if (rt->getKey() == key) {
            return 1;
        } else if (rt->getKey() > key) {
            return searchHelp(rt->leftNode, key);
        } else {
            return searchHelp(rt->rigthNode, key);
        }
    }
};

int main () {
    bool stop = false;
    while (!stop) {
        int n,m;
        cin >> n;
        cin >> m;
        if (n == 0 && m == 0) {
            stop = true;
        } else {
            AVL *avl = new AVL();
            int result = 0;
            int *compare = new int[n];
            int auxNumber = n;
            int auxNumber2 = m;
            while (auxNumber > 0) {
                int catalog;
                cin >> catalog;
                Node *aux = new Node(catalog);
                avl->insert(aux, catalog);
                auxNumber--;
            }while (auxNumber2 > 0) {
                int catalog;
                cin >> catalog;
                result += avl->search(catalog);
                auxNumber2--;
            }
            cout << result << endl;
        }
    }
    return 0;
}