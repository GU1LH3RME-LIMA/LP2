import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
public class Projeto{
    public static void main(String[] args) {
        PackFrame frame=new PackFrame();
        frame.setVisible(true);
    }
    
}
class PackFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Point pos;
    Random rand = new Random();
    Figure focus = null;
    Color a = null;
    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
       
            this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    pos = getMousePosition();
                    if (focus != null) {
                        focus.cc = a;
                    }

                    focus = null;

                    for (Figure fig: figs) {
                        if (fig.contains(evt)) {
                            focus = fig;
                            a = focus.cc;
                        }
                    }
                    
                    if (focus != null) {
                        focus.cc = Color.RED;
                        figs.remove(focus);
                        figs.add(focus);
                    }

                    repaint();
                }
            }
            );
            this.addKeyListener (
            new KeyAdapter() {

                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(rand.nextInt(350),rand.nextInt(350), 30
                        ,50,Color.BLACK,Color.WHITE));
                    }else if(evt.getKeyChar() == 'r'){
                        figs.add(new Rect(rand.nextInt(350),rand.nextInt(350), 30
                        ,30,Color.BLACK,Color.WHITE));
                    }
                    else if(evt.getKeyChar() == 't'){
                        figs.add(new Triang(rand.nextInt(350),rand.nextInt(350), 30
                        ,30,Color.BLACK,Color.WHITE));
                    }
                    else if(evt.getKeyChar() == 'l'){
                        figs.add(new Line(rand.nextInt(50), rand.nextInt(50),
                        rand.nextInt(100), rand.nextInt(100), 3,  Color.BLACK));
                         
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
