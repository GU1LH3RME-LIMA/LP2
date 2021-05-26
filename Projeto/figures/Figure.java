package figures;
import ivisible.Ivisible;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
public abstract class Figure implements Ivisible,Serializable {
    protected int x,y,h,w;
    public boolean focused;
    public Color cc;
    protected Figure(int x, int y,int h,int w, Color cc){
        this.x=x;
        this.y=y;
        this.h=h;
        this.w=w;
        this.cc=cc;
    }
    public abstract void changeColor(Color cf);
    public abstract void drag (int dx, int dy,Point pos); 
    public abstract void resize(int nh,int nw);  
    public  void print(){
        System.out.format("Figura de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public abstract boolean clicked (MouseEvent evt);
}
