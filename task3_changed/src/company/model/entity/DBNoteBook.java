package company.model.entity;

public enum DBNoteBook {
    NOTE_ONE("Taras","taras123"),
    NOTE_TWO("Bob","bob131313"),
    NOTE_THREE("Michael","jordan13");



    private final String firstName;
    private final String login;

    DBNoteBook(String firstName, String login) {
        this.firstName = firstName;
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }

    public boolean checkLogin(String loginData){
        for(DBNoteBook note: DBNoteBook.values()){
            if(note.getLogin().equals(loginData)){return true;}
        }
        return false;
    }
}
