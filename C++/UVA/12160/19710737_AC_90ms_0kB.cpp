/*
Antonio B. S. Netto
absn2
*/
#include <iostream>
using namespace std;

struct Node {
    int number;
    int repetion;
    Node* nextNode;

    Node(int number, int repetion) {
        this->repetion = repetion;
        this->number = number;
        this->nextNode = NULL;
    }
    int getNumber() {
        return this->number;
    }

    int getRepetion() {
        return this->repetion;
    }

};
struct Queue {
    int length;
    Node *front;
    Node *back;

    Queue() {
        this->length= 0;
        this->front = NULL;
        this->back = NULL;
    }

    void enqueue (Node *button) {
        if (this->length == 0) {
            this->front = this->back = button;
        } else {
            this->back->nextNode = button;
            this->back = this->back->nextNode;
        }
        this->length++;
    }

    int dequeue () {
        if (this->length != 0) {
            int aux = this->front->getNumber();
            this->front = this->front->nextNode;
            this->length--;
            return aux;
        }
    }
    int getLength() {
        return this->length;
    }

};

struct Graph {
    int* buttons;
    bool visited[10000];
    Queue* queue;
    int length;
    int begin;
    int end;

    Graph(int r, int l, int u) {
        buttons = new int [r];
        this->queue = new Queue();
        this->length = r;
        this->begin = l;
        this->end = u;
    }

    void insert (int aux, int index) {
        this->buttons[index] = aux;
    }

    int graphTravessy() {
        for (int i = 0; i < 10000; i++) {
            visited[i] = false;
        }
        int result = bfs(this->begin);
        return result;
    }

    int bfs (int l) {
        Node *button = new Node(l, 0);
        this->queue->enqueue(button);
        int repetion = 0;
        while (this->queue->getLength() > 0) {
            int repetion = this->queue->front->getRepetion();
            int v = this->queue->dequeue();
            if (v == this->end) {
                return repetion;
            } if (!visited[v]) {
                visited[v] = true;
                for (int i = 0; i < this->length; i++) {
                    int aux = (v + this->buttons[i]) % 10000;
                    Node *button = new Node (aux, repetion+1);
                    queue->enqueue(button);
                }
            }
        }
        return -1;
    }
};

int main () {
    bool stop = false;
    int cases = 1;
    while (!stop) {
        int l,u,r;
        cin >> l >> u >> r;
        Graph* graph = new Graph (r, l, u);
        if (l == 0 && u == 0 && r == 0) {
            stop = true;
        } else {
            for (int i = 0; i < r; i++) {
                int aux;
                cin >> aux;
                graph->insert(aux, i);
            }
            int result = graph->graphTravessy();
            cout << "Case " << cases << ": ";
            if (result == -1) {
                cout << "Permanently Locked" << endl;
            } else {
                cout << result  << endl;
            }
            delete graph;
            cases++;
        }
    }
    return 0;
}