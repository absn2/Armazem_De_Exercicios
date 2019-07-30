/*
Antonio B. S. Netto
absn2
*/
#include <iostream>
#include<bits/stdc++.h>

using namespace std;

typedef pair<int, int> pi;

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

    void insert(Node *road) {
        if (this->length == 0) {
            this->head = road;
            this->tail = road;
        } else {
            this->tail->nextNode = road;
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
private:
    LinkedList** list;
    int *distance;
    int length;
public:
    Graph (int length) {
        this->list = new LinkedList*[length];
        for (int i = 0; i < length; i++) {
            list[i] = new LinkedList();
        }
        this->distance = new int[length];
        this->length = length;
    }

    void insert (int index1, int index2, int cost) {
        Node *aux = new Node(index2-1,cost);
        this->list[index1-1]->insert(aux);
    }

    int* travessy(int cost) {
        initialize();
        Prim(0);
        int *aux = new int[2];
        aux[0] = cost;
        aux[1] = 1;
        for (int i = 1; i < this->length; i++) {
            if (this->list[i]->visited) {
                if (this->distance[i] >= cost) {
                    aux[1]++;
                    aux[0] += cost;
                } else {
                    aux[0] += this->distance[i];
                }

            } else {
                aux[1]++;
                aux[0] += cost;
                Prim(i);
            }
        }
        return aux;
    }

    void initialize() {
        for (int i = 0; i < this->length; i++) {
            this->distance[i] = INT_MAX;
        }
    }

    void Prim (int index) {
        priority_queue<pi, vector<pi>, greater<pi> > pq;
        pq.push(make_pair(0, index));
        this->distance[index] = 0;
        for (int i = 0; i < this->length && !pq.empty(); i++) {
            pair<int, int> top = pq.top();
            int v = top.second;
            pq.pop();
            while (this->list[v]->visited) {
                if (pq.empty()) {
                    break;
                } else {
                    top = pq.top();
                    v = top.second;
                    pq.pop();
                }
            }
            this->list[v]->visited = true;
            int w = this->list[v]->first();
            while (w > -1) {
                if (!this->list[w]->visited && this->distance[w] > this->list[v]->head->cost) {
                    this->distance[w] = this->list[v]->head->cost;
                    pq.push(make_pair(distance[w], w));
                }
                w = this->list[v]->next();
            }
        }
    }
};

int main() {
    int cases;
    cin >> cases;
    for (int i = 1; i <= cases; i++) {
        int length, lines, cost;
        cin >> length >> lines >> cost;
        Graph* graph = new Graph(length);
        for (int j = 0; j < lines; j++) {
            int index1,index2,costNode;
            cin >> index1 >> index2 >> costNode;
            graph->insert(index1,index2,costNode);
            graph->insert(index2,index1,costNode);
        }
        int* aux = graph->travessy(cost);
        cout << "Case #" << i << ": " << aux[0] << " " << aux[1] << endl;
    }
    return 0;
}