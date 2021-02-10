package EIEV3;
import java.io.*;
import java.util.LinkedList;
import java.awt.Color;

class Command{

    private Board bd;

    Command(Board bd){
        this.bd = bd;
    }



    public void create(Board bd,double width,double height,double x,double y,String color){

            Judge jd = new Judge(width,height,x,y,color,bd);
            if(jd.isX() == true && jd.isY() == true && jd.isFrame() == true && jd.isWidth() == true && jd.isHeight() == true && jd.isColor() == true ){
                    Rectangle creRectangle = new Rectangle(width,height,x,y,color);
                    if(bd.overlapCheck(creRectangle,this.bd) == true){
                            this.bd.getterRecboard().add(creRectangle);
                    }
            }
        else System.out.println("You can not store any more rectangular.");
    }



    public void move(Board bd,double move_x,double move_y,int num){

            double result_x = this.bd.getterRecboard().get(num).getterX() + move_x;
            double result_y = this.bd.getterRecboard().get(num).getterY() + move_y;
            double width = this.bd.getterRecboard().get(num).getterWidth();
            double height = this.bd.getterRecboard().get(num).getterHeight();
            String color = this.bd.getterRecboard().get(num).getterColor();

            Judge jd = new Judge(width,height,result_x,result_y,color,bd);
            if(jd.isX() == true && jd.isY() == true && jd.isFrame() == true && jd.isWidth() == true && jd.isHeight() == true && jd.isColor() == true ){

                Rectangle dummy = new Rectangle (width,height,result_x,result_y,color);
                if(bd.overlapCheck(dummy,this.bd) == true){
                    this.bd.getterRecboard().set(num,dummy);
                }
            }
    }



    public void mug(Board bd,double m,int num){


            double result_width = m * this.bd.getterRecboard().get(num).getterWidth();
            double result_height = m * this.bd.getterRecboard().get(num).getterHeight();
            double x = this.bd.getterRecboard().get(num).getterX();
            double y = this.bd.getterRecboard().get(num).getterY();
            String color = this.bd.getterRecboard().get(num).getterColor();


            Judge jd = new Judge(result_width,result_height,x,y,color,bd);
            if(jd.isX() == true && jd.isY() == true && jd.isFrame() == true && jd.isWidth() == true && jd.isHeight() == true && jd.isColor() == true ){
                Rectangle dummy = new Rectangle (result_width,result_height,x,y,color);

                if(bd.overlapCheck(dummy,this.bd) == true){
                    bd.getterRecboard().set(num,dummy);
                }
            }
    }


    public void delete(Board bd,int num){
        if(bd.getterRecboard().size()==0){
            System.out.println("There is no rectangle");
        }

        else{
                this.bd.getterRecboard().remove(num);
        }
    }




    public void deleteAll(Board bd){
        if(this.bd.getterRecboard().size()==0){
            System.out.println("There is no rectangle");
        }
        else{
            this.bd.getterRecboard().clear();
        }
    }



    public void intersect(Board bd,int rec1,int rec2){

        System.out.println(rec1 + "," + rec2);

        if(this.bd.getterRecboard().size()<10){


        double rec1_x = this.bd.getterRecboard().get(rec1).getterX();
        double rec1_y = this.bd.getterRecboard().get(rec1).getterY();
        double rec1_width = this.bd.getterRecboard().get(rec1).getterWidth();
        double rec1_height = this.bd.getterRecboard().get(rec1).getterHeight();
        String rec1_color = this.bd.getterRecboard().get(rec1).getterColor();



        double rec2_x = this.bd.getterRecboard().get(rec2).getterX();
        double rec2_y = this.bd.getterRecboard().get(rec2).getterY();
        double rec2_width = this.bd.getterRecboard().get(rec2).getterWidth();
        double rec2_height = this.bd.getterRecboard().get(rec2).getterHeight();
        String rec2_color = this.bd.getterRecboard().get(rec2).getterColor();



        double result_x = Math.max(rec1_x,rec2_x);
        double result_y = Math.max(rec1_y,rec2_y);
        double ex = Math.min(rec1_x + rec1_width, rec2_x + rec2_width);
        double ey = Math.min(rec1_y + rec1_height, rec2_y + rec2_height);



        double newwidth = ex - result_x;
        double newheight = ey - result_y;




        String newcolor=null;
        if(rec1_color.equals(rec2_color)){
            newcolor = "gray";
        }

        else if((rec1_color.equals("yellow") || rec2_color.equals("yellow")) && (rec1_color.equals("blue") || rec2_color.equals("blue"))){
            newcolor = "green";
        }

        else if((rec1_color.equals("red") || rec2_color.equals("red")) && (rec1_color.equals("yellow") || rec2_color.equals("yellow"))){
            newcolor = "orange";
        }

        else if((rec1_color.equals("red") || rec2_color.equals("red")) && (rec1_color.equals("blue") || rec2_color.equals("blue"))){
            newcolor = "magenta";
        }

        else newcolor = "cyan";

        if (newwidth > 0 && newheight > 0) {
            Rectangle newrectangle = new Rectangle(newwidth,newheight,result_x,result_y,newcolor);
            if(bd.overlapCheck(newrectangle,this.bd) == true){
                this.bd.getterRecboard().add(newrectangle);
            }
        }


        else {
            System.out.println("Error");
        }
        }

        else System.out.println("You can not store any more rectangular.");
    }




    /*

    public void displayboard(Board bd){


        if(this.bd.getterRecboard().size()==0){
        System.out.println("There is no rectangle.");
        }

        else{

            for(int j=0;j<this.bd.getterRecboard().size();j++){
                if(j==0){
                    System.out.println("The " + (j+1) + " st of the rectangle.");
                }
                else if(j==1){
                    System.out.println("The " + (j+1) + " nd of the rectangle.");
                }
                else if(j==2){
                    System.out.println("The " + (j+1) + " rd of the rectangle.");
                }
                else {
                    System.out.println("The " + (j+1) + " th of the rectangle.");
                }
                System.out.println("Width : " + this.bd.getterRecboard().get(j).getterWidth());
                System.out.println("Height : " + this.bd.getterRecboard().get(j).getterHeight());
                System.out.println("Upper-left x-coordinate : " + this.bd.getterRecboard().get(j).getterX());
                System.out.println("Upper-left y-coordinate : " + this.bd.getterRecboard().get(j).getterY());
                System.out.println("Color : " + this.bd.getterRecboard().get(j).getterColor());
                System.out.println("");
            }
        }
    }
    */
}