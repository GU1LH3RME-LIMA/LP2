package figures;
import java.awt.*;
import java.awt.event.*;
public class Rect extends Figure {
    Color cf;
    Rectangle rect;
    public Rect (int x, int y, int w, int h,Color cc,Color cf) {
        super(x, y,h,w, cc);
        this.cf=cf;
        this.rect= new Rectangle(this.x+1,this.y+1, this.w-1,this.h-1);
    }
    @Override
    public void changeColor(Color cf) {
        this.cf=cf;
    }
    @Override
    public void resize(int h,int w){
        this.h+=h;
        this.w+=w;
        this.rect = new Rectangle(this.x+1,this.y+1, this.w-1,this.h-1);
    }
    @Override
    public void drag(int x,int y, Point pos){
        this.x+=x;
        this.y+=y;
        this.rect = new Rectangle(this.x+1,this.y+1, this.w-1,this.h-1);
    }
    @Override
	public boolean contains(MouseEvent evt) {
			if (this.rect.contains(evt.getPoint()))
				return true;
			return false;
	}
    @Override
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.cc);
        g2d.draw(this.rect);
        g2d.setColor(this.cf);
        g2d.fillRect(this.x+1,this.y+1, this.w-1,this.h-1);

    }
}
