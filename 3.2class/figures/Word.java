package figures;

import java.awt.*;

public class Word{
    int x,y;
    String word;
    Color cl;
    public Word(int x,int y, String word,Color cl){
        this.x=x;
        this.y=y;
        this.word=word;
        this.cl=cl;
    }
        public void print (){
            System.out.format("Frase na  posicao (%d,%d):''%s''.\n",
            this.x, this.y,this.word);
        }
        public void paint(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(this.cl);
            g2d.drawString(this.word, this.x, this.y);
        }
    

} 