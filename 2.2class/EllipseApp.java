import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1,e2,e3;

    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Ellipses");
        this.setSize(350, 350);
        this.e1 = new Ellipse(100,80, 130,70,Color.BLACK,Color.WHITE);
        this.e2 = new Ellipse(100,130, 130,70,Color.BLACK,Color.BLUE);
        this.e3 = new Ellipse(100,180, 130,70,Color.BLUE,Color.BLACK);

    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);

    }
}

class Ellipse {
    int x, y;
    int w, h;
    Color cc,cf;
    Ellipse (int x, int y, int w, int h,Color cc, Color cf) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cc = cc;
        this.cf = cf;
    }

    /*void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }*/

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cc);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setPaint(this.cf);
        g2d.fill(new Ellipse2D.Double(this.x+1,this.y+1, this.w-1,this.h-1));

    }
}
