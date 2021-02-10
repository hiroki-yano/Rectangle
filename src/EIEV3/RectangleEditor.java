package EIEV3;
import java.io.*;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Point;



public class RectangleEditor extends Applet implements MouseListener{

    Board bd = new Board();
    Command cmd = new Command(bd);
    DisplayCanvas display;
    InputPanel input;
    final int INITIAL =-1;
    final int ERROR = 100;

    private int recNumber = INITIAL;
    private int recNumber2 = INITIAL;

    public void init(){
        setVisible(true);

        display = new DisplayCanvas(this,bd);
        input = new InputPanel(this,bd);

        setLayout(new BorderLayout());
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();

        panel1.add(input);
        panel2.add(display);

        add(panel1,BorderLayout.NORTH);
        add(panel2,BorderLayout.SOUTH);

        addMouseListener(this);
    }


    public void start(){
    }

    public void paint(Graphics g){
        g.drawRect(100,150,500,400);

        this.display.display(g);
    }

    public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){

        Point point = e.getPoint();
        int count = 0;

        for(int i = this.bd.getterRecboard().size()-1;i>=0;i--){
            double x = this.bd.getterRecboard().get(i).getterX();
            double y = this.bd.getterRecboard().get(i).getterY();
            double width = this.bd.getterRecboard().get(i).getterWidth();
            double height = this.bd.getterRecboard().get(i).getterHeight();

            if(x+100 <= point.x && point.x <= x+100 + width && y+150 <= point.y && point.y <= y+150 + height){
                if(this.recNumber == INITIAL){
                    this.recNumber = i;
                }
                else if(this.recNumber2 == INITIAL){
                    this.recNumber2 = i;
                }
                else System.out.println("Error");
            }
            else count++;

        }
        if(count == this.bd.getterRecboard().size()) this.recNumber = 100;

        if(recNumber != INITIAL) System.out.println("1st Rectangle Number = " + recNumber);
        if(recNumber2 != INITIAL) System.out.println("2nd Rectangle Number = " + recNumber2);
        if(recNumber == ERROR || recNumber2 == ERROR) System.out.println("select error.");

    }

    public int getRecNumber(){
        return this.recNumber;
    }
    public int getRecNumber2(){
        return this.recNumber2;
    }

    public void setRecNumber(int recNumber){
        this.recNumber = recNumber;
    }
    public void setRecNumber2(int recNumber2){
        this.recNumber2 = recNumber2;
    }


}