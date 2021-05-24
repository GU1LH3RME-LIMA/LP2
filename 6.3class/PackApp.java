import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Word p;
    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(rand.nextInt(350),rand.nextInt(350), rand.nextInt(100)
                        ,rand.nextInt(50),new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)),
                        new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))));
                    }else if(evt.getKeyChar() == 'r'){
                        figs.add(new Rect(rand.nextInt(350),rand.nextInt(350), rand.nextInt(100)
                        ,rand.nextInt(100),new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)),
                        new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))));
                    }
                    else if(evt.getKeyChar() == 'l'){
                        figs.add(new Word(rand.nextInt(350),rand.nextInt(350),rand.nextInt(30),rand.toString(),new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))));
                    }
                    repaint();

                }
            }
        );

        this.setTitle("Figuras Universais");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}