package nz.ac.aut.rnd.rehash;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.GregorianCalendar;


/**
 * Created by Stanton on 3/07/2016.
 */
public class Alarm extends Activity {
    AlarmManager aMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        setAlarm("Gay", "gay");
    }

    public void setAlarm(String title, String content) {
        Long time = new GregorianCalendar().getTimeInMillis()+5000;
        Intent alertIntent = new Intent(this, NotificationReceiver.class);
        Bundle bundle = new Bundle();
        bundle.putString("Title", title);
        bundle.putString("Content", content);
        alertIntent.putExtras(bundle);

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.set(manager.RTC_WAKEUP, time,
                PendingIntent.getBroadcast(this, 1, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
