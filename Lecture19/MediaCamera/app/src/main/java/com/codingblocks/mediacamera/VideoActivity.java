package com.codingblocks.mediacamera;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (VideoView) findViewById(R.id.videoView);
        mediaController = new MediaController(this);

        videoView.setVideoPath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/small.mp4");
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.start();

    }
}
