package android.csulb.edu.tacopronto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OrderSummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        ListView listView = (ListView) findViewById(R.id.lvOrderList);
        OrderList orderList = OrderList.getOrderList();
        listView.setAdapter(new CustomAdapter(this, R.layout.content_order_detail, orderList));
        //orderList.add((TacoPronto) this.getIntent().getSerializableExtra("tacoPronto"));
        //listView.setAdapter(new CustomAdapter());
    }
}
