package figures;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
public class Line extends Figure{
    public int x2;
    Line2D line;
    //a llargura será a grossura da linha e a altura será o y2
    public Line(int x,int y,int x2,int h,int w,Color cc){
        super(x,y,h,w,cc);
        this.x2=x2;
        this.line= new Line2D.Double(this.x,this.y,this.x2,this.h);
    }
    @Override
    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    @Override
	public boolean contains(MouseEvent evt) {
			if (this.line.contains(evt.getPoint()))
				return true;
			return false;
	}
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cc);
        g2d.setStroke(new BasicStroke(this.w));
        g2d.draw(this.line);
        g2d.setStroke(new BasicStroke(0));
        
    }
}