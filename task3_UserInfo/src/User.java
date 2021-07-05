import java.util.Objects;

public class User {
    private String surname;
    private String name;
    private String patronymic;
    private String nick;
    private String extraInfo;
    private String homeNumber;
    private String phoneNumber;
    private String secondPhoneNumber;
    private String mail;
    private String skype;

    public User(){

    }
    public User(String surname, String name, String patronymic, String nick, String extraInfo,
                String homeNumber, String phoneNumber, String secondPhoneNumber, String mail, String skype) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.nick = nick;
        this.extraInfo = extraInfo;
        this.homeNumber = homeNumber;
        this.phoneNumber = phoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.mail = mail;
        this.skype = skype;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getNick() {
        return nick;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return surname.equals(user.surname) &&
                Objects.equals(name, user.name) &&
                Objects.equals(patronymic, user.patronymic) &&
                nick.equals(user.nick) &&
                Objects.equals(extraInfo, user.extraInfo) &&
                Objects.equals(homeNumber, user.homeNumber) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(secondPhoneNumber, user.secondPhoneNumber) &&
                Objects.equals(mail, user.mail) &&
                Objects.equals(skype, user.skype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, nick, extraInfo, homeNumber, phoneNumber, secondPhoneNumber, mail, skype);
    }

    public String getMail() {
        return mail;
    }

    public String getSkype() {
        return skype;
    }

    public void setSurname(String surname) { this.surname=surname; }
    public void setNick(String nick) {
        this.nick=nick;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    /***
     *
     * @return to String for User
     */
    @Override
    public String toString() {
        return "User with {" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", nick='" + nick + '\'' +
                ", extraInfo='" + extraInfo + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", secondPhoneNumber='" + secondPhoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                ", skype='" + skype + '\'' +
                '}';
    }
}
