package antany.ca.mybroadcastreceivers;

import android.Manifest;
import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent in = getIntent();


        String number = in.getStringExtra("Number");

        if(number!=null) {
            TextView txtView = (TextView) findViewById(R.id.textView);
            txtView.setText(number);
        }

        int permissionCheck = ContextCompat.checkSelfPermission(this,Manifest.permission.PROCESS_OUTGOING_CALLS);
        Log.i("LLLLLLL",String.valueOf(permissionCheck));

        if(permissionCheck!=   PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS},1);
        }
    }

}
