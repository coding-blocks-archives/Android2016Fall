package com.codingblocks.files;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Files";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File filesDir = getFilesDir();
        File externalFilesDir = getExternalFilesDir(null);
        File externalMusicFilesDir = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File cacheDir = getCacheDir();
        File externalCacheDir = getExternalCacheDir();


        File pubDataDir = Environment.getDataDirectory();
        File pubExternalStorageDir = Environment.getExternalStorageDirectory();
        File f = new File("/storage/0403-0201/");
        File pubDownloadCacheDirectory = Environment.getDownloadCacheDirectory();



        Log.d(TAG, "\nonCreate: filesDir : " + filesDir.getAbsolutePath());
        Log.d(TAG, "\nonCreate: cacheDir : " + cacheDir.getAbsolutePath());
        try {
            Log.d(TAG, "\nonCreate: externalCacheDir : " + externalCacheDir.getAbsolutePath());
            Log.d(TAG, "\nonCreate: externalFilesDir : " + externalFilesDir.getAbsolutePath());
            Log.d(TAG, "\nonCreate: externalMusicFilesDir : " + externalMusicFilesDir.getAbsolutePath());
        } catch (NullPointerException npe) {

        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            File[] externalFilesDirs = getExternalFilesDirs(null);
            for (int i = 0; i < externalFilesDirs.length; i++) {
                Log.d(TAG, "onCreate: externalFilesDirs "
                        + i + ": " + externalFilesDirs[i].getAbsolutePath());
            }
        }

        Log.d(TAG, "\nonCreate: pubDataDir : " + pubDataDir.getAbsolutePath());
        Log.d(TAG, "\nonCreate: pubDownloadCacheDirectory : " + pubDownloadCacheDirectory.getAbsolutePath());
        Log.d(TAG, "\nonCreate: pubExternalStorageDir : " + pubExternalStorageDir.getAbsolutePath());

    }
}
