package in.antany.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
    }

    protected void btnSendMessageOnClick(View view){

        EditText ed = (EditText) findViewById(R.id.msgText);
        Intent intent  = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,ed.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT,"Test email");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"Anu India"});

        Intent chosenIntent = Intent.createChooser(intent,"Please select apt Application");

        startActivity(chosenIntent);
    }
}
