package dataProvider;

public class NoLoginCourierDataProvider {
    public static pojoClasses.CreateCourier getNoLoginCourierData(){
        pojoClasses.CreateCourier createCourier = new pojoClasses.CreateCourier();
        createCourier.setPassword(org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(6));
        createCourier.setFirstName(org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(6));
        return createCourier;
    }
}
