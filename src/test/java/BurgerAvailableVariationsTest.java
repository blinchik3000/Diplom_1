import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerAvailableVariationsTest {
    private Burger burger;
    private final Bun bun;
    private final Ingredient ingredient1;
    private final Ingredient ingredient2;

    public BurgerAvailableVariationsTest(Bun bun, Ingredient ingredient1, Ingredient ingredient2) {
        this.bun = bun;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
    }

    @Before
    public void setUp() {

        burger = new Burger();

    }

    @Parameterized.Parameters
    public static Object[][] getPairwiseBurgerVariations() {
        Database database = new Database();
//         Считаем список доступных булок из базы данных
        List<Bun> buns = database.availableBuns();
//         Считаем список доступных ингредиентов из базы данных
        List<Ingredient> ingredients = database.availableIngredients();
        return new Object[][]{
                {buns.get(0), ingredients.get(0), ingredients.get(3)},
                {buns.get(0), ingredients.get(1), ingredients.get(4)},
                {buns.get(0), ingredients.get(2), ingredients.get(5)},
                {buns.get(1), ingredients.get(1), ingredients.get(5)},
                {buns.get(1), ingredients.get(2), ingredients.get(3)},
                {buns.get(1), ingredients.get(0), ingredients.get(4)},
                {buns.get(2), ingredients.get(2), ingredients.get(4)},
                {buns.get(2), ingredients.get(0), ingredients.get(5)},
                {buns.get(2), ingredients.get(1), ingredients.get(3)},
        };
    }

    @Test
    public void checkAvailableBurgerVariations() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedBun = String.format("(==== %s ====)%n", bun.getName());
        String expectedSauce = String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName());
        String expectedFilling = String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName());
        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        String expectedPriceText = String.format("%nPrice: %f%n", expectedPrice);

        String expected2 = expectedBun + expectedSauce + expectedFilling + expectedBun + expectedPriceText;
        Assert.assertEquals("рецепт бургера не соответствует ожидаемому", expected2, burger.getReceipt());


    }


}
