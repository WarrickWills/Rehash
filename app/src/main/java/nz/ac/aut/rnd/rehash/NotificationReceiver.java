package nz.ac.aut.rnd.rehash;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Stanton on 28/07/2016.
 */
public class NotificationReceiver extends BroadcastReceiver {
    private NotificationManager mgr;
    private Notification note;

    @Override
    public void onReceive(Context context, Intent intent){
        mgr = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        createNotification(context, intent.getExtras().getString("Title"),
                intent.getExtras().getString("Content"));
        showNotification();
    }

    public void createNotification(Context context, String title, String content) {
        Intent intent = new Intent(context, Login.class);
        note = new Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setTicker("New notification")
                .setSmallIcon(R.drawable.ic_feels)
                .setPriority(Notification.PRIORITY_HIGH)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setVibrate(new long[1])
                .setContentIntent(PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT))
                .build();

    }

    public void showNotification() {
        mgr.notify(1, note);
    }

}
