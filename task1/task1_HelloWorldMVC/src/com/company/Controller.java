package com.company;

import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {
    // The Constants
    public static final double PI = 3.14;
    public static final int FOUR = 4;

    // The Regex
    // «nick@mail.com»
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    // «http://www.my-site.com»
    public static final String REGEX_URL = "^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$";
    // «+38(044)555-55-55»
    public static final String REGEX_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";

    // Constructor
    private Model model;
    private View view;
    private String hello;
    private String world;
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setValue(inputStringHelloValueWithScanner(sc));
        model.validateHello(model.getValue());
        String first=model.getValue();
        model.setValue(inputStringWorldValueWithScanner(sc));
        model.validateWorld(model.getValue());
        String second=model.getValue();
        view.printMessageAndString(View.OUR_String, first,second);
        view.printMessage(View.FINAL);
    }

    // The Utility methods
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_INT_DATA);
        while( ! sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + View.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }
    public String inputStringHelloValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_HELLO_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_INPUT_HELLO_DATA );
             hello=sc.next();
        }
        return sc.next();
    }
    public String inputStringWorldValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_WORD_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_INPUT_WORD_DATA );
            hello=sc.next();
        }
        return sc.next();
    }
}