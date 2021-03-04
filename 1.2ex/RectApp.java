public class RectApp{
    public static void main(String[] args) {
        Rect r = new Rect(1,1,10,10);
        //r.print();
        System.out.format("Retangulo de area: %d\n",r.area());
        r.drag(4, 5);
        System.out.println("Retangulo movido...");
        r.print();
    }
}
class Rect{
    int x,y,w,h;
    Rect(int x,int y,int w, int h){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }
    void print(){
        System.out.format("Retangulo de tamanho (%d,%d) na posição (%d,%d) \n",this.w,this.h,this.x,this.y);
    }
    int area(){
        int a=(this.w * this.h)/2;
        return a;
    }
    void drag (int dx, int dy){
        this.x=this.x+dx;
        this.y=this.y+dy;
    }

}