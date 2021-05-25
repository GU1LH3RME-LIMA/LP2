#include <stdio.h>
#include <stdlib.h>
#include "rect.h"
typedef struct {
    int r,g,b;
} Color;
typedef struct Rect{
    int x,y,h,w;
    Color cc,cf;
}Rect;
Rect* rect_new () {
    Rect*   this  = malloc(sizeof(Rect));
    this->x = rand()%100;
    this->y = rand()%100;
    this->w = rand()%30;
    this->h = rand()%30;
}

void rect_print (Rect* this) {
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) area=%d .\n",
           this->w, this->h, this->x, this->y,rect_area(this));
}
int rect_area(Rect* this){
    return this->w*this->h;
}
void rect_drag(Rect* this, int x,int y){
    this->x+=x;
    this->y+=y;
}