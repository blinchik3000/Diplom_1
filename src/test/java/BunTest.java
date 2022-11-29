import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void BunIsCreated(){
        Bun bun = new Bun("purple",123);
        float price = 123.0f;

        Assert.assertEquals("название булки не соответствует ожиданию","purple",bun.getName());
        Assert.assertEquals("цена булки не соответствует ожиданию",price,bun.getPrice(),0);
    }
}
