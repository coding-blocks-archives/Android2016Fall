package com.codingblocks.files;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by championswimmer on 25/09/16.
 */

public class FileWriteTask extends AsyncTask<Void, Void, String> {

    public static final String TAG = "AsyncTask";

    private String fileName;
    private String fileData;


    private OnFileDataUpdateListener onFileDataUpdateListener;

    public FileWriteTask(String fileName, String fileData) {
        this.fileName = fileName;
        this.fileData = fileData;
    }


    public interface OnFileDataUpdateListener {
        void onFileDataUpdate(String fileData);
    }

    public void setOnFileDataUpdateListener(OnFileDataUpdateListener onFileDataUpdateListener) {
        this.onFileDataUpdateListener = onFileDataUpdateListener;
    }

    @Override
    protected String doInBackground(Void... params) {
        File dir = Environment.getExternalStorageDirectory();
        Log.d(TAG, "doInBackground: " + dir.getAbsolutePath());
        File f = new File(dir, fileName);
        String dataFromFile = "";
        try {
            writeData(f);
            dataFromFile = readData(f);

        } catch (IOException ioe) {

        }
        publishProgress();

        return dataFromFile;
    }


    private void writeData (File f) throws IOException{
            if (!f.exists()) {
                f.createNewFile();
            }
            FileOutputStream fStream = new FileOutputStream(f, true);
            fStream.write(fileData.getBytes());
            fStream.close();

    }

    private String readData (File f) throws IOException {
        FileInputStream fStream = new FileInputStream(f);
        StringBuilder sb = new StringBuilder();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fStream));
        String buffer = "";
        while (buffer != null) {
            buffer = fileReader.readLine();
            sb.append(buffer);
        }

        return sb.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        onFileDataUpdateListener.onFileDataUpdate(result);
        super.onPostExecute(result);
    }


}
