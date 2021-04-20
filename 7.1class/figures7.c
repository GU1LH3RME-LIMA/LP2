#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color cc;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    Color cf;
    int dx,dy;
} Triang;

void triang_print (Triang* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Triang* new_triang (int x, int y, int w, int h) {
    Triang*   this  = malloc(sizeof(Triang));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) triang_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, y2,x2;
} Line;

void line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Linha de largura (%d) na posicao (%d,%d,%d,%d).\n",
           this->w,  sup->x, sup->y,this->x2,this->y2);
}

Line* new_line (int x, int y, int w,int x2, int y2) {
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) line_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->x2=x2;
    this->y2 = y2;
    
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