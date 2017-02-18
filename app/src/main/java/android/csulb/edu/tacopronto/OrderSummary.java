package android.csulb.edu.tacopronto;

import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderSummary extends AppCompatActivity {
   /* @Override
    protected void onStart() {
        super.onStart();
        double total =calculateTotal();
        TextView textView = (TextView) findViewById(R.id.txtTotalPrice);
        textView.setText(String.valueOf(total));
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        ListView listView = (ListView) findViewById(R.id.lvOrderList);
        OrderList orderList = OrderList.getOrderList();
        listView.setAdapter(new CustomAdapter(this, R.layout.content_order_detail, orderList));

        TextView total = (TextView) findViewById(R.id.txtTotalPrice);
        double totalprice = Double.valueOf(total.getText().toString()) +
                OrderList.getOrderList().getTacos().get(OrderList.getOrderList().getTacos().size() - 1).getSubTotal();
        totalprice = BigDecimal.valueOf(totalprice).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        total.setText(String.valueOf(totalprice));

        //orderList.add((TacoPronto) this.getIntent().getSerializableExtra("tacoPronto"));
        //listView.setAdapter(new CustomAdapter());
    }

    public void placeOrder(View view) {
        OrderList orderList = OrderList.getOrderList();
        String message = "";
        for (int index = 0; index < orderList.getTacos().size(); index++) {
            TacoOrder tacoOrder = orderList.get(index);
            message += tacoOrder.getDescription() + "\nQantity-" + tacoOrder.getQuantity();

            message += "\n-------------\n";
        }
        TextView txtPrice = (TextView) findViewById(R.id.txtTotalPrice);

        message += "Total Price:$" + txtPrice.getText();

        SmsManager sm = SmsManager.getDefault();
        ArrayList<String> parts = sm.divideMessage(message);
        int numParts = parts.size();

        ArrayList<PendingIntent> sentIntents = new ArrayList<PendingIntent>();
        ArrayList<PendingIntent> deliveryIntents = new ArrayList<PendingIntent>();

      /*  for (int i = 0; i < numParts; i++) {
            sentIntents.add(PendingIntent.getBroadcast(getContext(), 0, mSendIntent, 0));
            deliveryIntents.add(PendingIntent.getBroadcast(getContext(), 0, mDeliveryIntent, 0));
        }*/

        sm.sendMultipartTextMessage("5624729639", null, parts, null, null);

        /*SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("5624729639", null,
                message, null, null);*/
        Toast.makeText(this, "Your Order has been placed. Thank you!", Toast.LENGTH_LONG).show();
    }

    public void reduceQuantity(View view) {
        RelativeLayout rl = (RelativeLayout) view.getParent();
        TextView textView = (TextView) rl.findViewById(R.id.txtQuantity);
        int quantity = Integer.parseInt(textView.getText().toString());
        if (quantity <= 1)
            return;
        quantity -= 1;
        textView = (TextView) rl.findViewById(R.id.txtUnitPrice);
        double unitPrice = BigDecimal.valueOf(Double.valueOf(textView.getText().toString())).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        double subTotal = BigDecimal.valueOf(quantity * unitPrice).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        textView = (TextView) rl.findViewById(R.id.txtQuantity);
        textView.setText(String.valueOf(quantity));
        textView = (TextView) rl.findViewById(R.id.subTotal);
        textView.setText("$" + String.valueOf(subTotal));
        double total = calculateTotal();
        textView = (TextView) findViewById(R.id.txtTotalPrice);
        textView.setText(String.valueOf(total));
    }

    public void increaseQuantity(View view) {
        RelativeLayout rl = (RelativeLayout) view.getParent();
        TextView textView = (TextView) rl.findViewById(R.id.txtQuantity);
        int quantity = Integer.parseInt(textView.getText().toString());
        textView = (TextView) rl.findViewById(R.id.txtUnitPrice);
        double unitPrice = BigDecimal.valueOf(Double.valueOf(textView.getText().toString())).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();

        quantity += 1;

        double subTotal = BigDecimal.valueOf(quantity * unitPrice).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        textView = (TextView) rl.findViewById(R.id.txtQuantity);
        textView.setText(String.valueOf(quantity));
        textView = (TextView) rl.findViewById(R.id.subTotal);
        textView.setText("$" + String.valueOf(subTotal));
        double total = calculateTotal();
        textView = (TextView) findViewById(R.id.txtTotalPrice);
        textView.setText(String.valueOf(total));
    }

    private double calculateTotal() {
        double total = 0;
        ListView lv = (ListView) findViewById(R.id.lvOrderList);
        int count = lv.getChildCount();
        for (int index = 0; index < count; index++) {
            RelativeLayout rl1 = (RelativeLayout) lv.getChildAt(index);
            TextView tv = (TextView) rl1.findViewById(R.id.subTotal);
            String st = tv.getText().toString();
            total += Double.parseDouble(st.substring(1));
        }
        return BigDecimal.valueOf(total).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
