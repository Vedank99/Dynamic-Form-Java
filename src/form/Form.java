package form;

import elements.BasicElement;
import java.io.Serializable;
import java.util.ArrayList;

public class Form implements Serializable{
    
    String title; //Title of form
    final ArrayList<BasicElement> children; //Form elements
    String description; //Description of form
    // RGB values for form backgroung ( later given by user ).
    int r;
    int g;
    int b;

    Form(String title,String description){
        this.title = title;
        children = new ArrayList<>();
        this.description = description;
    }
    Form(String title){
        this.title = title;
        children = new ArrayList<>();
    }
    
    public ArrayList<BasicElement> getChildren(){
        return children;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
}

