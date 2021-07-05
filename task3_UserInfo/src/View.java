public class View {
    // INPUT VALUES
    public static final String INPUT_NAME_DATA = "Input name value";
    public static final String INPUT_SURNAME_DATA = "Input Surname value = ";
    public static final String INPUT_NICK_DATA = "Input nick value = ";
    public static final String INPUT_PATRONYMIC_NAME_DATA ="Input patronymic value" ;
    public static final String INPUT_EXTRA_INFO_DATA ="Input additional info"  ;
    public static final String INPUT_HOME_NUMBER_DATA ="Input yor home number" ;
    public static final String INPUT_PHONE_NUMBER_DATA ="Input your phone number" ;
    public static final String INPUT_SECOND_PHONE_NUMBER_DATA ="Input your second phone number";
    public static final String INPUT_MAIL_DATA ="Input your mail" ;
    public static final String INPUT_SKYPE_DATA ="Input your skype" ;

    // WRONG INPUT VALUES
    public static final String WRONG_SURNAME ="Wrong surname input! Repeat please!";
    public static final String WRONG_NICKNAME="Wrong nickname input! Repeat please!";
    public static final String WRONG_NAME ="Wrong name input! Repeat please!" ;
    public static final String WRONG_PATRONYMIC_NAME ="Wrong patronymic input! Repeat please!" ;
    public static final String WRONG_EXTRA_INFO_NAME = "Wrong extra info value! Repeat please!";
    public static final String WRONG_HOMENUMBER_NAME ="Wrong value! Repeat please!" ;
    public static final String WRONG_PHONENUMBER_NAME = "Wrong phone number value! Repeat please!";
    public static final String WRONG_SECOND_PHONENUMBER_NAME = "Wrong second phone number value! Repeat please!";
    public static final String WRONG_MAIL_NAME = "Wrong mail value! Repeat please!";
    public static final String WRONG_SKYPE_NAME ="Wrong skype value! Repeat please!" ;

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndInt(String message, int value){
        System.out.println(message + value);
    }

    /***
     * task 4 . output surname+space+first letter of the name + dot
     * @param surnmame surname of the User
     * @param name name of the User
     */
    public void printStrings(String surnmame, String name){
        char[] charName = name.toCharArray();
        //System.out.println("task 4: "+surnmame+" "+charName[0]+".");
    }
    public void printUserInfo(User user) {
 System.out.println(user.toString());     }
}
