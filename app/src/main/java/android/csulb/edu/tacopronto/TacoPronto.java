package android.csulb.edu.tacopronto;

import android.csulb.edu.tacopronto.price.Price;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Keval on 13-02-2017.
 */

public class TacoPronto implements Serializable {
    private String size, tortila;
    private List<String> filling;
    private List<String> beverages;
    private double subTotal;

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public String getTortila() {
        return tortila;
    }

    public void setTortila(String tortila) {
        this.tortila = tortila;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getFilling() {
        return filling;
    }

    public void setFilling(List<String> filling) {
        this.filling = filling;
    }

    public List<String> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<String> beverages) {
        this.beverages = beverages;
    }

    public void calculateTacoPrice() {
        subTotal = 0;
        subTotal += Price.get(size);
        subTotal += Price.get(tortila);
        for (String fill : filling) {
            subTotal += Price.get(fill);
        }
        for (String fill : beverages) {
            subTotal += Price.get(fill);
        }

    }
}
