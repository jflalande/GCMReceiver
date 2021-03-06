package jf.andro.gcmreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("JFL", "We start !");

        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }

        // Registers a receiver that receive notification from the service MonGcmListenerService
        receiver = new MyBroadcastReceiver(new Handler(), (TextView)findViewById(R.id.textView));
        registerReceiver(receiver, new IntentFilter("jf.andro.forward"));
    }

    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                        .show();
                Log.i("JFL", "Connected !");
            } else {
                Log.i("JFL", "This device is not supported.");
                finish();
            }
            return false;
        }
        else
        {
            Log.i("JFL", "Succes: Google Play Service OK.");
        }
        return true;
    }
}
