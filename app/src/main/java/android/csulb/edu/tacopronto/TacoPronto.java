package android.csulb.edu.tacopronto;

import java.util.List;

/**
 * Created by Keval on 13-02-2017.
 */

public class TacoPronto {
    private String size, tortila;
    private List<String> filling;

    public String getTortila() {
        return tortila;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTortila(String tortila) {
        this.tortila = tortila;
    }

    public List<String> getFilling() {
        return filling;
    }

    public void setFilling(List<String> filling) {
        this.filling = filling;
    }
}
