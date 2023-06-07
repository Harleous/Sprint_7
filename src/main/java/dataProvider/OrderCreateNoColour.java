package dataProvider;

public class OrderCreateNoColour {
    public static pojoClasses.OrderCreate getOrderCreateNoColourData(){
        pojoClasses.OrderCreate orderCreate = new pojoClasses.OrderCreate();
        orderCreate.setFirstName(org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(6));
        orderCreate.setLastName(org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(6));
        orderCreate.setMetroStation(4);
        orderCreate.setPhone(org.apache.commons.lang3.RandomStringUtils.randomNumeric(12));
        orderCreate.setRentTime(4);
        orderCreate.setDeliveryDate("2025-06-06");

        return orderCreate;
    }
}


