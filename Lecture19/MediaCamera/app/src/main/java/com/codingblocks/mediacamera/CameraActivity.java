package com.codingblocks.mediacamera;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CameraActivity extends AppCompatActivity {

    public static final String TAG = "Camera";

    SurfaceView camSurfaceView;
    Camera myCamera;
    SurfaceHolder sh;
    TextView tvFaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        camSurfaceView = (SurfaceView) findViewById(R.id.camSurface);
        sh = camSurfaceView.getHolder();
        tvFaces = (TextView) findViewById(R.id.tvFaces);


        sh.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                myCamera = Camera.open();
                Camera.Parameters camParams = myCamera.getParameters();

                Log.d(TAG, "surfaceCreated: flash " + camParams.getFlashMode());
                Log.d(TAG, "surfaceCreated: focus " + camParams.getFocusMode());

                List<Camera.Size> sizes = camParams.getSupportedPreviewSizes();
                for (Camera.Size size : sizes ) {
                    Log.d(TAG, "surfaceCreated: previewsize = "
                            + size.width + "x" + size.height);
                }

                for (Camera.Size size: camParams.getSupportedPictureSizes()) {
                    Log.d(TAG, "surfaceCreated: picSize = "
                            + size.width + "x" + size.height);
                }

                camParams.setPreviewSize(1280, 720);

                myCamera.setParameters(camParams);
                myCamera.setDisplayOrientation(90);
                myCamera.setFaceDetectionListener(new Camera.FaceDetectionListener() {
                    @Override
                    public void onFaceDetection(Camera.Face[] faces, Camera camera) {
                        tvFaces.setText("Faces = " + faces.length);
                        for (int i = 0; i < faces.length; i++) {
                            Log.d(TAG, "onFaceDetection: face score "+ faces[i].score);
                            Log.d(TAG, "onFaceDetection: face score "+ faces[i].rect.toString());
                        }
                    }
                });
                try {
                    myCamera.setPreviewDisplay(sh);
                    myCamera.startPreview();
                    myCamera.startFaceDetection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

    }

    @Override
    protected void onPause() {
        try {
            myCamera.stopFaceDetection();
            myCamera.stopPreview();
            myCamera.release();
        } catch (Exception e) {

        }
        super.onPause();
    }
}
