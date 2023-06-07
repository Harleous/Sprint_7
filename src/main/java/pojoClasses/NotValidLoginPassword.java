package pojoClasses;

public class NotValidLoginPassword {


        private String login;
        private String password;

        public NotValidLoginPassword
                (String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password = org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(6);        }

        public void setPassword(String password) {
            this.password  = password;
        }
        public static pojoClasses.NotValidLoginPassword fromCreateCourierData (CreateCourier createCourier){
            return new pojoClasses.NotValidLoginPassword(createCourier.getLogin(), createCourier.getPassword());
        }


    }

