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

public class TacoFilling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taco_filling);
    }

    public void openBeverageActivity(View view) {
        TacoPronto tacoPronto = (TacoPronto) this.getIntent().getSerializableExtra("tacoPronto");
        RelativeLayout cbContainer = (RelativeLayout) findViewById(R.id.cbContainer);
        int cbCount = cbContainer.getChildCount();
        List<String> fillings = new ArrayList<String>();
        for (int index = 0; index < cbCount; index++) {
            if (cbContainer.getChildAt(index) instanceof CheckBox) {
                CheckBox cbFilling = (CheckBox) cbContainer.getChildAt(index);
                if (cbFilling.isChecked())
                    fillings.add(cbFilling.getText().toString());
            }
        }

        if (fillings.size() == 0) {
            Toast.makeText(this, "Please select one or more fillings", Toast.LENGTH_LONG).show();
            return;
        }
        if (fillings.size() > 3) {
            Toast.makeText(this, "You can select at max 3 fillings.", Toast.LENGTH_LONG).show();
            return;
        }

        tacoPronto.setFilling(fillings);
        Intent intent = new Intent(this, Beverage.class);
        intent.putExtra("tacoPronto", tacoPronto);
        startActivity(intent);

    }
}
