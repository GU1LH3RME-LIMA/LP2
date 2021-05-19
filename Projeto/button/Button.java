package button;
import ivisible.Ivisible;
import figures.Figure;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.*;
import java.awt.event.*;
public class Button implements Ivisible {
    public int x, y;
    static int DIM = 30;
    public  int    idx;
    private Figure fig;
    public boolean focused;
    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.focused=false;

        this.x = 20 +(DIM*(idx%2));
        this.y = 42 + idx * DIM;
    }

    public boolean clicked (MouseEvent evt) {
        return evt.getX() >= this.x && evt.getX() <= this.x + DIM && evt.getY() >= this.y && evt.getY() <= this.y + DIM;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, DIM, DIM));

        g2d.setColor(Color.BLACK);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, DIM, DIM));

        this.fig.paint(g, false);
    }
}
