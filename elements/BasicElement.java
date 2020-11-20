package elements;

import javax.swing.*;
import java.util.Scanner;

public abstract class BasicElement {
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

    public void createElementSwing(int i, JFrame frame){
    }

}
