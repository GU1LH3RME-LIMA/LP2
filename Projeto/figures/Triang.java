package figures;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Triang extends Figure{
	Color cf;
	Polygon tri;
	private int xdir[],ydir[];
 public Triang(int x,int y,int w,int h,Color cc,Color cf){
 		super(x,y,h,w,cc);
	 	this.cf=cf;
		int xdir[]= {this.x,((this.w)/2) + (this.x),(this.w) + (this.x)};
		int[] ydir={this.y, (this.y) - (this.h),this.y};
	 	this.tri=new Polygon(xdir, ydir, 3);
   
}
	@Override
	public void print() {
        System.out.format("Triângulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
        }
	@Override
	public boolean contains(MouseEvent evt) {
			if (this.tri.contains(evt.getPoint()))
				return true;
			return false;
	}
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(this.cc);
		g2d.drawPolygon(this.tri);
		g2d.setColor(this.cf);
		g2d.fillPolygon(this.tri);
	}

}
