package form;

import elements.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*
    This class created the form.
    It asks the form title ,description and elements and stores them into a Form object.
    The Form object is Serialized and stored.
*/
public class CreateForm {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        String title;
        System.out.print("Enter form title : ");
        title = scanner.nextLine();
        
        String description;
        System.out.print("Enter form description : ");
        description = scanner.nextLine();
        
        Form myForm = new Form(title,description);
        System.out.println("Add color to the form? (true or false)");
        boolean colorStatus = scanner.nextBoolean();
        if(colorStatus){
            System.out.println("Enter RGB channel values for form background (0-255)");
            myForm.r = scanner.nextInt();
            myForm.g = scanner.nextInt();
            myForm.b = scanner.nextInt();
        }else{
            myForm.r = 238;
            myForm.g = 238;
            myForm.b = 238;
        }

        System.out.println("Choose form element");
        System.out.println("1) Short Answer");
        System.out.println("2) Radio Button");
        System.out.println("3) Check Box");
        System.out.println("4) Drop Down");
        System.out.println("5) Long Answer");
        System.out.println("6) End Form");

        boolean formEnd = false;
        int elementNumber;
        while(!formEnd) {

            System.out.println("Enter the number for element");
            elementNumber = scanner.nextInt();
            BasicElement element;

            switch (elementNumber) {
                case 1:
                    element = new ShortAnswer("","",false);
                    break;
                case 2:
                    element = new RadioButton("","",false);
                    break;
                case 3:
                    element = new CheckBox("","",false);
                    break;
                case 4:
                    element = new DropDown("","",false);
                    break;
                case 5:
                    element = new LongAnswer("","",false);
                    break;
                default:
                    formEnd = true;
                    element = null;
            }
            
            if(!formEnd) {
                element.createElement();
                myForm.children.add(element);
            }

        }
        
         String filename = "examples/"+title + ".ser";
         
         try{    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(myForm); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        }catch(IOException ex){ 
            System.out.println("IOException is caught"); 
        }
    }
}
