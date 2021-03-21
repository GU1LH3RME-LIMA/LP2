package figures;
import java.awt.*;
public class Rect {
    int x, y;
    int w, h;
    Color cc,cf;

    public Rect (int x, int y, int w, int h,Color cc,Color cf) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cc= cc;
        this.cf=cf;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cc);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.cf);
        g2d.fillRect(this.x+1,this.y+1, this.w-1,this.h-1);

    }
}