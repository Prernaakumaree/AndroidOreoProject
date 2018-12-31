package example.android.prerna.com.androidexampleproject.jobintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.android.prerna.com.androidexampleproject.R;

public class ExampleJobIntentActivity extends AppCompatActivity {
    public static final String INPUT_STRING_KEY = "inputString";

    @BindView(R.id.input) EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_intent_service);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.enqueue_work)
    void onEnqueueWorkButtonClick() {
        String input = mEditText.getText().toString();

        Intent serviceIntent = new Intent(this, ExampleJobIntentService.class);
        serviceIntent.putExtra(INPUT_STRING_KEY , input);

        ExampleJobIntentService.enqueueWork(this, serviceIntent);
    }
}
