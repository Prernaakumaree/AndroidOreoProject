package example.android.prerna.com.androidexampleproject.forgroundservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.android.prerna.com.androidexampleproject.R;

public class ExampleForegroundActivity extends AppCompatActivity {
    public static final String INPUT_STRING_KEY = "inputString";

    @BindView(R.id.input) EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foreground_service);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.start_service)
    void onStartServiceButtonClick() {
        String input = mEditText.getText().toString();

        Intent serviceIntent = new Intent(this, ExampleForegroundService.class);
        serviceIntent.putExtra(INPUT_STRING_KEY , input);

        //startService(serviceIntent);
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    @OnClick(R.id.stop_service)
    void onStopServiceButtonClick() {
        Intent serviceIntent = new Intent(this, ExampleForegroundService.class);
        stopService(serviceIntent);

    }
}
