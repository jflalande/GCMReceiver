package jf.andro.gcmreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by jf on 03/02/16.
 */
public class MonGcmListenerService extends GcmListenerService {
    @Override
    public void onMessageReceived(String from, Bundle data) {

        Log.i("JFL", "Message received from " + from);
        Log.i("JFL", "Message: " + data.getString("the_message"));

        Intent forward = new Intent("jf.andro.forward");
        forward.putExtra("the_message", data.getString("the_message"));
        sendBroadcast(forward);
    }
}
