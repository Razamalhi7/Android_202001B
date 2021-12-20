package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Ringtone ringtone=null;
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            ringtone.stop();
        }
    };
    Handler  handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

                if(status == BatteryManager.BATTERY_STATUS_CHARGING)
                {
                    Toast.makeText(context, "Battery Chargind", Toast.LENGTH_SHORT).show();
                }
                if(status == BatteryManager.BATTERY_STATUS_FULL)
                {
                    Toast.makeText(context, "Battery full", Toast.LENGTH_SHORT).show();

                    Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                    ringtone = RingtoneManager.getRingtone(MainActivity.this,uri);
                    ringtone.play();
                    handler.postDelayed(runnable,10000);
                }
            }
        };
        registerReceiver(broadcastReceiver,intentFilter);
    }
}


