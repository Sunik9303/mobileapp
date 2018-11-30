package com.techtown.android.a10_videoview;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private String mSdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String mVideoFile = "video.mp4";
    private String path = mSdPath + "/" + mVideoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = (VideoView)findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(MainActivity.this);
        mediaController.setAnchorView(mVideoView);
        Log.d("4csoft", "----     path: " + path);

        if(path == "") {
            Toast.makeText(MainActivity.this,
                    "Please edit VideoView Activity, and set path"
                            + " variable to your media file URL/path",
                    Toast.LENGTH_LONG).show();
        } else {
            mVideoView.setMediaController(mediaController);
            mVideoView.setVideoPath(path);
            mVideoView.start();
        }

    }
}
