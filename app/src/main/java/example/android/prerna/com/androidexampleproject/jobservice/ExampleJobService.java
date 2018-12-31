package example.android.prerna.com.androidexampleproject.jobservice;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

@TargetApi(21)
public class ExampleJobService extends JobService {

    private static final String TAG = "ExampleJobService";
    private boolean isJobCancelled = false;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "Job Started");
        doBackgroundWork(params);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "Job cancelled before completion");
        isJobCancelled = true;
        return true;
    }

    private void doBackgroundWork(JobParameters params) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (isJobCancelled) return;

                Log.d(TAG, params + " - " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.d(TAG, "Job finished");
            jobFinished(params,false);
        }).start();
    }
}
