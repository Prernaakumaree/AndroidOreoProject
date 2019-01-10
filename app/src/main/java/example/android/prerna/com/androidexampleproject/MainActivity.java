package example.android.prerna.com.androidexampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import example.android.prerna.com.androidexampleproject.databinding.DataBindingActivity;
import example.android.prerna.com.androidexampleproject.forgroundservice.ExampleForegroundActivity;
import example.android.prerna.com.androidexampleproject.jobintent.ExampleJobIntentService;
import example.android.prerna.com.androidexampleproject.jobservice.ExampleJobActivity;
import example.android.prerna.com.androidexampleproject.livedata.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick (R.id.job_intent_service)
    void onJobIntentServiceButtonClick() {
        Toast.makeText(this, "Starting Job Intent Activity", Toast.LENGTH_SHORT).show();
        statExampleActivity(ExampleJobIntentService.class);
    }

    @OnClick (R.id.job_service)
    void onJobServiceButtonClick() {
        Toast.makeText(this, "Starting Job Activity", Toast.LENGTH_SHORT).show();
        statExampleActivity(ExampleJobActivity.class);
    }

    @OnClick (R.id.foreground_service)
    void onForegroundServiceButtonClick() {
        Toast.makeText(this, "Starting Foreground Service Activity", Toast.LENGTH_SHORT).show();
        statExampleActivity(ExampleForegroundActivity.class);
    }

    @OnClick (R.id.data_binding)
    void onDataBindingButtonClick() {
        Toast.makeText(this, "Starting Data Binding Activity", Toast.LENGTH_SHORT).show();
        statExampleActivity(DataBindingActivity.class);
    }

    @OnClick (R.id.live_data)
    void onLiveDataButtonClick() {
        Toast.makeText(this, "Starting Data Binding Activity", Toast.LENGTH_SHORT).show();
        statExampleActivity(LoginActivity.class);
    }

    private void statExampleActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
