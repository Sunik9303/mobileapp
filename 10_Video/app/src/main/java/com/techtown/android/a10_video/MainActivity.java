package com.techtown.android.a10_video;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer = null;
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private String mSdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String mVideoFile = "video.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSurfaceView = (SurfaceView)findViewById(R.id.surfaceView);
        mSurfaceHolder = mSurfaceView.getHolder();
        //mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mMediaPlayer = new MediaPlayer();
    }

    @Override
    protected void onDestroy() {
        if(mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        super.onDestroy();
    }

    public void startVideo(View view) {
        try {
            mMediaPlayer.setDataSource(mSdPath + "/" + mVideoFile);
            mMediaPlayer.setDisplay(mSurfaceHolder);
            mMediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }

    public void stopVideo(View view) {
        mMediaPlayer.stop();
        mMediaPlayer.reset();
    }
}
