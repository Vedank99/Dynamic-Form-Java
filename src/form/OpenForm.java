package form;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    This class opens the form.
    It asks the form title as input.
    The serialized form object is deserialized and stored in a new Form object.
    Then using GridBagLayout, the form is created with Java Swing.
*/

public class OpenForm {
    
    public static void main(String [] args){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the form title to open");
        String title;
        title = scanner.nextLine();
       
        String filename = "examples/"+title+".ser";
        
        try { 
  
            Form myForm;
            try ( // Reading the object from a file
                    FileInputStream file = new FileInputStream 
                                                 (filename)) {
                ObjectInputStream in = new ObjectInputStream
                                                 (file);
                // Method for deserialization of object
                myForm = (Form)in.readObject();
                in.close();
            } 
            
            JFrame frame = new JFrame(myForm.title);
            GridBagLayout layout = new GridBagLayout();
            GridBagConstraints gbc = new GridBagConstraints();
            
            JPanel jPanel = new JPanel();
            Color c = new Color(myForm.r,myForm.g,myForm.b);
            jPanel.setLayout(layout);
            jPanel.setBackground(c);
            gbc.insets = new Insets(7,7,7,7);
            
        
            JLabel titleLabel = new JLabel(myForm.title);
            titleLabel.setFont(new Font("Serif", Font.BOLD, 15));
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 5;
            gbc.gridheight = 1;
            gbc.fill = GridBagConstraints.WEST;
            
            jPanel.add(titleLabel,gbc);
            
            JLabel desLabel = new JLabel(myForm.description);
            desLabel.setFont(new Font("Serif", Font.PLAIN, 10));
            
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 5;
            gbc.gridheight = 5;
            gbc.fill = GridBagConstraints.WEST;
            jPanel.add(desLabel,gbc);
            
            
            
        int size = 7;    
        for(int i = 0;i<myForm.children.size();i++)
            size = myForm.children.get(i).createElementSwing(size,jPanel,gbc);
            
        JButton submit = new JButton("Submit");

        
        gbc.gridx = 1;
        gbc.gridy = size+1;
        jPanel.add(submit,gbc);
        
        JLabel res = new JLabel("");
        res.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridx = 1;
        gbc.gridy = size+2;
        gbc.gridwidth = 5;
        jPanel.add(res,gbc);
        
        
        
        
        submit.addActionListener((ActionEvent e) -> {
            String output = "{\n";
            boolean success = true;
            
            for(int i = 0;i<myForm.children.size();i++){
                
                String ans = myForm.children.get(i).handleInput();
                if(myForm.children.get(i).required && ans.length() == 0){
                    
                    success = false;
                    break;
                    
                }
                
                output = output + "\t"+ans + ",\n";
                
                
            }
            if(success){
                    output += "}\n";
                    try{
                        String fname= "examples/" + title + ".txt";
                        FileWriter fw = new FileWriter(fname,true); //the true will append the new data
                        fw.write(output);//appends the string to the file
                        fw.close();
                    
                        res.setText("Your submission had been added to "+fname);
                    
                    }catch(IOException ioe){
                        System.err.println("IOException: " + ioe.getMessage());
                    }
             }else
                 res.setText("You cannot leave the mandatory fields blank");
            
         });
            
            JScrollPane jScrollPane = new JScrollPane(jPanel);
            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            
            frame.getContentPane().add(jScrollPane);
            
            
            
            frame.pack();
            frame.setSize(1000,1000);
            //frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.YELLOW);
            
        } 
  
        catch (IOException ex) { 
            System.out.println("Some error occcured! Check the file name"); 
        } 
  
        catch (ClassNotFoundException ex) { 
            System.out.println("Some error occcured! Check if the file exists."); 
        }
        
        
    }
}
