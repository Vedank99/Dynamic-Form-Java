package elements;

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

    public abstract int createElementSwing(int i, JFrame frame,GridBagConstraints gbc);
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
