package elements;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class RadioButton extends BasicElement {
    public int numOfOptions;
    public String[] options;

    public RadioButton(String key, String label, boolean required) {
        super(key, label, required);
    }
    public RadioButton(String key, String label, boolean required,int numOfOptions) {
        super(key, label, required);
        this.numOfOptions = numOfOptions;
        options = new String[numOfOptions];
    }
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

    public void createElementSwing(int i, JFrame frame){

        JLabel label = new JLabel(this.label);
        label.setBounds(25,50*(i+1),200,30);
        ButtonGroup buttonGroup = new ButtonGroup();
        int x = 100;
        for(int j = 0;j<this.numOfOptions;j++){
            JRadioButton radioButton = new JRadioButton(this.options[j]);
            //FontMetrics fontMetrics = radioButton.getFontMetrics(radioButton.getFont());
            int width = this.options[j].length();
                    //fontMetrics.stringWidth(this.options[j]);
            System.out.println(width);
            radioButton.setBounds(x+5,50*(i+1),width*9,25);
            x += width;
            buttonGroup.add(radioButton);
            frame.add(radioButton);
        }
        frame.add(label);
    }

}
