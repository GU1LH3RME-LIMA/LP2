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
                    //change the color
                    else if(evt.getKeyChar() == '1' && (focus!=null)){
                        focus.changeColor(Color.RED);
                        }
                    else if(evt.getKeyChar() == '2' && (focus!=null) ){
                        focus.changeColor(Color.GREEN);
                    }
                    else if(evt.getKeyChar() == '3' && (focus!=null) ){
                        focus.changeColor(Color.BLUE);
                    }
                    else if(evt.getKeyChar() == '4' && (focus!=null) ){
                        focus.changeColor(Color.BLACK);
                    }
                    else if(evt.getKeyChar() == '5' && (focus!=null) ){
                        focus.changeColor(Color.WHITE);
                        }
                    
                    //change the border
                    else if(evt.getKeyChar() == '6' && focus!=null){
                        focus.changeBorder(Color.RED);
                    }
                    else if(evt.getKeyChar() == '7' &&  focus!=null){
                        focus.changeBorder(Color.GREEN);
                    }
                    else if(evt.getKeyChar() == '8' && focus!=null){
                       focus.changeBorder(Color.BLUE);
                    }
                    else if(evt.getKeyChar() == '9' && focus!=null){
                        focus.changeBorder(Color.BLACK);
                    }
                    else if(evt.getKeyChar() == '0' && focus!=null){
                        focus.changeBorder(Color.WHITE);
                        }
                    else if(evt.getKeyCode() == KeyEvent.VK_DELETE && focus!=null){
                            figs.remove(focus);
                            focus=null;
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