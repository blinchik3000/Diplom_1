import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {


    @Test
    public void checkIngredientIsCreated() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "emptiness", 123);
        float price = 123.0f;

        Assert.assertEquals("тип интредиента не соответствует ожидаемому", "SAUCE", ingredient.getType().toString());
        Assert.assertEquals("название интредиента не соответствует ожидаемому", "emptiness", ingredient.getName());
        Assert.assertEquals("цена булки не соответствует ожиданию", price, ingredient.getPrice(),0);
    }
}
