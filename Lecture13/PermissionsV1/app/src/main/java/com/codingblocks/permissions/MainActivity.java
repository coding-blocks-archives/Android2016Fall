package com.codingblocks.permissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";

    TextView tvStatus;
    Button btnCheckStatus;

    public static final int PERM_REQ_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = (TextView) findViewById(R.id.tvStatus);
        btnCheckStatus = (Button) findViewById(R.id.btnCheckStatus);


        btnCheckStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permResult = ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);

                if (permResult == PackageManager.PERMISSION_GRANTED) {
                    checkFileStatus();
                } else {


                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            PERM_REQ_CODE);

                }



            }
        });
    }

    void checkFileStatus () {
        File myfile =
                new File(Environment.getExternalStorageDirectory(), "myfile");
        Log.d(TAG, "onClick: " + myfile.getAbsolutePath());

        try {
            myfile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvStatus.setText(myfile.isFile() ? "Exists" : "Doesn't Exist");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == PERM_REQ_CODE) {
            if (permissions[0].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                checkFileStatus();
            } else {
                Toast.makeText(MainActivity.this,
                        "Permission not granted", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
