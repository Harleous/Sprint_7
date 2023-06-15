package pojoClasses;

import org.apache.commons.lang3.RandomStringUtils;

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
            return password = RandomStringUtils.randomAlphabetic(6);        }

        public void setPassword(String password) {
            this.password  = password;
        }
        public static NotValidLoginPassword fromCreateCourierData (CreateCourier createCourier){
            return new NotValidLoginPassword(createCourier.getLogin(), createCourier.getPassword());
        }


    }

