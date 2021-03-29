package figures;

import java.awt.*;

public abstract class Figure {
    protected int x,y;
    protected Color cc;
    protected Figure(int x, int y, Color cc){
        this.x=x;
        this.y=y;
        this.cc=cc;

    }
    public abstract void print();
    public abstract void paint (Graphics g);
}