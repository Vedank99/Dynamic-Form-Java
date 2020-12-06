package elements;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.*;
import java.util.Scanner;
import java.io.Serializable;

public class ShortAnswer extends BasicElement implements Serializable{
    
    public String text;
    public int maxChars;
    public JTextField textField;
    public JPanel jPanel;
    
    public JPanel getJPanel(){
        return jPanel;
    }
    
    public int getMaxChars(){
        return maxChars;
    }
    
    public JTextField getTextField(){
        return textField;
    }
    
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
    public boolean validate(){
        int length = textField.getText().length();
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
            maxChars = 10;

    }

    @Override
    public int createElementSwing(int i, JFrame frame, GridBagConstraints gbc){
        
        /*jPanel = new JPanel();
        
        FlowLayout fLayout = new FlowLayout();
        fLayout.setHgap(25);
        jPanel.setLayout(fLayout);*/
        
        JLabel jLabel = new JLabel(this.label);

        textField = new JTextField(this.text,15);
        
        //jLabel.setVisible(true);
        
        //jPanel.add(jLabel);
        gbc.gridheight =1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;
        frame.add(jLabel,gbc);
        gbc.gridx = 1;
        frame.add(textField,gbc);
        
        return gbc.gridy + gbc.gridheight;
        
    }

    @Override
    public String handleInput(){

        if(validate())
            return key + " : "+ textField.getText();
        return "";

    }
    
}
