package jf.andro.gcmreceiver;

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

    }
}
