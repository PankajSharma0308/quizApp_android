package com.example.quizapp2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Notifcications extends AppCompatActivity {

    Button notif_btn;
    Long tsLong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifcications);

        notif_btn = findViewById(R.id.notif_btn);
        tsLong = System.currentTimeMillis()/1000;

        notif_btn.setOnClickListener( v-> {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

            createNotificationChannel();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                    .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                    .setContentTitle("Hey, Come Back! \n")
                    .setContentText("Click to go to HomePage")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setColor(R.drawable.bmbackgroundtwo)
                    .setWhen((new Date()).getTime())
                    .setShowWhen(true)
                    // Set the intent that will fire when the user taps the notification
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);


// notificationId is a unique int for each notification that you must define
            notificationManager.notify(1, builder.build());
        });

    }
    private void createNotificationChannel() {

        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("CHANNEL_ID","Pankaj", importance);
        channel.setDescription("Click");

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}