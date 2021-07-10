package company.controller;


import company.view.View;

import java.util.Scanner;


import static company.controller.RegexContainer.REGEX_LOGIN;
import static company.controller.RegexContainer.REGEX_NAME_LAT;
import static company.controller.RegexContainer.REGEX_NAME_UKR;
import static company.controller.RegexContainer.REGEX_NAME_RUS;
import static company.view.TextConstant.FIRST_NAME;
import static company.view.TextConstant.LOGIN_DATA;

/**
 * Created by student on 26.09.2017.
 */
public class InputNoteNoteBook {
    private View view;
    private Scanner sc;

    private String firstName;
    private String login;

    public InputNoteNoteBook(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
    }

       public void inputNote() {
        UtilityController utilityController =
                new UtilityController(sc, view);
        String str="";
           if (String.valueOf(View.bundle.getLocale ()).equals ("ua")) {
               str = REGEX_NAME_UKR;
           }else if (String.valueOf(View.bundle.getLocale ()).equals ("ru")) {
               str = REGEX_NAME_RUS;
           }else
               str = REGEX_NAME_LAT;

        this.firstName =
                utilityController.inputStringValueWithScanner
                        (FIRST_NAME, str);
        this.login =
                utilityController.inputStringValueWithScanner
                        (LOGIN_DATA, REGEX_LOGIN);
    }
    public void inputLogin(){
        UtilityController utilityController =
                new UtilityController(sc, view);
        this.login =
                utilityController.inputStringValueWithScanner
                        (LOGIN_DATA, REGEX_LOGIN);
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLoginData() {
        return login;
    }
}
