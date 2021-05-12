package button;
import ivisible.Ivisible;

class Button implements Ivisible{
    int x,y,w,h;
    public Button(int x,int y,int w,int h){
        this.x=x;
        this.y=y;
        this.h=h;
        this.w=w;
    }
    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
}