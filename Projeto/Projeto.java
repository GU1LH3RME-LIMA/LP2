import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import figures.*;
import ivisible.Ivisible;
public class Projeto{
    public static void main(String[] args) {
        PackFrame frame=new PackFrame();
        frame.setVisible(true);
    }
    }
class PackFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Point pos;
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
            //gives a focus on figure
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    pos = getMousePosition();
                    int x = evt.getX();
                    int y = evt.getY();
                    if (focus != null) {
                        focus.cc = a;
                    }

                    focus = null;

                    for (Figure fig: figs) {
                        if (fig.clicked(x,y)) {
                            System.out.println("CLICKED");
                        }
                        if (fig.contains(evt)) {
                            focus = fig;
                            a = focus.cc;
                        }
                    }
                    
                    if (focus != null) {
                        if(focus.cc != Color.RED){
                            focus.cc = Color.RED;
                        }
                        else{
                            focus.cc=Color.GREEN;
                        }
                        figs.remove(focus);
                        figs.add(focus);
                    }
                repaint();
                }
            }
            );

            this.addMouseMotionListener (
                // action that move the figure
                new MouseMotionAdapter() {
                    public void mouseDragged (MouseEvent evt) {
                        if (focus != null) {
                            if (pos != null)
                                focus.drag(evt.getX() - pos.x, evt.getY() - pos.y, evt.getPoint());
                            pos = getMousePosition();
                            repaint();
                        }
                    }
                }
            );

            this.addKeyListener (
            new KeyAdapter() {

                public void keyPressed (KeyEvent evt) {
                    Point mouse = getMousePosition();
                    if(mouse==null) return;
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(mouse.x,mouse.y, 30
                        ,30,Color.BLACK,Color.WHITE));
                    }else if(evt.getKeyChar() == 'r'){
                        figs.add(new Rect(mouse.x,mouse.y, 30
                        ,30,Color.BLACK,Color.WHITE));
                    }
                    else if(evt.getKeyChar() == 't'){
                        figs.add(new Triang(mouse.x,mouse.y, 30
                        ,30,Color.BLACK,Color.WHITE));
                    }
                    else if(evt.getKeyChar() == 'l'){
                        figs.add(new Line(mouse.x, mouse.y,
                        60, 60 , 3,  Color.BLACK));
                    }
                    else if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
                        
                        if (focus == null && figs.size() > 0) {
                            focus=figs.get(0);
                            focus.cc=Color.RED;
                            figs.remove(focus);
                            figs.add(focus);
                        }
                     else {
                        focus.cc=Color.BLACK;
                        focus=figs.get((figs.indexOf(focus) + 1) % figs.size());
                        focus.cc=Color.RED;
                        figs.remove(focus);
                        figs.add(focus);
                    }
                    
                }
                    //change the color
                    else if(focus!=null){
                        if(evt.getKeyChar() == '1' ){
                            focus.changeColor(JColorChooser.showDialog(null, "Escolha uma cor para o fundo da figura", Color.black));
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
                            figs.remove(focus);
                            focus=null;
                         }
                    //change the border
                        else if(evt.getKeyChar() == '6'){
                            focus.cc=JColorChooser.showDialog(null, "Escolha uma cor para o fundo da figura", Color.black);
                            a=focus.cc;
                        }
                        else if(evt.getKeyCode() ==KeyEvent.VK_UP) {
                            focus.resize(1,0);
                            a=focus.cc;
                        }
                        else if(evt.getKeyCode() ==KeyEvent.VK_DOWN) 
                            focus.resize(-1,0);
                        else if(evt.getKeyCode() ==KeyEvent.VK_RIGHT) 
                            focus.resize(0,1);
                        else if(evt.getKeyCode() ==KeyEvent.VK_LEFT)
                            focus.resize(0,-1);  
                }
                repaint();
                }
            }
        );
        this.setTitle("Mini Editor");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}