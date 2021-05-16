package figures;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.event.*;
public class Ellipse extends Figure {
    private Color cf;
    private Ellipse2D ellipse;
    public Ellipse (int x, int y, int w, int h,Color cc, Color cf) {
        super(x, y,h, w, cc);
        this.cf = cf;
        this.ellipse= new Ellipse2D.Double(this.x+1,this.y+1, this.w-1,this.h-1);
    }
    @Override
    public void changeColor(Color cf) {
        this.cf=cf;
    }
    @Override
    public void drag(int x,int y, Point pos){
        this.x+=x;
        this.y+=y;
        this.ellipse = new Ellipse2D.Double(this.x-1,this.y-1, this.w+1,this.h+1);
    }
    @Override
    public void resize(int h,int w){
        this.h+=h;
        this.w+=w;
        this.ellipse = new Ellipse2D.Double(this.x,this.y, this.w,this.h);
    }
    @Override
	public boolean clicked(MouseEvent evt) {
			if (this.ellipse.contains(evt.getPoint()))
				return true;
			return false;
	}
    @Override
    public void paint(Graphics g,boolean focused) {
		Graphics2D g2d = (Graphics2D) g;
		if(focused){
			g2d.setColor(Color.RED);
            g2d.draw(new Ellipse2D.Double(this.x-2,this.y-2, this.w+4,this.h+4));
        }
		g2d.setColor(this.cc);
        g2d.draw(this.ellipse);
        g2d.setPaint(this.cf);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));

    }
}
