import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String colour;
    private final float price;
    private final float expectedPrice;

    public BunTest(String colour, float price, float expectedPrice) {
        this.colour = colour;
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunsVariations() {
        //happy path
        String name1="purple";
        float price1=123;
        float expectedPrice1=123.0f;
        //price with floating point
        String name2="purple";
        float price2=123.0f;
        float expectedPrice2=123.0f;
        //empty colour
        String name3="";
        float price3=123;
        float expectedPrice3=123.0f;
        //null colour
        String name4=null;
        float price4=123;
        float expectedPrice4=123.0f;
        //special characters colour
        String name5="!";
        float price5=123;
        float expectedPrice5=123.0f;
        //upper case colour
        String name6="PURPLE";
        float price6=123;
        float expectedPrice6=123.0f;
        //zero price
        String name7="purple";
        float price7=0;
        float expectedPrice7=0.0f;
        //under zero price
        String name8="purple";
        float price8=-1;
        float expectedPrice8=-1.0f;
        //under zero price
        String name9="purple";
        float price9=Float.MAX_VALUE;
        float expectedPrice9=Float.MAX_VALUE;
        //min price with floating pount
        String name10="purple";
        float price10=0.01f;
        float expectedPrice10=0.01f;


        return new Object[][]{
                {name1, price1, expectedPrice1},
                {name2, price2, expectedPrice2},
                {name3, price3, expectedPrice3},
                {name4, price4, expectedPrice4},
                {name5, price5, expectedPrice5},
                {name6, price6, expectedPrice6},
                {name7, price7, expectedPrice7},
                {name8, price8, expectedPrice8},
                {name9, price9, expectedPrice9},
                {name10, price10, expectedPrice10},
        };
    }

    @Test
    public void BunIsCreated() {
        Bun bun = new Bun(colour, price);

        Assert.assertEquals("название булки не соответствует ожиданию", colour, bun.getName());
        Assert.assertEquals("цена булки не соответствует ожиданию", expectedPrice, bun.getPrice(), 0);
    }
}
