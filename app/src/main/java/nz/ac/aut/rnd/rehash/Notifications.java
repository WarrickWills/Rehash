package nz.ac.aut.rnd.rehash;



import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Created by Stanton on 9/05/2016.
 * Version 1.0
 */
public class Notifications extends Activity {
    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_main);


        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setAlarm();
            }
        });
    }

    public void setAlarm() {
        Calendar cal = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(Notifications.this, Receiver.class);
        alarmIntent = PendingIntent.getBroadcast(Notifications.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime() + 5000, alarmIntent);
        Toast.makeText(this, "Alarm set for " + (SystemClock.elapsedRealtime() + 5000), Toast.LENGTH_LONG).show();
    }
}





