package OrderTests;


@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class CreateOrderTest {
    private clients.OrderClient orderClient = new clients.OrderClient();


    @org.junit.runners.Parameterized.Parameter
    static dataProvider.OrderCreateNoColour orderCreateNoColour = new dataProvider.OrderCreateNoColour();

@org.junit.runners.Parameterized.Parameter(1)
public String[] colour;
    @org.junit.runners.Parameterized.Parameters
    public java.util.List<Object[]> orderDifferentColours() {

        return java.util.Arrays.asList( new Object[][] {
                {orderCreateNoColour, new String[]{"Black"}},
                {orderCreateNoColour, new String[] {"Black", "Grey"}},
                {orderCreateNoColour, new String[] {}},


    });}
@org.junit.Test
        public void createOrder(){
    pojoClasses.OrderCreate orderCreate = new dataProvider.OrderCreateNoColour().getOrderCreateNoColourData();

    int expectedTrack =
            orderClient.create(orderCreate)
                    .log().all()
                    .statusCode(201)
                    .extract().jsonPath().get("track");
            System.out.println(expectedTrack);


        }

}

