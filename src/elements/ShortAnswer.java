package elements;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

public class ShortAnswer extends BasicElement implements Serializable{
    
    public String text;
    public int maxChars;
    ArrayList<JTextField>textFields;
    public JPanel jPanel;
    public boolean addMore;
    int y;
    int x;
    
    public boolean getAddMore(){
        return addMore;
    }
    
    public JPanel getJPanel(){
        return jPanel;
    }
    
    public int getMaxChars(){
        return maxChars;
    }
    
    public ArrayList<JTextField> getTextFields(){
        return textFields;
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
            
        for(int i = 0;i<textFields.size();i++){
            int length = textFields.get(i).getText().length();
            if(required && length == 0)
                return false;
        }
        return true;
    }

    @Override
    public void createElement(){
        
        super.createElement();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter placeholder : ");
        this.text = scanner.nextLine();
        System.out.print("Enter maximum character limit ( 0 for default ) : ");
        this.maxChars = scanner.nextInt();
        
        System.out.print("More than one required ? ( true or false )");
        this.addMore = scanner.nextBoolean();

        if(maxChars == 0)
            maxChars = 10;

    }

    @Override
    public int createElementSwing(int i, JPanel jPanel, GridBagConstraints gbc){
        
        i = super.createElementSwing(i,jPanel,gbc);
        textFields = new ArrayList();
        JTextField textField = new JTextField(this.text,15);
        
        textFields.add(textField);
        
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = i;
        jPanel.add(textField,gbc);
        
        y = i;
        x = 2;
        
        if(addMore){
            
            JButton addButton = new JButton("Add field");
            gbc.gridx = x;
            
            jPanel.add(addButton,gbc);
            
            addButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    textFields.add(new JTextField("", 15));
                    gbc.gridy = y;
                    x = x+1;
                    gbc.gridx = x;
                    gbc.gridheight = 1;
                    gbc.gridwidth = 1;
                    jPanel.add(textFields.get(textFields.size()-1),gbc);   
                    jPanel.revalidate();
                    jPanel.repaint();
                    
                }
            });
            
        }
        
        return gbc.gridy + gbc.gridheight;
        
    }

    @Override
    public String handleInput(){

        if(validate()){
            String ans = key + " : [ ";
            ans += textFields.get(0).getText();
            if(addMore){
                
                for(int i = 1;i<textFields.size();i++)
                    ans += ", "+textFields.get(i).getText();
            }
            ans += "]";
            return ans;
        }
        return "";

    }
    
}
