/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.util.Scanner;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class CheckBox extends BasicElement{
    
    public int numOfOptions;
    public JCheckBox[] options;
    public JPanel jPanel;
    
    public JPanel getJPanel(){
        return jPanel;
    }
    
    public int getNumOfOptions(){
        return numOfOptions;
    }
    
    
    public JCheckBox[] getOptions(){
        return options;
    }
    
    public CheckBox(String key, String label, boolean required) {
        super(key, label, required);
    }
    public CheckBox(String key, String label, boolean required,int numOfOptions) {
        super(key, label, required);
        this.numOfOptions = numOfOptions;
        options = new JCheckBox[numOfOptions];
    }
    @Override
    public void createElement() {
        
        super.createElement();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of options : ");
        this.numOfOptions = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.println("Enter the options : ");
        options = new JCheckBox[numOfOptions];
        
        for(int i = 0;i<numOfOptions;i++) {
            
            String option = scanner.nextLine();
            options[i] = new JCheckBox(option);
            
        }

    }

    @Override
    public int createElementSwing(int i, JPanel jPanel, GridBagConstraints gbc){

        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        
        i = super.createElementSwing(i, jPanel, gbc);
        
        gbc.gridy = i;
        
        
        for(int j = 0;j<this.numOfOptions;j++){
            gbc.gridx = j+1;
            jPanel.add(options[j],gbc);
        }
        return gbc.gridy + gbc.gridheight;
    }

    @Override
    public String handleInput(){

       String ans = key+" : [ ";
       
       for(int i = 0; i<numOfOptions;i++){
           
           if(options[i].isSelected())
               ans += options[i].getText() + " , ";
           
       }
       
       return ans + " ]";
    }
    
    
}
