package com.codingblocks.files;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etFileName, etFileData;
    Button btnWrite;
    TextView tvFileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFileData = (EditText) findViewById(R.id.etFileData);
        etFileName = (EditText) findViewById(R.id.etFileName);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        tvFileData = (TextView) findViewById(R.id.tvFileData);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeFile(etFileName.getText().toString(),
                        etFileData.getText().toString());
            }
        });
    }


    private void writeFile (String fileName, String fileData) {
        FileWriteTask fTask = new FileWriteTask(fileName, fileData);
        fTask.setOnFileDataUpdateListener(new FileWriteTask.OnFileDataUpdateListener() {
            @Override
            public void onFileDataUpdate(String fileData) {
                tvFileData.setText(fileData);
            }
        });
        fTask.execute();
    }
}
