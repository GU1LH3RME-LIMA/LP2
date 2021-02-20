import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        
    }

    public void paint (Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,125, w,125);
        g2d.drawLine(125,0, 125,h);
        GradientPaint redblue = new GradientPaint(0,80,Color.RED,100, 0,Color.BLUE);
		g2d.setPaint(redblue);
        g2d.fill(new Rectangle2D.Double(125, 125,
                               223,
                               125));
                          
    }
}
