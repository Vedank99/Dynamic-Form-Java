package elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormButton extends BasicElement {
    String text;
    public FormButton(String s){
        super("","",true);
        this.text = s;
    }
    public void createElementSwing(int i, JFrame frame,String s){

        JButton button = new JButton(this.text);
        FontMetrics fontMetrics = button.getFontMetrics(button.getFont());
        int width = fontMetrics.stringWidth(this.text);
        button.setBounds(100,50*(i+1),width,25);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.add(button);
    }
}
