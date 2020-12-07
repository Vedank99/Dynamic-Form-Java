/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class DropDown extends BasicElement{
    
    public int numOfOptions;
    public String[] options;
    JComboBox jComboBox;
    public JPanel jPanel;
    
    public JPanel getJPanel(){
        return jPanel;
    }
    
    public int getNumOfOptions(){
        return numOfOptions;
    }
    
    public String[] getOptions(){
        return options;
    }
    
    public JComboBox getJComboBox(){
        return jComboBox;
    }
    
    public DropDown(String key, String label, boolean required) {
        super(key, label, required);
    }
    public DropDown(String key, String label, boolean required,int numOfOptions) {
        super(key, label, required);
        this.numOfOptions = numOfOptions;
        options = new String[numOfOptions];
    }
    @Override
    public void createElement() {
        
        super.createElement();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of options : ");
        this.numOfOptions = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.println("Enter the options : ");
        options = new String[numOfOptions];
        
        for(int i = 0;i<numOfOptions;i++) {
            
            String option = scanner.nextLine();
            options[i] = option;
            
        }

    }

    @Override
    public int createElementSwing(int i, JPanel jPanel, GridBagConstraints gbc){

        i = super.createElementSwing(i, jPanel, gbc);
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        
        jComboBox = new JComboBox(options);
        
        gbc.gridx = 1;
        gbc.gridy = i;
        jPanel.add(jComboBox,gbc);
        
        return gbc.gridy + gbc.gridheight;
        
    }

    @Override
    public String handleInput(){
        return key + " : "+jComboBox.getSelectedItem().toString();
    }
    
}
