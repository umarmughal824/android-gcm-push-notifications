package android.hmkcode.com.chat;

/**
 * Created by umar on 3/17/2016.
 */

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class MSGReceiver  extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("onReceive", "onReceive");
        Bundle extras = intent.getExtras();
        Intent msgrcv = new Intent("Msg");
        msgrcv.putExtra("msg", extras.getString("message"));
        Log.d("onReceiveMsg", extras.toString());
        msgrcv.putExtra("fromu", extras.getString("fromu"));
        msgrcv.putExtra("fromname", extras.getString("fromname"));


        LocalBroadcastManager.getInstance(context).sendBroadcast(msgrcv);
        ComponentName comp = new ComponentName(context.getPackageName(),MSGService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}
