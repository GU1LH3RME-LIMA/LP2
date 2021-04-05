package figures;

import java.awt.*;

public class Word extends Figure{
    
    String word;
    public Word(int x,int y,int w, String word,Color cc){
        super(x, y,w, cc);
        this.word=word;
    }
        public void print (){
            System.out.format("Frase na  posicao (%d,%d):''%s''.\n",
            this.x, this.y,this.word);
        }
        public void paint(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("Segoe Script", Font.BOLD , this.w));
            g2d.setColor(this.cc);
            g2d.drawString(this.word, this.x, this.y);
        }
    

} 
