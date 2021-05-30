import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import figures.*;
import button.Button;
import ivisible.Ivisible;
import java.io.*;
import java.lang.Object;
public class Projeto{
    public static void main(String[] args) {
        PackFrame frame=new PackFrame();
        frame.setVisible(true);
    }
    }
class PackFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buttons= new ArrayList<Button>();
    Point pos;
    Figure focus = null;
    Button selected=null;
    Color a = null;
    PackFrame () {
        
        buttons.add(new Button(0,new Rect(27,50,15,15,Color.BLACK,Color.WHITE)));
        buttons.add(new Button(1,new Ellipse(57,80,15,15,Color.BLACK,Color.BLACK)));
        buttons.add(new Button(2,new Triang(25,120,20,15,Color.BLACK,Color.WHITE)));
        buttons.add(new Button(3, new Line(57, 147, 73, 147,2, Color.BLACK)));
        buttons.add(new Button(4, new Line(27, 170, 43, 187,2, Color.BLACK)));
        buttons.add(new Button(5, new Line(57, 217, 73, 200,2, Color.BLACK)));
        try{
            FileInputStream f=new FileInputStream("proj.bin");
            ObjectInputStream o=new ObjectInputStream(f);
            this.figs = (ArrayList<Figure>) o.readObject();
            o.close(); 
        }
        catch (Exception x) {
           System.out.println("ERRO");
        }
        this.setFocusTraversalKeysEnabled(false);
        this.addWindowListener (
			new WindowAdapter(){
             public void windowClosing(WindowEvent windowEvent) {
                    try {
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);

                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    } catch (Exception x) {
                        System.out.println(x.getMessage());
                    }

                    System.exit(0);
                }
            }
        );
       this.addMouseListener (
            //gives a focus on figure
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    pos = getMousePosition();
                    if(selected != null && !(evt.getX() >= 25 && evt.getX() <= 57 && evt.getY() >= 50 && evt.getY() <= 217)){
						if(selected.idx==0)
								figs.add(new Rect(evt.getX(),evt.getY(),30,30,Color.BLACK,Color.WHITE));      
							else if(selected.idx==1)
								figs.add(new Ellipse(evt.getX(),evt.getY(),30,30,Color.BLACK,Color.WHITE));
							else if(selected.idx==2)
							figs.add(new Triang(evt.getX(),evt.getY(),30,30,Color.BLACK,Color.WHITE));
						else if(selected.idx==3)
							figs.add(new Line(evt.getX(),evt.getY(),180,180,2,Color.BLACK));
						selected.focused = false;
                        selected = null;
                        repaint();
                        return;
						}
					selected=null;
                    for (Button but: buttons) {
                        but.focused = false;
						if (but.clicked(evt)) {
                            but.focused = true;
                            selected = but;
                        }
                    }
                     if (selected != null){
						if(selected.idx==4 && focus!=null)
							focus.resize(-1,0);
						else if(selected.idx==5 && focus!=null)
							focus.resize(1,0);
						else{
						if(focus!=null)
							focus.focused=false;
						focus=null;
					}
                        repaint();
						return;
						
                    }
                    if(focus!=null)
							focus.focused=false;
						focus=null;
                    for (Figure fig: figs) {
						
                        if (fig.clicked(evt)) {
                            focus = fig;
                            focus.focused=true;
                            return;
                        }
                        if(focus!=null)
							focus.focused=false;
                        
                    }
                    if (focus!=null){
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
                    else if(evt.getKeyChar()=='g'){
                        try {
                            File file = new File("desenho.svg"); // make file
                            PrintWriter writer;
                            writer = new PrintWriter(new FileOutputStream(file)); // write and
                                                                                    // save file
                            writer.flush();
                            writer.close();
                    
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
                        
                        if (focus == null && figs.size() > 0) {
                            focus=figs.get(0);
                            focus.focused=true;
                            figs.remove(focus);
                            figs.add(focus);
                        }
                     else {
						focus.focused=false;
                        focus=figs.get((figs.indexOf(focus) + 1) % figs.size());
                        focus.focused=true;
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
        this.setSize(600, 600);
        setLocationRelativeTo(null); 
    }
	public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g,fig.focused);
        }
        for (Button but: this.buttons) {
            but.paint(g,but.focused);
        }
    }
}
