/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.GridBagConstraints;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author admin
 */
public class LongAnswer extends BasicElement{
    
    public String text;
    public int maxChars;
    public JTextArea textArea;
    int height;
    
    
    public int getHeight(){
        return height;
    }
    
    public int getMaxChars(){
        return maxChars;
    }
    
    public JTextArea gettextArea(){
        return textArea;
    }
    
    public LongAnswer(String key,String label,boolean required){

        super(key,label,required);
        maxChars = 50;
    }
    public LongAnswer(String key,String label,boolean required,String text){
        super(key,label,required);
        this.text = text;
        maxChars = 50;
    }
    public LongAnswer(String key,String label,boolean required,String text,int limit){

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
    public boolean validate(){
        int length = textArea.getText().length();
        if(required && length == 0)
            return false;
        return length <= maxChars;
    }

    @Override
    public void createElement(){
        
        super.createElement();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter placeholder : ");
        this.text = scanner.nextLine();
        System.out.print("Enter maximum character limit ( 0 for default ) : ");
        this.maxChars = scanner.nextInt();

        if(maxChars == 0)
            maxChars = 50;
        
        System.out.print("Enter the height of the text field ( 0 for default ): ");
        this.height = scanner.nextInt();
        if(height == 0)
            height = 4;

    }

    @Override
    public int createElementSwing(int i, JFrame frame, GridBagConstraints gbc){
        
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel jLabel = new JLabel(this.label);
        textArea = new JTextArea(this.text,height,25);
        
        gbc.gridx = 0;
        gbc.gridy = i+1;
        
        frame.add(jLabel,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = i;
        gbc.gridheight = height;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        frame.add(textArea,gbc);
        return gbc.gridy + gbc.gridheight;
    }

    @Override
    public String handleInput(){

        if(validate())
            return key + " : "+ textArea.getText();
        return "";

    }
}
