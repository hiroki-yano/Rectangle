package EIEV3;
class Rectangle{

    private double width;
    private double height;
    private double x;
    private double y;
    private String color;


    Rectangle(double width,double height,double x,double y,String color){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getterWidth(){
        return this.width;
    }
    public double getterHeight(){
        return this.height;
    }
    public double getterX(){
        return this.x;
    }
    public double getterY(){
        return this.y;
    }

    public String getterColor(){
        return this.color;
    }

}