package EIEV3;

class Judge{
    private double width;
    private double height;
    private double x;
    private double y;
    private String color;
    private Board bd;


    Judge(double width , double height , double x , double y , String color,Board bd){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.color = color;
        this.bd = bd;
    }


    public boolean isX(){
        if(this.x < 0 || this.x > this.bd.WIDTH){
            System.out.println("Error : x-coordinate");
            return false;
        }
        else return true;
    }


    public boolean isY(){
        if((this.y < 0) || this.y > this.bd.HEIGHT){
            System.out.println("Error : y-coordinate");
            return false;
        }
        else return true;
    }

    public boolean isFrame(){
        if((this.x + this.width) > this.bd.WIDTH || (this.y + this.height) > this.bd.HEIGHT ){
            System.out.println("Rectangle is made out of the frame.");
            return false;
        }
        else return true;
    }


    public boolean isWidth(){
        if(this.width <= 0){
            System.out.println("Error : width");
            return false;
        }
        else return true;
    }

    public boolean isHeight(){
        if(this.height <= 0){
            System.out.println("Error : height");
            return false;
        }
        else return true;
    }

    public boolean isColor(){
        if((this.color.equals("red")) || (this.color.equals("blue")) || (this.color.equals("yellow")) || (this.color.equals("grey"))){
            return true;
        }
        else {
            System.out.println("Error : The color that is not defined.");
            return false;
        }
    }

}