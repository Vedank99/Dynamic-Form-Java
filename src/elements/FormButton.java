package elements;

import java.awt.GridBagConstraints;
import javax.swing.*;
import java.io.Serializable;


public class FormButton extends BasicElement implements Serializable{
    
    String text;
    JButton button;
    public JPanel jPanel;
    
    public JPanel getJPanel(){
        return jPanel;
    }
    
    public FormButton(String s){
        super("","",true);
        this.text = s;
    }
    @Override
    public int createElementSwing(int i, JFrame frame, GridBagConstraints gbc){

        button = new JButton(this.text);
        button.setBounds(100,50*(i+1),100,25);

        frame.add(button);
        return 0;
    }

    @Override
    public String handleInput() {
        return null;
    }
    
    public String getText(){
        return text;
    }
    
    public JButton getJButton(){
        return button;
    }
    
}
