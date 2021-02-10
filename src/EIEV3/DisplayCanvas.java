package EIEV3;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;


class DisplayCanvas extends Canvas{
    RectangleEditor parent;
    Board bd;


    DisplayCanvas(RectangleEditor app,Board bd){
        this.parent = app;
        this.bd = bd;
    }

    public void display(Graphics g){
        for(int i=0;i<this.bd.getterRecboard().size();i++){
            double x = this.bd.getterRecboard().get(i).getterX();
            double y = this.bd.getterRecboard().get(i).getterY();
            double width = this.bd.getterRecboard().get(i).getterWidth();
            double height = this.bd.getterRecboard().get(i).getterHeight();
            String color = this.bd.getterRecboard().get(i).getterColor();




            if(color.equals("red")){
                g.setColor(Color.red);
            }
            else if(color.equals("blue")){
                g.setColor(Color.blue);
            }
            else if(color.equals("yellow")){
                g.setColor(Color.yellow);
            }
            else if(color.equals("gray")){
                g.setColor(Color.gray);
            }
            else if(color.equals("green")){
                g.setColor(Color.green);
            }
            else if(color.equals("orange")){
                g.setColor(Color.orange);
            }
            else if(color.equals("magenta")){
                g.setColor(Color.magenta);
            }
            else if(color.equals("cyan")){
                g.setColor(Color.cyan);
            }


            g.fillRect((int)x+100,(int)y+150,(int)width,(int)height);

        }

    }
}