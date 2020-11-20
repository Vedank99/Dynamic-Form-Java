package form;
import elements.*;
import javax.swing.*;

public class SwingForm {
    Form myForm;

    SwingForm(Form form){

        myForm = form;
    }

    public void createForm(){
        //Creates form
        JFrame frame = new JFrame(myForm.title);

        for(int i = 0;i<myForm.children.size();i++)
            myForm.children.get(i).createElementSwing(i,frame);

        frame.setSize(750,1000);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    /*handleInput(input){
        //handles input
        JsonParser.parse(input);
        JsonParser.save();
    }*/

    public static void main(String [] args){

    }
}
