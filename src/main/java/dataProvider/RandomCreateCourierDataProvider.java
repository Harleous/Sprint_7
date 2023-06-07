package dataProvider;

public class RandomCreateCourierDataProvider {
    public static pojoClasses.CreateCourier getRandomCourierData(){
        pojoClasses.CreateCourier createCourier = new pojoClasses.CreateCourier();
        createCourier.setLogin(org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(6));
        createCourier.setPassword(org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(6));
        createCourier.setFirstName(org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(6));
        return createCourier;
    }
}
