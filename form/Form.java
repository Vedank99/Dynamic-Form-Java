package form;

import elements.BasicElement;
import elements.FormButton;
import elements.RadioButton;
import elements.ShortAnswer;

import java.util.ArrayList;
import java.util.Scanner;

public class Form {
    String title; //Title cannot be changed
    final ArrayList<BasicElement> children; //Form elements
    String description;

    Form(String title,String description){
        this.title = title;
        children = new ArrayList<>();
        this.description = description;
    }
    Form(String title){
        this.title = title;
        children = new ArrayList<>();
    }



    public static void main(String[] args){

        String title;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter form title : ");
        title = scanner.nextLine();
        Form myForm = new Form(title);



        System.out.println("Choose form element");
        System.out.println("1) Short Answer");
        System.out.println("2) Radio Button");
        System.out.println("3) End Form");

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
                default:
                    formEnd = true;
                    element = new FormButton("Submit");
            }
            if(!formEnd)
                element.createElement();
            myForm.children.add(element);

        }

        SwingForm swingForm = new SwingForm(myForm);
        swingForm.createForm();
    }




}

