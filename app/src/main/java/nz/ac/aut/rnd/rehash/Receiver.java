package nz.ac.aut.rnd.rehash;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Stanton on 15/05/2016.
 */
public class Receiver extends BroadcastReceiver {
    private Notification.Builder builder;

    @Override
    public void onReceive(Context context, Intent intent) {
        builder = new Notification.Builder(context);
        builder.setContentTitle("FeelsBadMan");
        builder.setContentText("Wow you suck ass dude");
        builder.setSmallIcon(R.drawable.ic_feels);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);
        builder.setVibrate(new long[]{1000, 0, 0, 0, 0});
        Toast toast = Toast.makeText(context, "Fuck you", Toast.LENGTH_LONG);
        toast.show();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }
}
