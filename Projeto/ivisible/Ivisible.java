package ivisible;
import java.awt.Graphics;
import java.awt.event.*;
public interface Ivisible{
    public boolean clicked(MouseEvent evt);
    public void paint(Graphics g,boolean focused);
}