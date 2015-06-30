package com.lp.mywearable;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    public static int notificationId = 001;

    public static String EXTRA_EVENT_ID = "First notification";

    Button button1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.shownotification1);

        button1.setOnClickListener(onClickListener);

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showNotification(MainActivity.this);
        }
    };

    void showNotification(Context context) {
        Intent intent = new Intent(this, MainActivity2Activity.class);
        intent.putExtra(EXTRA_EVENT_ID, notificationId);

        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(R.string.app_name)
                .setContentText(R.string.show_notification1)
                .setContentIntent(pIntent);

        Intent actionIntent = new Intent(Intent.ACTION_VIEW);
        Uri geoUri = Uri.parse("geo:0,0?q=" + Uri.encode("shanghai"));
        actionIntent.setData(geoUri);
        PendingIntent pIntenAction1 = PendingIntent.getActivity(this, 0, actionIntent, 0);

        notificationBuilder.addAction(R.drawable.ic_fab_start_chat_default, getString(R.string.notification_action1), pIntenAction1);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, notificationBuilder.build());


    }


}
