package android.csulb.edu.tacopronto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import static android.widget.EditText.*;

/**
 * Created by Keval on 16-02-2017.
 */

public class CustomAdapter extends ArrayAdapter<TacoOrder> {


    //private final List<TacoPronto> orderList;
    public CustomAdapter(Context context, int resource, OrderList orderList) {
        super(context, resource, orderList.getTacos());
        //this.orderList = orderList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrderList orderList = OrderList.getOrderList();
        TacoOrder tacoOrder = orderList.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.content_order_detail, null);
// Set the text

        TextView textView = (TextView) row.findViewById(R.id.txtTacoDetail);
        textView.setText(tacoOrder.getDescription());
        TextView quantity = (TextView) row.findViewById(R.id.txtQuantity);
        quantity.setText(String.valueOf(tacoOrder.getQuantity()));
        TextView subTotal = (TextView) row.findViewById(R.id.subTotal);
        subTotal.setText(String.valueOf(tacoOrder.getSubTotal()));
        TextView unitPrice = (TextView) row.findViewById(R.id.txtUnitPrice);
        unitPrice.setText(String.valueOf(tacoOrder.getSubTotal()));
        return row;
    }


}
