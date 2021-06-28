import java.util.ArrayList;

public class View {
    // Text's constants
    public static final String INPUT_INT_DATA = "========Type the number to guess======";
    public static final String INPUT_DOUBLE_DATA = "Input DOUBLE value = ";
    public static final String INPUT_STRING_DATA = "Input STRING value = ";
    public static final String WRONG_INPUT_DATA =
            "Wrong input! Repeat please! ";
    public static final String HIGH_VALUE = "Your number is too high, try lower";
    public static final String LOW_VALUE = "Your number is too low, try higher";

    public static final String OUR_INT = "INT value = ";
    public static final String OUR_DOUBLE = "DOUBLE value = ";
    public static final String OUR_STRING = "STRING value = ";
    public static final String VICTORY = "You have guessed!! YAHOOOO";
    public static final String WRONG_BOUND ="Wrong Bound...Type the num from 0 to 100" ;

    public void printMessage(String message){
        System.out.println(message);
    }
    public void printMessageMinMax(String message,int min,int max){
        System.out.println("========Type the number to guess from  "+min+" to "+max+"=========");
    }
    public void printArrayList(ArrayList<Integer> a){
        System.out.print("User attemps:[ ");
        for (Integer integer : a) System.out.print(integer+" ");
        System.out.print("]");


    }

}