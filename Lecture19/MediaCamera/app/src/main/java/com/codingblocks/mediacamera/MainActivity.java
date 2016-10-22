package com.codingblocks.mediacamera;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean streaming = true;

        String myUrl = "http://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";

        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(myUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (streaming) {
            mediaPlayer.prepareAsync();
            mediaPlayer.start();
        } else {
            //Playing after downloading
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    mediaPlayer.start();
                }
            }.execute();
        }



    }
}
