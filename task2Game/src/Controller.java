import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static javax.swing.UIManager.getInt;

public class Controller {
    private Model model;
    private View view;
    private ArrayList<Integer> attemps = new ArrayList<Integer>();


    // Constants

    // REGEX

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    //Work method
    public void processUser() {
        Scanner sc = new Scanner(System.in);
         int min=0;
         int max=100;
        while (true) {
            int userInput = inputIntValueWithScanner(sc,min,max);
            if ((userInput >= 100) || (userInput <= 0)) {
                view.printMessage(View.WRONG_BOUND);
                continue;
            }
            if (!attemps.contains(userInput)) {
                attemps.add(userInput);
            }
            if (model.checkIfTrueNumber(userInput) == 0) {
                view.printMessage(View.VICTORY);

                view.printArrayList(attemps);
                break;
            } else if ((model.checkIfTrueNumber(userInput) > 0)&&(userInput<max)) {
                view.printMessage(View.HIGH_VALUE);
                max=userInput;

            }
            else if ((model.checkIfTrueNumber(userInput) < 0)&&(userInput>min)) {
                view.printMessage(View.LOW_VALUE);
                min=userInput;

            }

        }

    }


    // The Utility methods
    private String inputStringValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_STRING_DATA);
        //while ( ! sc.hasNextLine()){}
        return sc.next();
    }

    private double inputDoubleValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_DOUBLE_DATA);
        while (!sc.hasNextDouble()) {
            view.printMessage(View.WRONG_INPUT_DATA + View.INPUT_DOUBLE_DATA);
            sc.next();
        }
        return sc.nextDouble();
    }

    public int inputIntValueWithScanner(Scanner sc,int min, int max) {
        view.printMessageMinMax(View.INPUT_INT_DATA,min,max);
        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_DATA + View.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

   /* public int inputIntValueWithScannerAndDiapason(Scanner sc) {
        int res=0;
        view.printMessage(view.INPUT_INT_DATA +
                model.getMinBarrier() + model.getMaxBarrier());

        while( true ) {
            // check int - value
            while (!sc.hasNextInt()) {
                view.printMessage(view.WRONG_INPUT_DATA
                        + view.INPUT_INT_DATA);
                sc.next();
            }
            // check value in diapason
            if ((res = sc.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printMessage(view.WRONG_RANGE_DATA
                        + View.INPUT_INT_DATA);
                continue ;
            }
            break;
        }
        return res;
    }*/


}