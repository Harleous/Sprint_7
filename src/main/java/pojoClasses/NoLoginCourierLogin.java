package pojoClasses;

public class NoLoginCourierLogin  {
    private String login;
    private String password;

    public  NoLoginCourierLogin
(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return null;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public static NoLoginCourierLogin fromCreateCourierData (CreateCourier createCourier){
        return new pojoClasses.NoLoginCourierLogin(createCourier.getLogin(), createCourier.getPassword());
    }


}


