package example.android.prerna.com.androidexampleproject.forgroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import example.android.prerna.com.androidexampleproject.MainActivity;
import example.android.prerna.com.androidexampleproject.R;
import example.android.prerna.com.androidexampleproject.jobintent.ExampleJobIntentActivity;

import static example.android.prerna.com.androidexampleproject.MainApplication.CHANNEL_ID;

public class ExampleForegroundService extends Service {
    private static final String TAG = "ExampleForgroundService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");

        String input = intent.getStringExtra(ExampleJobIntentActivity.INPUT_STRING_KEY);

        Intent notifIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notifIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_notif_icon)
            .setContentIntent(pendingIntent)
            .build();

        startForeground(1, notification);

        // do heavy work on background thread
        // stopSelf();

        return START_NOT_STICKY;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
