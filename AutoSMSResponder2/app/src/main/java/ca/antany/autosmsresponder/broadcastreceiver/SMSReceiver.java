package ca.antany.autosmsresponder.broadcastreceiver;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import static android.provider.Telephony.Sms.Intents.getMessagesFromIntent;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        Log.d("err",intent.toString());

        SmsMessage[] smsMessage=null;

        try {

            smsMessage = getMessagesFromIntent(intent);

        }catch (NullPointerException nll){
            Log.e("err",nll.getMessage());
        }
        Log.d("asdf","its all fun after all");

        Toast.makeText(context,"SMS Receiver activated",Toast.LENGTH_SHORT);

        if(smsMessage!=null) {

            String receivedPhoneNumber = smsMessage[0].getOriginatingAddress();
            //// TODO: 9/13/2017 - Change number here...
            if (receivedPhoneNumber.matches(".*<numberpls>.*")) {
                String message = smsMessage[0].getMessageBody();
                String responseMessage = null;

                if ("HELP".equalsIgnoreCase(message)) {
                    responseMessage = "LOCATION (GET CURRENT LOCATION)";
                } else if ("LOCATION".equalsIgnoreCase(message)) {
                    LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                    boolean isGPSEnabled = locationManager
                            .isProviderEnabled(LocationManager.GPS_PROVIDER);

                    boolean isNetworkEnabled = locationManager
                            .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                    if (!isGPSEnabled && !isNetworkEnabled) {
                        responseMessage = "Location Services disabled. Please contact by calling";
                    } else {
                        Location location = null;
                        int checkPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
                        if (checkPermission == PermissionChecker.PERMISSION_GRANTED) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        }

                        if (location == null) {
                            checkPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION);
                            if (checkPermission == PermissionChecker.PERMISSION_GRANTED) {
                                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            }
                        }


                        if (location == null) {
                            responseMessage = "Location Services disabled. Please contact by calling";
                        } else {
                            double latitude = location.getLatitude();
                            double longitude = location.getLongitude();

                            responseMessage = "latitude=(" + latitude + "), longitude=(" + longitude + ")";
                        }

                    }
                }

                if (responseMessage != null) {

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(receivedPhoneNumber, null, responseMessage, null, null);
                }
            }
        }

    }


}