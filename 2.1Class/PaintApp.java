import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1,r2,r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(100,50, 150,50,Color.YELLOW,Color.BLUE);
        this.r2 = new Rect(100,130, 150,50,Color.BLACK,Color.YELLOW);
        this.r3 = new Rect(100,210, 150,50,Color.ORANGE,Color.GREEN);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color cc,cf;

    Rect (int x, int y, int w, int h,Color cc,Color cf) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cc= cc;
        this.cf=cf;
    }

    /*void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }*/

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cc);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.cf);
        g2d.fillRect(this.x+1,this.y+1, this.w+1,this.h+1);

    }
}