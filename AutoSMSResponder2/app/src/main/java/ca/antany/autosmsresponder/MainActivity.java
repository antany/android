package ca.antany.autosmsresponder;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ca.antany.autosmsresponder.broadcastreceiver.SMSReceiver;

public class MainActivity extends AppCompatActivity {

     int SMS_PERMISSION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck = ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)+ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);
        if(permissionCheck!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},SMS_PERMISSION);
        }

        ComponentName cn  = new ComponentName(getApplicationContext(), SMSReceiver.class);
        PackageManager pm = getBaseContext().getPackageManager();

        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),0,new Intent(getApplicationContext(),SMSReceiver.class),0);

        AlarmManager am = (AlarmManager) this.getSystemService(Activity.ALARM_SERVICE);


        Log.d("err",""+SystemClock.currentThreadTimeMillis());

        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,SystemClock.currentThreadTimeMillis()+1800000 ,1800000,pi);

        pm.setComponentEnabledSetting(cn,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);
    }
}
