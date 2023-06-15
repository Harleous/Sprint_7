package dataProvider;

import pojoClasses.CreateCourier;

public class SameCourierDataProvider {
    public static CreateCourier getFixedCourierData(){
        CreateCourier createCourier = new CreateCourier();
        createCourier.setLogin("Superman");
        createCourier.setPassword("Arm78");
        createCourier.setFirstName("Karen");
        return createCourier;
    }
}
