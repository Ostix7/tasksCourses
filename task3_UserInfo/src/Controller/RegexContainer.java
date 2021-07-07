package Controller;

public class RegexContainer {
    public static final String REGEX_NAME="^[а-яА-ЯёЁa-zA-Z]{2,10}$";
    public static final String REGEX_SURNAME="^[а-яА-ЯёЁa-zA-Z-]{2,30}$";
    public static final String REGEX_PATRONYMIC="^[а-яА-ЯёЁa-zA-Z]{2,20}$";
    public static final String REGEX_HOME_NUMBER="^0[0-689]\\d{9}$";
    public static final String REGEX_PHONE_NUMBER="^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    public static final String REGEX_NICK="^[a-z0-9_-]{3,15}$";
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
}
