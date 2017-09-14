package antany.ca.mybroadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Antany on 2/25/2017.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (this.getResultData() != null) {
            Log.i("annoy", this.getResultData());
        }else{
            Log.i("he he he","NUUUUUUUUUUUUUUUUUUUUUUUUUL");
        }

        String outPhoneNumber = this.getResultData();
        if(outPhoneNumber.matches("\\+?91.*")){
            Intent i = new Intent(context,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("Number", outPhoneNumber);
            context.startActivity(i);
            setResultData(null);
        }
    }




}
