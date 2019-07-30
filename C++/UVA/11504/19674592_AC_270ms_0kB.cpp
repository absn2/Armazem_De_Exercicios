/*
Antonio B. S. Netto
absn2
*/
#include <iostream>
using namespace std;


struct Node {
    int number;
    Node* nextNode;

    Node(int number) {
        this->number = number;
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

    void insert(Node *domino) {
        if (this->length == 0) {
            this->head = domino;
            this->tail = domino;
        } else {
            this->tail->nextNode = domino;
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

struct Stack {
    Node *top;
    int length;

    Stack () {
        this->length = 0;
        this->top = NULL;
    }

    void push (Node * node){
        if (this->length == 0) {
            this->top = node;
        } else {
            Node *aux = this->top;
            this->top = node;
            this->top->nextNode = aux;
        }
        this->length++;
    }

    void pop () {
        if (this->length != 0) {
            this->top = this->top->nextNode;
            this->length--;
        }
    }
    int getLength () {
        return this->length;
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

    void insert(Node *domino, int index) {
        this->list[index]->insert(domino);
    }

    void stackTraverse(Stack *stack) {
        for (int i = 0; i < this->length; i++) {
            if(!this->list[i]->visited) {
                topoSorto(this->list[i], i, stack);
            }
        }
    }

    void topoSorto(LinkedList* list, int i, Stack *stack) {
        this->list[i]->visited = true;
        int w = this->list[i]->first();
        while (w > -1) {
            if (!this->list[w]->visited) {
                topoSorto(this->list[w], w, stack);
            }
            w = this->list[i]->next();
        }
        Node *aux = new Node(i);
        stack->push(aux);
    }



    int graphTraverse(Stack *stack) {
        int aux = 0;
        while (stack->getLength() > 0) {
            int j = stack->top->number;
            if (!this->list[j]->visited) {
                aux++;
                dfs(this->list[j], j);
            }
            stack->pop();
        }
        return aux;
    }

    void dfs (LinkedList* list, int i) {
        this->list[i]->visited = true;
        int w = this->list[i]->first();
        while (w > -1) {
            if (!this->list[w]->visited) {
                dfs(this->list[w], w);
            }
            w = this->list[i]->next();
        }
    }
};

int main () {
    int cases;
    cin >> cases;
    for (int i = 0; i < cases; i++) {
        int size,lines = 0;
        cin >> size;
        cin >> lines;
        Stack* stack = new Stack();
        Graph* graph1 = new Graph(size);
        Graph* graph2 = new Graph(size);
        for (int j = 0; j < lines; j++) {
            int index,connect;
            cin >> index;
            cin >> connect;
            index--;
            connect--;
            Node* aux = new Node (connect);
            graph1->insert(aux, index);
            graph2->insert(aux, index);
        }
        graph1->stackTraverse(stack);
        int result = graph2->graphTraverse(stack);
        cout << result << "\n";
        delete graph1;
        delete graph2;
        delete stack;
    }
    return 0;
}