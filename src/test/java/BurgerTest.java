import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Burger burger;


    @Test
    public void checkIngredientCanBeAdded() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void checkIngredientCanBeRemoved() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }


    @Test
    public void checkIngredientCanBeMoved() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        String expected = "(==== null ====)\r\n" +
                "= sauce asd =\r\n" +
                "= sauce qwe =\r\n" +
                "(==== null ====)\r\n" +
                "\r\n" +
                "Price: 357,000000\r\n";
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "qwe", 123));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "asd", 234));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("рецепт не соответствует ожидаемому", expected, burger.getReceipt());
    }


    @Test
    public void checkPriceIsCorrect() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "qwe", 123));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "asd", 234));
        Assert.assertEquals("рецепт не соответствует ожидаемому", "357.0", String.valueOf(burger.getPrice()));
    }

}
