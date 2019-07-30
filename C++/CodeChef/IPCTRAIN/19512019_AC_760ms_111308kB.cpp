/*
Antonio B. S. Netto
absn2
*/
#include <iostream>
using namespace std;

struct Node {
    long d;
    long l;
    long s;
    Node *nextNode;

    Node(long d, long l , long s) {
        this->d = d;
        this->l = l;
        this->s = s;
        this->nextNode = NULL;
    }
};

struct LinkedList {
    Node *head;
    Node *tail;
    long length;

    LinkedList() {
        this->head = this->tail = NULL;
        this->length = 0;
    }

    void insert(Node *trainer) {
        if (this->length == 0) {
            this->head = this->tail = trainer;
        } else {
            this->tail->nextNode = trainer;
            this->tail = this->tail->nextNode;
        }
        this->length++;
    }
};

struct Heap {
    Node **heapTable;
    long length;

    Heap (long qT) {
        this->heapTable = new Node*[qT+1];
        this->length = 0;
    }

    void add (Node* valor) {
        this->heapTable[this->length+1] = valor;
        this->length++;
    }

    void bottomUp() {
        if (this->length > 1) {
            long k = this->length;
            long v = this->heapTable[k]->s;
            Node* c = this->heapTable[k];
            bool heapConfirm = false;
            while (!heapConfirm && k > 1) {
                int j = k / 2;
                if (v <= this->heapTable[j]->s) {
                    heapConfirm = true;
                } else {
                    this->heapTable[k] = this->heapTable[j];
                    this->heapTable[j] = c;
                    k = j;
                }
            }
        }
    }

    int extract() {
        Node* clear = new Node (0,0,0);
        long aux = this->heapTable[1]->s;
        this-> heapTable[1] = this->heapTable[length];
        this->heapTable[length] = clear;
        this->length--;
        return aux;
    }

    void upDown() {
        long k = 1;
        long v = this->heapTable[k]->s;
        Node* c = this->heapTable[k];
        bool heapConfirm = false;
        while (!heapConfirm && 2*k <= this->length) {
            int j = 2 * k;
            if (j < this->length) {
                if (this->heapTable[j]->s < this->heapTable[j+1]->s) {
                    j = j + 1;
                }
            } if (v >= this->heapTable[j]->s) {
                heapConfirm = true;
            } else {
                this->heapTable[k] = this->heapTable[j];
                k = j;
            }
        }
        this->heapTable[k] = c;
    }

    void printArray() {
        for (long i = 1; i <= this->length; i++) {
            cout << this->heapTable[i]->s << " ";
        }
        cout << "\n";
    }
};

int main () {
    long cases;
    cin >> cases;
    for (int i=0;i<cases;i++) {
        long qT,n;
        cin >> qT;
        cin >> n; // days
        LinkedList **list = new LinkedList*[n];
        Heap *heap = new Heap(qT);
        long sum = 0;
        for (long k = 0; k < n; k++) {
            list[k] = new LinkedList();
        }
        for (long j=0;j<qT;j++) {
            long d,l,s;
            cin >> d;
            cin >> l;
            cin >> s;
            sum += s*l;
            Node *trainer = new Node(d, l, s);
            list[d-1]->insert(trainer);
        }
        for (long j = 0; j < n; j++){
            if (list[j]->length != 0) {
                while (list[j]->head != nullptr) {
                    heap->add(list[j]->head);
                    heap->bottomUp();
                    list[j]->head = list[j]->head->nextNode;
                }
            }
            if (heap->length >= 1) {
                if (heap->heapTable[1]->l == 1) {
                    sum -= heap->extract();
                    heap->upDown();
                } else {
                    sum -= heap->heapTable[1]->s;
                    heap->heapTable[1]->l--;
                }
            }
        }
        delete[] heap;
        delete[] list;
        cout << sum << endl;
    }
    return 0;
}