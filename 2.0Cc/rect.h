#ifndef RECT_H
#define RECT_H

typedef struct Rect Rect;
Rect* rect_new (void);
void rect_print (Rect*);
void rect_drag (Rect*, int,int);
int rect_area(Rect*);
#endif
