package com.codingblocks.library;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.codingblocks.perman.Perman;

public class PermanActivity extends AppCompatActivity {

    public static final String TAG = "PermanAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perman);

        Perman.initialise(this);

        boolean granted = Perman.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Log.d(TAG, "onCreate: " + granted);

        Perman.requestPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                new Perman.OnPermissionRequestResult() {
                    @Override
                    public void onGranted(String permission)  {
                        writeToFile();
                    }

                    @Override
                    public void onDenied(String permission) {
                        Toast.makeText(PermanActivity.this, "Not granted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    void writeToFile () {
        Log.d(TAG, "writeToFile: " + "Write a file here");
        // do actual file write
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Perman.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
