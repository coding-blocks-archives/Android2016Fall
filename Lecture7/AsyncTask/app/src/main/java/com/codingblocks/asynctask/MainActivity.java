package com.codingblocks.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    Button asyncButton;
    EditText etDelay;
    TextView tvReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asyncButton = (Button) findViewById(R.id.asyncButton);
        etDelay = (EditText) findViewById(R.id.et_delay);
        tvReport = (TextView) findViewById(R.id.tv_report);

        asyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DelayTask task = new DelayTask();
                int delay = (Integer.valueOf(etDelay.getText().toString()));
                task.execute(delay);
            }
        });
    }

    public class DelayTask extends AsyncTask<Integer, Long, Void> {
        public static final String TAG = "Delay";
        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d(TAG, "doInBackground: start");
            int delay = 0;
            if (integers.length > 0) {
                delay = integers[0];
            }

            long startTime = SystemClock.uptimeMillis();
            long currTime = startTime;
            long endTime = (startTime + (delay * 1000));
            while (SystemClock.uptimeMillis() < endTime) {
                if (SystemClock.uptimeMillis() > (currTime + 250)) {
                    currTime = SystemClock.uptimeMillis();
                    publishProgress(startTime, currTime, endTime);
                }
            }

            Log.d(TAG, "doInBackground: end");

            return null;
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            long start = values[0];
            long curr = values[1];
            long end = values[2];

            Log.d(TAG, "onProgressUpdate: " + start + " " + curr + " " + end);

            float perc = ((curr - start) * 100) / (end - start);
            tvReport.setText(perc + "%");
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            tvReport.setText("Loop completed");
            super.onPostExecute(aVoid);
        }
    }
}
