package android.csulb.edu.tacopronto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Keval on 16-02-2017.
 */

public class OrderList {
    private static OrderList orderList;
    private List<TacoOrder> tacos = new ArrayList<>();
    private OrderList() {


    }

    public static OrderList getOrderList() {
        if (orderList == null) {
            orderList = new OrderList();
        }
        return orderList;
    }

    public static String implode(List ary, String delim) {
        String out = "";
        for (int i = 0; i < ary.size(); i++) {
            if (i != 0) {
                out += delim;
            }
            out += ary.get(i);
        }
        return out;
    }

    public void addTacoOrder(String size, String tortila, List<String> fillings, List<String> Beverages, int quantity, double subTotal) {
        String description = size + " + " + tortila + " + ";
        description += implode(Beverages, ",");
        description += " + " + implode(fillings, ",");

        TacoOrder tacoOrder = new TacoOrder();
        tacoOrder.setDescription(description);

        tacoOrder.setQuantity(quantity);
        tacoOrder.setSubTotal(subTotal);
        orderList.tacos.add(tacoOrder);
    }

    public TacoOrder get(int position) {
        return tacos.get(position);
    }

    public List<TacoOrder> getTacos() {
        return tacos;
    }
}
