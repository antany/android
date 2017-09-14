package in.antany.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    protected void buttonNumClick(View view){
        TextView txtView  = (TextView) findViewById(R.id.text);
        String number = (String)view.getTag();
        txtView.setText(CalculatorFunctions.typeNumber(txtView.getText().toString(),number));
    }

    protected void buttonDotClick(View view){

    }

    protected void buttonClearClick(View view){
        TextView txtView = (TextView)findViewById(R.id.text);
        txtView.setText("0");
    }
}
