import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {
    // The Constants
    public static final double PI = 3.14;
    public static final int FOUR = 4;

    // The Regex

    public static final String REGEX_NAME="^[а-яА-ЯёЁa-zA-Z]{2,10}$";
    public static final String REGEX_SURNAME="^[а-яА-ЯёЁa-zA-Z-]{2,30}$";
    public static final String REGEX_PATRONYMIC="^[а-яА-ЯёЁa-zA-Z]{2,20}$";
    public static final String REGEX_HOME_NUMBER="^0[0-689]\\d{9}$";
    public static final String REGEX_PHONE_NUMBER="^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    public static final String REGEX_NICK="^[a-z0-9_-]{3,15}$";
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    Pattern name=Pattern.compile(REGEX_NAME);
    Pattern surname=Pattern.compile(REGEX_SURNAME);
    Pattern patronymic=Pattern.compile(REGEX_PATRONYMIC);
    Pattern homeNumber=Pattern.compile(REGEX_HOME_NUMBER);
    Pattern phoneNumber=Pattern.compile(REGEX_PHONE_NUMBER);
    Pattern nick=Pattern.compile(REGEX_NICK);


    Pattern email=Pattern.compile(REGEX_MAIL);



    // Constructor
    private User user;
    private View view;
    private Matcher matcher;

    public Controller(User user, View view) {
        this.user  = user;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        String surn=inputSurnameValueWithScanner(sc);
        matcher=surname.matcher(surn);
        if (!matcher.find()){
            view.printMessage(View.WRONG_SURNAME);
            surn=inputSurnameValueWithScanner(sc);
        }
        user.setSurname(surn);
        String name=inputNameValueWithScanner(sc);
        user.setName(name);
        view.printStrings(surn,name);
        String patron=inputPatronicNameValueWithScanner(sc);
        user.setPatronymic(patron);
        String nickname=inputNickValueWithScanner(sc);
        user.setNick(nickname);
        String extraInfo=inputExtraInfoValueWithScanner(sc);
        user.setExtraInfo(extraInfo);
        String homeNumber =inputHomeNumberValueWithScanner(sc);
        user.setHomeNumber(homeNumber);
        String phoneNumber=inputPhoneNumberValueWithScanner(sc);
        user.setPhoneNumber(phoneNumber);
        String secondPhone=inputSecondPhoneNumberValueWithScanner(sc);
        user.setSecondPhoneNumber(secondPhone);
        String mail=inputMailValueWithScanner(sc);
        user.setMail(mail);
        String skype=inputSkypeValueWithScanner(sc);
        user.setSkype(skype);


        view.printUserInfo(user);
//view.printmessage
    }


    public String inputSurnameValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_SURNAME_DATA);
        while( ! sc.hasNext()) {
                view.printMessage(View.WRONG_SURNAME);
            sc.next();

        }

        return sc.next();

    }
    public String inputNameValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_NAME_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_NAME);
            sc.next();
        }
        return sc.next();
    }
    public String inputPatronicNameValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_PATRONYMIC_NAME_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_PATRONYMIC_NAME);
            sc.next();
        }
        return sc.next();
    }
    public String inputExtraInfoValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_EXTRA_INFO_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_EXTRA_INFO_NAME);
            sc.next();
        }
        return sc.next();
    }
    public String inputHomeNumberValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_HOME_NUMBER_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_HOMENUMBER_NAME);
            sc.next();
        }
        return sc.next();
    }
    public String inputPhoneNumberValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_PHONE_NUMBER_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_PHONENUMBER_NAME);
            sc.next();
        }
        return sc.next();
    }
    public String inputSecondPhoneNumberValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_SECOND_PHONE_NUMBER_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_SECOND_PHONENUMBER_NAME);
            sc.next();
        }
        return sc.next();
    }

    public String inputMailValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_MAIL_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_MAIL_NAME);
            sc.next();
        }
        return sc.next();
    }
    public String inputSkypeValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_SKYPE_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_SKYPE_NAME);
            sc.next();
        }
        return sc.next();
    }
    public String inputNickValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_NICK_DATA);
        while( ! sc.hasNext()) {
            view.printMessage(View.WRONG_NICKNAME);
            sc.next();
        }
        return sc.next();
    }
}
