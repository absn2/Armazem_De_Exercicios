#include <iostream>
using namespace std;

struct No
{
  char letter;
  No *nextNode;

    No (char letter)
  {
    this->letter = letter;
    this->nextNode = NULL;
  }

  char getValor ()
  {
    return this->letter;
  }
};

struct Pilha
{
  No *topo;
  int tamanho;

    Pilha ()
  {
    this->tamanho = 0;
    this->topo = NULL;
  }

  void push (No * node)
  {
    if (this->tamanho == 0)
      {
	this->topo = node;
      }
    else
      {
	No *aux = this->topo;
	this->topo = node;
	this->topo->nextNode = aux;
      }
    this->tamanho++;
  }

  void pop ()
  {
    if (this->tamanho != 0)
      {
	this->topo = this->topo->nextNode;
      }
    this->tamanho--;
  }

  char imprimir ()
  {
    return this->topo->getValor ();
  }

  int getTamanho ()
  {
    return this->tamanho;
  }

};


int
main ()
{
  Pilha *pilha = new Pilha ();
  string parentese;
  cin >> parentese;
  int resultado = 0;
  for (int aux = 0; aux < parentese.length (); aux++)
    {
      if (parentese[aux] == '(')
	{
	  No *noParentese = new No ('(');
	  pilha->push (noParentese);
	}
      else
	{
	  if (pilha->getTamanho () != 0)
	    {
	      pilha->pop ();
	      resultado = resultado + 2;
	    }
	}
    }
  cout << resultado;
  return 0;
}