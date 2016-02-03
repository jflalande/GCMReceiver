package jf.andro.gcmreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jf on 03/02/16.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{

    private final Handler handler;
    private final TextView tv;
    private String recu = null;

    public MyBroadcastReceiver(Handler handler, TextView tv) {
        this.handler = handler;
        this.tv = tv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        recu = intent.getStringExtra("the_message");
        handler.post(new Runnable() {
            @Override
            public void run() {

                tv.setText("Recu: " + recu);

            }
        });
    }
}
