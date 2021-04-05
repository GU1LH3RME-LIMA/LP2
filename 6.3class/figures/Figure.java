package figures;

import java.awt.*;

public abstract class Figure {
    protected int x,y,w;
    protected Color cc;
    protected Figure(int x, int y,int w, Color cc){
        this.x=x;
        this.y=y;
        this.w=w;
        this.cc=cc;

    }
    public abstract void print();
    public abstract void paint (Graphics g);
}