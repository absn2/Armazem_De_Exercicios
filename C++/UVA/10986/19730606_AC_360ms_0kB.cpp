/*
Antonio B. S. Netto
absn2
*/
#include <iostream>
#include<bits/stdc++.h>
using namespace std;

struct Node {
    int number;
    int cost;
    Node* nextNode;

    Node(int number, int cost) {
        this->number = number;
        this->cost = cost;
        this->nextNode = NULL;
    }
};

struct Heap {
    int *heapTable;
    int *auxNode;
    int length;

    Heap () {
        int range = 1000000;
        this->heapTable = new int[range];
        for (int i = 0; i < range; i++) {
            this->heapTable[i] = 0;
        }
        this->auxNode = new int[range];
        for (int i = 0; i < range; i++) {
            this->auxNode[i] = 0;
        }
        this->length = 0;
    }

    void insert (int node, int cost) {
        this->heapTable[this->length+1] = cost;
        this->auxNode[this->length+1] = node;
        this->length++;
    }

    void bottomUp() {
        int k = this->length;
        int v = this->heapTable[k];
        int b = this->auxNode[k];
        bool heapConfirm = false;
        while (!heapConfirm && k > 1) {
            int j = k / 2;
            if (v >= this->heapTable[j]) {
                heapConfirm = true;
            } else {
                this->heapTable[k] = this->heapTable[j];
                this->auxNode[k] = this->auxNode[j];
                this->heapTable[j] = v;
                this->auxNode[j] = b;
                k = j;
            }
        }
    }
    void upDown() {
        int k = 1;
        int v = this->heapTable[k];
        int b = this->auxNode[k];
        bool heapConfirm = false;
        while (!heapConfirm && 2*k <= this->length) {
            int j = 2 * k;
            if (j < this->length) {
                if (this->heapTable[j] > this->heapTable[j+1]) {
                    j = j + 1;
                }
            } if (v <= this->heapTable[j]) {
                heapConfirm = true;
            } else {
                this->heapTable[k] = this->heapTable[j];
                this->auxNode[k] = this->auxNode[j];
                k = j;
            }
        }
        this->heapTable[k] = v;
        this->auxNode[k] = b;
    }

    int extract () {
        int aux = this->auxNode[1];
        this-> heapTable[1] = this->heapTable[this->length];
        this->auxNode[1] = this->auxNode[this->length];
        this->heapTable[this->length] = 0;
        this->auxNode[this->length] = 0;
        this->length--;
        return aux;
    }

   /* void printArray() {
        cout << "---> HEAP: ";
        for (int i = 0; i < this->length; i++) {
            cout << this->auxNode[i] << " ";
        }
        cout << endl;
    }*/
};

struct LinkedList {
    Node *head;
    Node *tail;
    bool visited;
    int length;

    LinkedList() {
        this->head = this->tail = NULL;
        this->visited = false;
        this->length = 0;
    }

    void insert(Node *server) {
        if (this->length == 0) {
            this->head = server;
            this->tail = server;
        } else {
            this->tail->nextNode = server;
            this->tail = this->tail->nextNode;
        }
        this->length++;
    }

    int first() {
        if (this->length == 0) {
            return -1;
        } else {
            return this->head->number;
        }
    }

    int next() {
        if (this->length == 1) {
            return -1;
        } else {
            this->head = this->head->nextNode;
            this->length--;
            return this->head->number;
        }
    }
};

struct Graph {
    LinkedList **list;
    int length;

    Graph(int n) {
        this->list = new LinkedList*[n];
        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList();
        }
        this->length = n;
    }

    void insert(Node *server, int index) {
        this->list[index]->insert(server);
    }

    int dijkstra(int serverS, int serverT, int distance[]) {
        Heap* heap = new Heap();
        heap->insert(serverS, 0);
        for (int i = 0; i < this->length; i++) {
            distance[i] = INT_MAX;
        }
        distance[serverS] = 0;
        for (int i = 0; i < this->length && heap->length != 0 ; i++) {
            int v = heap->extract();
            heap->upDown();
            while (this->list[v]->visited) {
                if (heap->length == 0) {
                    break;
                } else {
                    v = heap->extract();
                    heap->upDown();
                }
            }
            this->list[v]->visited = true;
            if (distance[v] == INT_MAX) {
                return INT_MAX;
            }
            int w = this->list[v]->first();
            while (w > -1) {
                if (!this->list[w]->visited && distance[w] > distance[v]+ this->list[v]->head->cost) {
                    distance[w] = distance[v] + this->list[v]->head->cost;
                    heap->insert(w, distance[w]);
                    heap->bottomUp();
                }
                w = this->list[v]->next();
            }
        }
        delete heap;
        return distance[serverT];
    }


};

int main () {
    int cases;
    cin >> cases;
    for (int i = 0; i < cases; i++) {
        int range,lines,serverS,serverT;
        cin >> range >> lines >> serverS >> serverT;
        Graph* graph = new Graph(range);
        for (int j = 0; j < lines; j++) {
            int index,serverAux,cost;
            cin >> index >> serverAux >> cost;
            Node *aux = new Node(serverAux, cost);
            graph->insert(aux, index);
            aux = new Node(index, cost);
            graph->insert(aux, serverAux);
        }
        int *distance = new int[range];
        int result = graph->dijkstra(serverS, serverT, distance);
        cout << "Case #" << i+1 << ": ";
        if (result == INT_MAX) {
            cout << "unreachable" << "\n";
        } else {
            cout << result << "\n";
        }
        delete[] distance;
        delete graph;
    }
    return 0;
}