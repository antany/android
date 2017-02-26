package antany.ca.mybroadcastreceivers;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Antany on 2/26/2017.
 */

public class TestService extends IntentService {

    BroadcastReceiver bc;

    TestService(){
        super("Test Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("asdf","============================");
        bc= new MyReceiver();

        IntentFilter filter = new IntentFilter();
        filter.setPriority(999);
        filter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        try {
            this.registerReceiver(bc, filter);
        }catch(Exception e){

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("ENNA PANNA,","ASDFASDF");
        //this.unregisterReceiver(bc);
    }
}
