#include <stdio.h>

typedef struct Estrela{
    int cantos;
    double raio,altura;
    int x,y;
}Estrela;

void print(Estrela *);

void main(void){
    Estrela x={6,0.5,71.8,3,4};
    print(&x);
}

void print(Estrela *x){
    printf("Uma estrela com %i cantos,raio de %.2lf e  %.2lf mm de altura na posição (%i,%i) \n",x->cantos,x->raio,x->altura,x->x,x->y);
}