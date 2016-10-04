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

import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";

    TextView tvStatus;
    Button btnCheckStatus;

    public static final int PERM_REQ_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nammu.init(this);

        tvStatus = (TextView) findViewById(R.id.tvStatus);
        btnCheckStatus = (Button) findViewById(R.id.btnCheckStatus);


        btnCheckStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (Nammu.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                    checkFileStatus();
//
//                } else {

                    Nammu.askForPermission(MainActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            new PermissionCallback() {
                                @Override
                                public void permissionGranted() {
                                    checkFileStatus();
                                }

                                @Override
                                public void permissionRefused() {
                                    Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                                }
                            });

                }
//            }
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Nammu.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
