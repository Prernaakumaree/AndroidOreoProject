package example.android.prerna.com.androidexampleproject;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.databinding.DataBindingUtil;
import android.os.Build;

import example.android.prerna.com.androidexampleproject.databinding.AppDataBindingComponent;

public class MainApplication extends Application {
    public static final String CHANNEL_ID = "foregroundServiceChannel";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();

        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
}
