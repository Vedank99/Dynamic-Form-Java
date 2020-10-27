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

        for(int i = 0;i<myForm.children.size();i++){
            if(myForm.children.get(i) instanceof ShortAnswer){
                ShortAnswer shortAnswer = ((ShortAnswer) myForm.children.get(i));
                JLabel label = new JLabel(shortAnswer.label);
                label.setBounds(25,50*(i+1),200,30);
                JTextField textField = new JTextField(shortAnswer.text);
                textField.setBounds(100,50*(i+1),200,30);
                frame.add(label);
                frame.add(textField);
            }else
                break;
        }
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
