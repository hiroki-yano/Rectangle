package EIEV3;
import java.util.LinkedList;

class Board{

    public final String COLOR = "white";
    public final double WIDTH = 500;
    public final double HEIGHT = 400;
    private LinkedList<Rectangle> recboard;

    Board(){
        this.recboard = new LinkedList<Rectangle>();
    }


    public LinkedList<Rectangle> getterRecboard(){
        return this.recboard;
    }

    public boolean overlapCheck(Rectangle newrectangle,Board bd){

        int i=0;
        if(bd.recboard.size()!=0){

            for(i=0;i<bd.recboard.size();i++){

                if(
                    (newrectangle.getterWidth() == bd.recboard.get(i).getterWidth()) &&
                    (newrectangle.getterHeight() == bd.recboard.get(i).getterHeight()) &&
                    (newrectangle.getterX() == bd.recboard.get(i).getterX()) &&
                    (newrectangle.getterY() == bd.recboard.get(i).getterY())
                ){
                    break;
                }
            }
            if(i==bd.recboard.size()){
                return true;
            }
            else{

                System.out.println("Rectangle exists in the same form.");
                return false;
            }
        }
        else return true;


    }
}
