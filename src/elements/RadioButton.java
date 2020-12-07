package elements;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.*;
import java.util.Scanner;
import java.io.Serializable;

public class RadioButton extends BasicElement implements Serializable{
    public int numOfOptions;
    public JRadioButton[] options;
    ButtonGroup buttonGroup;
    public JPanel jPanel;
    
    public JPanel getJPanel(){
        return jPanel;
    }
    
    public int getNumOfOptions(){
        return numOfOptions;
    }
    
    public JRadioButton[] getOptions(){
        return options;
    }
    
    public ButtonGroup getButtonGroup(){
        return buttonGroup;
    }
    
    public RadioButton(String key, String label, boolean required) {
        super(key, label, required);
    }
    public RadioButton(String key, String label, boolean required,int numOfOptions) {
        super(key, label, required);
        this.numOfOptions = numOfOptions;
        options = new JRadioButton[numOfOptions];
    }
    @Override
    public void createElement() {
        
        super.createElement();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of options : ");
        this.numOfOptions = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.println("Enter the options : ");
        options = new JRadioButton[numOfOptions];
        
        for(int i = 0;i<numOfOptions;i++) {
            
            String option = scanner.nextLine();
            options[i] = new JRadioButton(option);
            
        }

    }

    @Override
    public int createElementSwing(int i, JPanel jPanel, GridBagConstraints gbc){
        
        i = super.createElementSwing(i, jPanel, gbc);
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridy = i;
        buttonGroup = new ButtonGroup();
        
        for(int j = 0;j<this.numOfOptions;j++){
            
            gbc.gridx = j+1;
            buttonGroup.add(options[j]);
            jPanel.add(options[j],gbc);
            
        }
        
        return gbc.gridy + gbc.gridheight;
    }

    @Override
    public String handleInput(){

        for (int i = 0;i<numOfOptions;i++)

            if (options[i].isSelected())
                return key + " : "+ options[i].getText();
        
        return "";
    }

}
