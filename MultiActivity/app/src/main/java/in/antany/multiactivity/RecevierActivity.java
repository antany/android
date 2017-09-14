package in.antany.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RecevierActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recevier);

        Intent intent = getIntent();
        String str = intent.getStringExtra("msg");

        TextView txtView = (TextView) findViewById(R.id.showText);

        txtView.setText(str);

    }
}
