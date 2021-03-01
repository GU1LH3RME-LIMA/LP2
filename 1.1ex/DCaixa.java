public class DCaixa{
    public static void main (String[] args) {
        Caixa c = new Caixa(30,90,30,137.6);
        c.print();
    }
} 
class Caixa{
    int x,y,z;
    double altura;
    Caixa(int x,int y,int z,double altura){
        this.x=x;
        this.y=y;
        this.z=z;
        this.altura=altura;
    }
    void print(){
        System.out.format("Caixa de dimensões (%d,%d,%d) e altura %.2f \n",this.x,this.y,this.z,this.altura);
    }
}
