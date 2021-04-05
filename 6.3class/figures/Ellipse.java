package figures;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
    int  h;
    Color cf;
    public Ellipse (int x, int y, int w, int h,Color cc, Color cf) {
        super(x, y, w, cc);
        this.h = h;
        this.cf = cf;
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cc);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setPaint(this.cf);
        g2d.fill(new Ellipse2D.Double(this.x+1,this.y+1, this.w-1,this.h-1));

    }
}
