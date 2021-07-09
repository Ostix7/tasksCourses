package company.model.entity;

public class LoginException extends Exception {
    private String loginData;

    public String getLoginData() {
        return loginData;
    }

    public LoginException(String message, String loginData) {
        super(message);
        this.loginData = loginData;
    }
}
