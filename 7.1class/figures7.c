#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    int w, h;
    Color cc;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    Color cf;
    int dx,dy;
} Triang;

void triang_print (Triang* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           sup->w, sup->h, sup->x, sup->y);
}

Triang* new_triang (int x, int y, int w, int h) {
    Triang*   this  = malloc(sizeof(Triang));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) triang_print;
    sup->x = x;
    sup->y = y;
    sup->w = w;
    sup->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int x2;
} Line;

void line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Linha de largura (%d) na posicao (%d,%d,%d,%d).\n",
           sup->w,  sup->x, sup->y,this->x2,sup->h);
}

Line* new_line (int x, int y, int w,int x2, int h) {
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) line_print;
    sup->x = x;
    sup->y = y;
    sup->w = w;
    sup->h=h;
    this->x2=x2;
    
    
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) new_triang(15,20,50,50),
        (Figure*) new_line(65,20,3,20,20),
        (Figure*) new_line(65,30,3,20,50),
        (Figure*) new_triang(30,20,50,50),
    };

    ///

    for (int i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}