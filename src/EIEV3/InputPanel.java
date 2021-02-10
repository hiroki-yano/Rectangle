package EIEV3;

import java.applet.Applet;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Label;
import java.awt.Point;



class InputPanel extends Panel implements ActionListener{

    double value[] = new double[4];
    RectangleEditor parent;

    TextField[] createValueFields = new TextField[10];
    TextField[] moveValueFields = new TextField[10];
    TextField[] mugValueFields = new TextField[10];

    Label[] createLabel = new Label[10];
    Label[] moveLabel = new Label[10];
    Label[] mugLabel = new Label[10];

    double[] createValues = new double[10];
    double[] moveValues = new double[10];
    double[] mugValues = new double[10];

    Button createButton;
    Button moveButton;
    Button mugButton;
    Button deleteButton;
    Button deleteAllButton;
    Button intersectButton;
    Button clearButton;

    int i;
    String color;
    private Board bd;
    private Command cmd;
    Panel p;
    private int recNumber;
    private int recNumber2;
    Panel panel1 = new Panel();
    Panel panel2 = new Panel();
    Panel panel3 = new Panel();



    InputPanel(RectangleEditor app,Board bd){
        this.parent = app;
        this.bd = bd;


        setLayout(new BorderLayout( ));

        //create
        createLabel[0] = new Label("width=");
        createLabel[1] = new Label("height= ");
        createLabel[2] = new Label("x =");
        createLabel[3] = new Label("y =");
        createLabel[4] = new Label("color=");



        for ( i = 0; i < 5; i++) {
            panel1.add(createLabel[i]);
            createValueFields[i] = new TextField("0",5);
            panel1.add(createValueFields[i]);
        }

        this.createButton = new Button("Create");
        panel1.add(createButton);
        createButton.addActionListener(this);



        //move
        moveLabel[0] = new Label("x+ =");
        moveLabel[1] = new Label("y+ =");


        for (int i = 0; i < 2; i++) {
            panel2.add(moveLabel[i]);
            moveValueFields[i] = new TextField("0",5);
            panel2.add(moveValueFields[i]);
        }



        this.moveButton = new Button("Move");
        panel2.add(moveButton);
        moveButton.addActionListener(this);


        //expand shrink
        mugLabel[0] = new Label("mx =");
        panel2.add(mugLabel[0]);
        mugValueFields[0] = new TextField("0",5);
        panel2.add(mugValueFields[0]);

        this.mugButton = new Button("expand/shrink");
        panel2.add(mugButton);
        mugButton.addActionListener(this);

        //delete
        this.deleteButton = new Button("Delete");
        panel3.add(deleteButton);
        deleteButton.addActionListener(this);

        //deleteAll
        this.deleteAllButton = new Button("DeleteAll");
        panel3.add(deleteAllButton);
        deleteAllButton.addActionListener(this);

        //intersect
        this.intersectButton = new Button("intersect");
        panel3.add(intersectButton);
        intersectButton.addActionListener(this);

        //selectclear
        this.clearButton = new Button("select Clear");
        panel3.add(clearButton);
        clearButton.addActionListener(this);

        add("North",panel1);
        add("Center",panel2);
        add("South",panel3);
    }







    public void actionPerformed(ActionEvent evt) {
        Button button = (Button)evt.getSource();
        Command cmd = new Command(bd);
        DisplayCanvas display = new DisplayCanvas(this.parent,this.bd);
        this.recNumber = parent.getRecNumber();
        this.recNumber2 = parent.getRecNumber2();

        if(button == this.createButton){
            for(i=0;i<4;i++){
                if(this.createValueFields[i].getText().equals("")) this.createValues[i] = 0;
                else this.createValues[i] = new Double(this.createValueFields[i].getText()).doubleValue();
            }
            if(this.createValueFields[4].getText().equals("")) color = "red";
            else color = this.createValueFields[4].getText();

            cmd.create(this.bd,createValues[0],createValues[1],createValues[2],createValues[3],color);
            this.parent.repaint();
        }



        else if(button == this.moveButton){
            for(i=0;i<2;i++){
                if(this.moveValueFields[i].getText().equals("")) this.moveValues[i] = 0;
                else this.moveValues[i] = new Double(this.moveValueFields[i].getText()).doubleValue();
            }
            cmd.move(this.bd,moveValues[0],moveValues[1],this.recNumber);
            this.parent.repaint();

            this.parent.setRecNumber(parent.INITIAL);
            this.parent.setRecNumber2(parent.INITIAL);
        }



        else if(button == this.mugButton){
            if(this.mugValueFields[0].getText().equals("")) this.mugValues[0] = 0;
            else this.mugValues[0] = new Double(this.mugValueFields[0].getText()).doubleValue();
            cmd.mug(this.bd,mugValues[0],this.recNumber);
            this.parent.repaint();
            this.parent.setRecNumber(parent.INITIAL);
            this.parent.setRecNumber2(parent.INITIAL);

        }

        else if(button == this.deleteButton){
            System.out.println(this.recNumber);
            cmd.delete(this.bd,this.recNumber);
            this.parent.repaint();
            this.parent.setRecNumber(parent.INITIAL);
            this.parent.setRecNumber2(parent.INITIAL);
        }

        else if(button == this.deleteAllButton){
            cmd.deleteAll(this.bd);
            this.parent.repaint();
            this.parent.setRecNumber(parent.INITIAL);
            this.parent.setRecNumber2(parent.INITIAL);
        }
        else if(button == this.intersectButton){
            cmd.intersect(this.bd,this.recNumber,this.recNumber2);
            this.parent.repaint();
            this.parent.setRecNumber(parent.INITIAL);
            this.parent.setRecNumber2(parent.INITIAL);
        }

        else if(button == this.clearButton){
            this.parent.setRecNumber(parent.INITIAL);
            this.parent.setRecNumber2(parent.INITIAL);

        }
    }
}