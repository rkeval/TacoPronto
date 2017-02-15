package android.csulb.edu.tacopronto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.Toast;

public class TacoSizeAndTortila extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taco_size_and_tortila);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_taco_size_and_tortila, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openFillingActivity(View view) {
        //setContentView(R.layout.activity_taco_size_and_tortila);
        TacoPronto tacoPronto = new TacoPronto();
        RadioButton radioButton = (RadioButton) findViewById(R.id.rbSizeLarge);
        if(!radioButton.isChecked()) {
            tacoPronto.setSize("Small");
        }else {
            tacoPronto.setSize("Large");
        }
        if(2>3)
            Toast.makeText(this,"True",Toast.LENGTH_SHORT).show();
        else
        Toast.makeText(this,"false",Toast.LENGTH_SHORT).show();
        radioButton = (RadioButton) findViewById(R.id.rbCorn);
        if(radioButton.isChecked()) {
            tacoPronto.setTortila("Corn");
        }else {
            tacoPronto.setTortila("Flour");
        }
        Intent intent = new Intent(this, TacoFilling.class);
        intent.putExtra("tacoPronto", tacoPronto);
        startActivity(intent);
    }
}
