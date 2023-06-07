package OrderTests;


@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class CreateOrderTest {
    private clients.OrderClient orderClient = new clients.OrderClient();


    @org.junit.runners.Parameterized.Parameter
    static dataProvider.OrderCreateNoColour orderCreateNoColour = new dataProvider.OrderCreateNoColour();

@org.junit.runners.Parameterized.Parameter(1)
public String colour;
    @org.junit.runners.Parameterized.Parameters
    public Object[][] orderDifferentColours() {

        return new Object[][] {
                {orderCreateNoColour, "Black"},
                {orderCreateNoColour, ("Black  Grey")},
                {orderCreateNoColour, null},

        };
    }
@org.junit.Test
        public void createOrder(){
            pojoClasses.OrderCreate orderCreate = dataProvider.OrderCreateNoColour.getOrderCreateNoColourData();
             int expectedTrack =
            orderClient.create(orderCreate)
                    .log().all()
                    .statusCode(201)
                    .extract().jsonPath().get("track");
            System.out.println(expectedTrack);


        }

}

