package android.csulb.edu.tacopronto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keval on 16-02-2017.
 */

public class OrderList {
    private List<TacoPronto> tacos;

    private OrderList() {

    }

    public List<TacoPronto> getOrderList() {
        if (tacos == null) {
            tacos = new ArrayList<TacoPronto>();
        }
        return tacos;
    }
}
