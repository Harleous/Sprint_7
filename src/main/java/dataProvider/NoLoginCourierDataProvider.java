package dataProvider;

import org.apache.commons.lang3.RandomStringUtils;
import pojoClasses.CreateCourier;

public class NoLoginCourierDataProvider {
    public static CreateCourier getNoLoginCourierData(){
        CreateCourier createCourier = new CreateCourier();
        createCourier.setPassword(RandomStringUtils.randomAlphabetic(6));
        createCourier.setFirstName(RandomStringUtils.randomAlphabetic(6));
        return createCourier;
    }
}
