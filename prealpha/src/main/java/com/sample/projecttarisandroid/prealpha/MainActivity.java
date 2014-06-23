package com.sample.projecttarisandroid.prealpha;

import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
    private NotificationManager myNotificationManager;
    private int notificationIdOne = 111;
    private int notificationIdTwo = 112;
    private int numMessagesOne = 0;
    private int numMessagesTwo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notOneBtn = (Button) findViewById(R.id.notificationOne);
        notOneBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayNotificationOne();
            }
        });

        Button notTwoBtn = (Button) findViewById(R.id.notificationTwo);
        notTwoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayNotificationTwo();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void displayNotificationOne() {

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, NotificationOne.class);
        resultIntent.putExtra("notificationId", notificationIdOne);

        //This ensures that navigating backward from the Activity leads out of the app to Home page
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationOne.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT); //can only be used once


        NotificationCompat.BigTextStyle mainPageStyle = new NotificationCompat.BigTextStyle()
                .setBigContentTitle("Adidas DRose 4.5")
                .setSummaryText("Sponsored by the United Center")
                .bigText("Get 10% off the new Adidas DRose 4.5s through this exclusive offer.");
        // Invoking the default notification service
        NotificationCompat.Builder  mainBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_united)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_shoes_rose))
                .setStyle(mainPageStyle)
                .addAction(R.drawable.ic_action_about, "More Info", resultPendingIntent)
                .addAction(R.drawable.ic_action_new, "Add to Cart", resultPendingIntent);
                //.setNumber(++numMessagesOne);


        myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // pass the Notification object to the system
        myNotificationManager.notify(notificationIdOne, mainBuilder.build());
    }

    protected void displayNotificationTwo() {

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, NotificationTwo.class);
        resultIntent.putExtra("notificationId", notificationIdTwo);

        //This ensures that navigating backward from the Activity leads out of the app to Home page
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationTwo.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT); //can only be used once


        NotificationCompat.BigTextStyle mainPageStyle = new NotificationCompat.BigTextStyle()
                .setBigContentTitle("Compliments of 15 Steps")
                .setSummaryText("Sponsored by Fountainebleu")
                .bigText("Have a free cocktail while dining at our restaurant. A special offer for Fountainbleu guests to welcome you to Miami!");
        // Invoking the default notification service
        NotificationCompat.Builder  mainBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_fb)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_restaurant))
                .setStyle(mainPageStyle)
                .addAction(R.drawable.ic_action_about, "More Info", resultPendingIntent)
                .addAction(R.drawable.ic_directions, "Get Directions", resultPendingIntent);
        //.setNumber(++numMessagesOne);


        myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // pass the Notification object to the system
        myNotificationManager.notify(notificationIdTwo, mainBuilder.build());


    }
}
