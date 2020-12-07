/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class LongAnswer extends BasicElement{
    
    public String text;
    public int maxChars;
    public ArrayList<JTextArea>textAreas;
    int height;
    public boolean addMore;
    int y;
    int x;
    
    public boolean getAddMore(){
        return addMore;
    }
    
    
    public int getHeight(){
        return height;
    }
    
    public int getMaxChars(){
        return maxChars;
    }
    
    public ArrayList<JTextArea> gettextAreas(){
        return textAreas;
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
        
        for(int i = 0;i<textAreas.size();i++){
            int length = textAreas.get(i).getText().length();
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
            maxChars = 50;
        
        System.out.print("Enter the height of the text field ( 0 for default ): ");
        this.height = scanner.nextInt();
        if(height == 0)
            height = 4;

    }

    @Override
    public int createElementSwing(int i, JPanel jPanel, GridBagConstraints gbc){
        
        
        i = super.createElementSwing(i,jPanel,gbc);
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        
        textAreas = new ArrayList();
        
        JTextArea textArea = new JTextArea(this.text,height,25);
        textAreas.add(textArea);
        
        gbc.gridx = 1;
        gbc.gridy = i;
        gbc.gridheight = height;
        //gbc.gridwidth = ;
        gbc.fill = GridBagConstraints.VERTICAL;
        jPanel.add(textArea,gbc);
        
        y = i;
        x = 1;
        
        if(addMore){
            
            JButton addButton = new JButton("Add field");
            gbc.gridx = x + 1;
            
            jPanel.add(addButton,gbc);
            
            addButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    textAreas.add(new JTextArea(text,height,25));
                    x = x+1;
                    gbc.gridx = x+1;
                    gbc.gridy = y;
                    gbc.gridheight = height;
                    //gbc.gridwidth = 3;
                    jPanel.add(textAreas.get(textAreas.size()-1),gbc);   
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
            
            String ans = key + " : [ \n\t'";
            ans += textAreas.get(0).getText();
            if(addMore){
                
                for(int i = 1;i<textAreas.size();i++)
                    ans += "' ,\n\t'"+textAreas.get(i).getText();
            }
            ans += "'\n]";
            return ans;
        }
        return "";

    }
}
