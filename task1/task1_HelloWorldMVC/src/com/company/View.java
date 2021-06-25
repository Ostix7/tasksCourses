package com.company;

public class View {
    // Text's constants
    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String INPUT_HELLO_DATA = "Input first string value = ";
    public static final String INPUT_WORD_DATA = "Input second string value = ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String WRONG_INPUT_HELLO_DATA = "Wrong input! Repeat please! ";
    public static final String WRONG_INPUT_WORD_DATA = "Wrong input! Repeat please! ";

    public static final String OUR_INT = "INT value = ";
    public static final String OUR_String = "Phrase is  = ";
    public static final String FINAL = "=======End of input ======= ";



    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndInt(String message, int value){
        System.out.println(message + value);
    }
    public void printMessageAndString(String message, String value,String value2){
        System.out.println(message + value+" "+value2);
    }
    public void printFinishMessage(String message){
        System.out.println(message);
    }

}