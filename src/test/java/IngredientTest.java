import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;

    public IngredientTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypes() {


        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void checkIngredientIsCreated() throws IllegalArgumentException {
        Ingredient ingredient = new Ingredient(ingredientType, "emptiness", 123);
        float price = 123.0f;
        Assert.assertEquals("тип интредиента не соответствует ожидаемому", ingredientType.name(), ingredient.getType().toString());
        Assert.assertEquals("название интредиента не соответствует ожидаемому", "emptiness", ingredient.getName());
        Assert.assertEquals("цена булки не соответствует ожиданию", price, ingredient.getPrice(), 0);
    }
}
