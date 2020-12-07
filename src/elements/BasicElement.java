package elements;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.io.Serializable;
import javax.swing.*;
import java.util.Scanner;

public abstract class BasicElement implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public String key;
    public boolean required;
    public String label;

    public BasicElement(String key,String label,boolean required){
        this.key = key;
        this.required = required;
        this.label = label;
    }

    public void createElement(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Key : ");
        this.key = scanner.nextLine();
        System.out.print("Enter label : ");
        this.label = scanner.nextLine();
        System.out.print("Enter if required (true or false) : ");
        this.required = scanner.nextBoolean();
        if(this.required)
            this.label += "(*)";
        
    }

    public int createElementSwing(int i, JPanel jPanel, GridBagConstraints gbc){
        
        JLabel jLabel = new JLabel(this.label);
        jLabel.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridheight =1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;
        jPanel.add(jLabel,gbc);
        return i;
        
    };
    public abstract String handleInput();
    
    public String getKey(){
        return key;
    }
    public boolean getRequired(){
        return required;
    }
    public String getLabel(){
        return label;
    }
    
}
