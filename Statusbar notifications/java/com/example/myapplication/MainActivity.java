package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String CHANNEL_ID = "my_channel_01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void BasicNotification(View view)
    {
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "MyChannel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
        notificationBuilder.setSmallIcon(R.drawable.ic_baseline_agriculture_24);
        notificationBuilder.setContentTitle("Aptech MSG Cricket");
        notificationBuilder.setDefaults(Notification.DEFAULT_ALL);
        notificationBuilder.setContentText("Aptech MSGCricket League 2018, Rashid Latif Cricket Academy gulberg, Korangi 5, Karachi, Pakistan.");
        NotificationManager notificationManager = (NotificationManager) getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(mChannel);
        }
    }

    public void ExpandedNotification(View view)
    {
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "MyChannel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
        notificationBuilder.setSmallIcon(R.drawable.ic_baseline_agriculture_24);
        notificationBuilder.setContentTitle("Aptech MSG Cricket");
        notificationBuilder.setDefaults(Notification.DEFAULT_ALL);
        //notificationBuilder.setContentText("Aptech MSGCricket League 2018, Rashid Latif Cricket Academy gulberg, Korangi 5, Karachi, Pakistan.");
        NotificationManager notificationManager = (NotificationManager) getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
        NotificationCompat.BigTextStyle style=new NotificationCompat.BigTextStyle();
        style.setBigContentTitle("Create an inbox-style notification");
        style.bigText("Apply NotificationCompat.InboxStyle to a notification if you want to add multiple short summary lines, such as snippets from incoming emails. This allows you to add multiple pieces of content text that are each truncated to one line, instead of one continuous line of text provided by NotificationCompat.BigTextStyle.");
        notificationBuilder.setStyle(style);

        notificationManager.notify(0,notificationBuilder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(mChannel);
        }

    }
    int i=1;
    public void ProgressNotification(View view)
    {
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "MyChannel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
        notificationBuilder.setSmallIcon(R.drawable.ic_baseline_agriculture_24);
        notificationBuilder.setContentTitle("Downloading");
        notificationBuilder.setDefaults(Notification.DEFAULT_ALL);
        notificationBuilder.setContentText("Please until downloading completed.");
        NotificationManager notificationManager = (NotificationManager) getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(mChannel);
        }

        Handler  handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                notificationBuilder.setProgress(100,i++,false);
                if(i<=100)
                handler.postDelayed(this,200);
                else
                    notificationBuilder.setContentText("Downloading completed.");
                notificationManager.notify(0,notificationBuilder.build());
            }
        };
        handler.post(runnable);

    }

    public void HeadsUpNotification(View view)
    {
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "MyChannel", NotificationManager.IMPORTANCE_HIGH);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
        notificationBuilder.setSmallIcon(R.drawable.ic_baseline_agriculture_24);
        notificationBuilder.setContentTitle("Aptech MSG Cricket");
       // notificationBuilder.setDefaults(Notification.DEFAULT_ALL);
        notificationBuilder.setPriority(NotificationManager.IMPORTANCE_HIGH);
        if (Build.VERSION.SDK_INT >= 21) notificationBuilder.setVibrate(new long[0]);
        notificationBuilder.setContentText("Aptech MSGCricket League 2018, Rashid Latif Cricket Academy gulberg, Korangi 5, Karachi, Pakistan.");
        NotificationManager notificationManager = (NotificationManager) getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(mChannel);
        }

    }

    public void LockScreenNotification(View view)
    {
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "MyChannel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
        notificationBuilder.setSmallIcon(R.drawable.ic_baseline_agriculture_24);
        notificationBuilder.setContentTitle("Aptech MSG Cricket");
        notificationBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        notificationBuilder.setContentText("Aptech MSGCricket League 2018, Rashid Latif Cricket Academy gulberg, Korangi 5, Karachi, Pakistan.");
        NotificationManager notificationManager = (NotificationManager) getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(mChannel);
        }
    }
}