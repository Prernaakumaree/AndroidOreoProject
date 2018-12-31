package example.android.prerna.com.androidexampleproject.jobservice;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;
import example.android.prerna.com.androidexampleproject.R;

@TargetApi(21)
public class ExampleJobActivity extends AppCompatActivity {
    private static final String TAG = "ExampleJobActivity";
    private int JOB_SERIVCE_ID = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_service);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.start_job)
    void onStartJobButtonClick() {

        ComponentName componentName = new ComponentName(this, ExampleJobService.class);

        JobInfo info = new JobInfo.Builder(JOB_SERIVCE_ID, componentName)
            .setRequiresCharging(true)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
            .setPersisted(true)
            .setPeriodic(15 * 60 * 1000)
            .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = scheduler.schedule(info);

        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d(TAG, "Job scheduled");
        } else {
            Log.d(TAG, "Job scheduling failed");
        }
    }

    @OnClick(R.id.stop_job)
    void onStopJobButtonClick() {
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.cancel(JOB_SERIVCE_ID);
        Log.d(TAG, "JOb stopped");
    }
}