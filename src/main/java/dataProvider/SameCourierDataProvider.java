package dataProvider;

public class SameCourierDataProvider {
    public static pojoClasses.CreateCourier getFixedCourierData(){
        pojoClasses.CreateCourier createCourier = new pojoClasses.CreateCourier();
        createCourier.setLogin("Superman");
        createCourier.setPassword("Arm78");
        createCourier.setFirstName("Karen");
        return createCourier;
    }
}
