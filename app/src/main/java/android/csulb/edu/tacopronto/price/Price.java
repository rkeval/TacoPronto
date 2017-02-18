package android.csulb.edu.tacopronto.price;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Keval on 17-02-2017.
 */

public class Price {
    private static Map<String, Double> prices;
    private static Price price;

    private Price() {

        initialize();
    }

    public static double get(String item) {
        if (price == null)
            price = new Price();
        return prices.get(item);
    }

    private void initialize() {
        prices = new HashMap<>();
        prices.put("Beans", 0.99);
        prices.put("Beef", 1.99);
        prices.put("Cheese", 1.09);
        prices.put("Chicken", 1.25);
        prices.put("Guacamole", 1.59);
        prices.put("LBT", 0.99);
        prices.put("Pico de Gallo", 0.99);
        prices.put("Rice", 0.49);
        prices.put("Sea Food", 1.99);
        prices.put("White Fish", 1.79);
        prices.put("Corn", 0.99);
        prices.put("Flour", 1.49);
        prices.put("Large", 3.99);
        prices.put("Soda", 0.99);
        prices.put("Oerveza", 1.99);
        prices.put("Margarita", 1.99);
        prices.put("Tequila", 2.99);
        prices.put("Small", 2.99);
    }
}
