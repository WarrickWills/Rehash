package nz.ac.aut.rnd.rehash;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;

/**
 * Created by Stanton on 9/05/2016.
 * Version 1.0
 */
public class MainActivity extends AppCompatActivity {

    private Firebase firebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Reminder!");
        builder.setContentText("FeelsGoodMen");
        builder.setContentInfo("FeelsGoodMen");
        builder.setSubText("FeelsGoodMen");
        builder.setSmallIcon(R.drawable.ic_feels);
        long[] vibrate = new long[]{100};
        builder.setVibrate(vibrate);
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(sound);

        firebaseRef = new Firebase("https://rehashaut.firebaseio.com/");

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);


        Button button = (Button) findViewById(R.id.notificationButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1, builder.build());
            }
        });


    }
}
