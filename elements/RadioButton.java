package elements;

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
        for(int i = 0;i<numOfOptions;i++) {
            String option = scanner.nextLine();
            options[i] = option;
        }
    }
}
