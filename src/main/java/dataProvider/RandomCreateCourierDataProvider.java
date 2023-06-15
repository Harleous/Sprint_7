package dataProvider;

import org.apache.commons.lang3.RandomStringUtils;
import pojoClasses.CreateCourier;

public class RandomCreateCourierDataProvider {
    public static CreateCourier getRandomCourierData(){
        CreateCourier createCourier = new CreateCourier();
        createCourier.setLogin(RandomStringUtils.randomAlphabetic(6));
        createCourier.setPassword(RandomStringUtils.randomAlphabetic(6));
        createCourier.setFirstName(RandomStringUtils.randomAlphabetic(6));
        return createCourier;
    }
}
