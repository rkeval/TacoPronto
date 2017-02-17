package android.csulb.edu.tacopronto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Beverage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage);
    }

    public void openSummaryActivity(View view) {
        TacoPronto tacoPronto = (TacoPronto) this.getIntent().getSerializableExtra("tacoPronto");
        RelativeLayout cbContainer = (RelativeLayout) findViewById(R.id.cbContainer);

        int cbCount = cbContainer.getChildCount();
        List<String> beverages = new ArrayList<String>();
        for (int index = 0; index < cbCount; index++) {
            if (cbContainer.getChildAt(index) instanceof CheckBox) {
                CheckBox cbFilling = (CheckBox) cbContainer.getChildAt(index);

                if (cbFilling.isChecked())
                    beverages.add(cbFilling.getText().toString());
            }
        }

        tacoPronto.setBeverages(beverages);
        OrderList orderList = OrderList.getOrderList();
        orderList.addTacoOrder(tacoPronto.getSize(), tacoPronto.getTortila(), tacoPronto.getFilling(), tacoPronto.getBeverages(), 1, 20.5);
        tacoPronto = null;

        Intent intent = new Intent(this, OrderSummary.class);
        //intent.putExtra("tacoPronto", null);
        startActivity(intent);
    }
}
