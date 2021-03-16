
#include <iostream>

using namespace std;


class MaxHeap {
private:
    int dim = 0;
    int V[50];

    int parinte(int i) { return i / 2; }; //determina nodul parinte
    int cop_st(int i) { return i * 2; }; //determina nodul copil stanga
    int cop_dr(int i) { return i * 2 + 1; };//determina nodul copil dreapta

public:
    void insert(int);
    void fixUp(int);
    void fixDown(int);
    int extractMax();
    bool isEmpty() { return dim == 0; }; //verifica daca heap ul este gol
};

void MaxHeap::fixUp(int i) {
    if (i > dim)
        return;
    if (i == 1)                            //verifica ca elementele sa fie in ordinea corespunzatoare, adica parintii sa fie nr mai mari decat copii, de jos in us
        return;                            //in caz contrar, le schimba pozitia
    if (V[i] > V[parinte(i)])              //implementat recursiv
        swap(V[parinte(i)], V[i]);
    fixUp(parinte(i));
}

void MaxHeap::fixDown(int i) {
    if (i > dim) return;

    int swapId = i;

    if (cop_st(i) <= dim && V[i] < V[cop_st(i)])      //verifica ca elementele sa fie in ordinea corespunzatoare, adica parintii sa fie nr mai mari decat copii, de sus in jos
        swapId = cop_st(i);                           //in caz contrar, le schimba pozitia
                                                      //implementat recursiv
    if (cop_dr(i) <= dim && V[i] < V[cop_dr(i)])
        swapId = cop_dr(i);

    if (swapId != i) {
        swap(V[i], V[swapId]);
        fixDown(swapId);
    }
    return;
}

void MaxHeap::insert(int nr) {
    V[++dim] = nr;                                  //insereaza un element, apoi se asigura ca ajunge la pozitia corespunzatoare apeland functia fixUp
    fixUp(dim);
}

int MaxHeap::extractMax() {
    int maxNr = V[1];
    swap(V[1], V[dim--]);                          //extrage numarul maxim din heap
    fixDown(1);
    return maxNr;
}

int main()
{
    MaxHeap* PQ = new MaxHeap;
    int n, nr, k, suma = 0;
    cout << "Introduceti nr K";
    cin >> k;   //citeste de la tastatura numarul K din enunt
    cout << endl;
    cout << "Intorduceti nr de elemente";
    cin >> n;   //citeste de la tastatura numarul de elemente din array
    
    for (int i = 1; i <= n; i++) {
        cin >> nr;                   //citeste de la tastatura elementele array-ului
        PQ->insert(nr);             //adauga elementele in heap
    }

    for (int i = 1; i <= k; i++) {
        nr = PQ->extractMax();     //memoreaza maximul curent
        suma += nr;                //adauga maximul curent in suma
        PQ->insert(--nr);          //adauga maximul decrementat cu 1 inapoi in heap
    }

    cout << suma;
    return 0;

}

