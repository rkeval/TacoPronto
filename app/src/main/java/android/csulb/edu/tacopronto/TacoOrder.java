package android.csulb.edu.tacopronto;

/**
 * Created by Keval on 16-02-2017.
 */
public class TacoOrder {

    private String description;
    private int quantity;
    private double subTotal;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
