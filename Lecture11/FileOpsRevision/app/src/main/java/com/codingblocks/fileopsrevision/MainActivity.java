package com.codingblocks.fileopsrevision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // /storage/sdcard1/MyFolder/hello.txt

        // of folder type
        File dir = new File("/storage/sdcard1/MyFolder");
        dir.exists();
        dir.mkdirs();
        dir.isFile(); //false
        dir.listFiles(); // list of files in MyFolder in form of File[]

        // of file type
        File f = new File(dir ,"hello.txt");
        f.exists();
        f.createNewFile();
        f.isDirectory(); //false
        f.listFiles(); // null



        byte a = stream.read();
        stream.read(byte[] a)



    }
}
