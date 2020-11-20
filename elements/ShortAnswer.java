package elements;

import javax.swing.*;
import java.util.Scanner;

public class ShortAnswer extends BasicElement {
    public String text;
    public int maxChars;

    public ShortAnswer(String key,String label,boolean required){

        super(key,label,required);
        maxChars = 10;
    }
    public ShortAnswer(String key,String label,boolean required,String text){
        super(key,label,required);
        this.text = text;
        maxChars = 10;
    }
    public ShortAnswer(String key,String label,boolean required,String text,int limit){

        super(key,label,required);
        this.text = text;
        maxChars = limit;
    }
    public void show(){
        System.out.print(text);
    }
    public String getText(){
        return text;
    }
    public void setText(String s){
        text = s;
    }
    public boolean validate(){ return text.length() <= maxChars; }

    public void createElement(){
        super.createElement();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter placeholder : ");
        this.text = scanner.nextLine();
        System.out.print("Enter maximum character limit ( 0 for default ) : ");
        this.maxChars = scanner.nextInt();


        if(maxChars == 0)
            maxChars = 10;

    }

    public void createElementSwing(int i, JFrame frame){

        JLabel label = new JLabel(this.label);
        label.setBounds(25,50*(i+1),200,30);
        JTextField textField = new JTextField(this.text);
        textField.setBounds(100,50*(i+1),200,30);
        frame.add(label);
        frame.add(textField);
    }
}
