package figures;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
public class Line extends Figure{
    private int x2;
    private Line2D line;
    //a llargura será a grossura da linha e a altura será o y2
    public Line(int x,int y,int x2,int h,int w,Color cc){
        super(x,y,h,w,cc);
        this.x2=x2;
        this.line= new Line2D.Double(this.x,this.y,this.x2,this.h);
    }
    @Override
    public void resize(int h,int w){
        this.h+=h;
        this.w+=w;
        this.line= new Line2D.Double(this.x,this.y,this.x2,this.h);
    }
    @Override
    public void changeColor(Color cc) {
    }
    @Override
	public boolean clicked(MouseEvent evt) {
			if (this.line.ptSegDist(evt.getPoint()) <= 5)
				return true;
			return false;
	}

    @Override
    public void drag (int x, int y, Point mouse_pos) {
        if (Math.sqrt(Math.pow(this.x - mouse_pos.x, 2) + Math.pow(this.y - mouse_pos.y, 2)) <= 5) {
            this.x += x;
            this.y += y;
        } else if (Math.sqrt(Math.pow(this.x2 - mouse_pos.x, 2) + Math.pow(this.h - mouse_pos.y, 2)) <= 5) {
            this.x2 += x;
            this.h += y;
        } else {
            this.x += x;
            this.y += y;

            this.x += x;
            this.y += y;

            this.x2 += x;
            this.h += y;
        }

        this.line = new Line2D.Double(this.x, this.y, this.x2, this.h);
    }
    
    @Override
    public void paint(Graphics g,boolean focused) {
		Graphics2D g2d = (Graphics2D) g;
		if(focused){
			g2d.setColor(Color.RED);
        }
        else
		    g2d.setColor(this.cc);
        g2d.draw(this.line);
        if(this.w<0)
            g2d.setStroke(new BasicStroke(0));
        else
            g2d.setStroke(new BasicStroke(this.w));
        
        g2d.draw(this.line);
        g2d.setStroke(new BasicStroke(0));
        
    }
}
