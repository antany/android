package in.antany.activitymanagement;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class StopWatchActivity extends AppCompatActivity {


    private boolean isRunning = false;
    private int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        if(savedInstanceState!=null) {
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("running");
        }
        runner();
    }

    protected void onBtnStopClick(View view){
        isRunning=false;
    }
    protected void onBtnStartClick(View view){
        isRunning=true;
    }
    protected void onBtnResetClick(View view){
        seconds=0;
        final TextView txtView = (TextView) findViewById(R.id.txtViewTimer);
        txtView.setText("0:00:00");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("seconds",seconds);
        outState.putBoolean("running",isRunning);
    }

    private void runner(){
        final TextView txtView = (TextView) findViewById(R.id.txtViewTimer);

        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                if (isRunning) {
                    String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                    txtView.setText(time);
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }
}
