package com.techtown.android.practice102;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static final Integer CALL = 1;
    static final Integer READ_EXST = 2;
    static final Integer CAM = 3;
    static final Integer ACCOUNTS = 4;


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
        ask(view);
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

    public void start(){
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


    private void askForPermission(String permission, Integer requestCode){
        if(ContextCompat.checkSelfPermission(MainActivity.this, permission)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permission)) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
            } else {
                ActivityCompat.requestPermissions( MainActivity.this, new String[]{permission}, requestCode);
            }
        } else {
            //Toast.makeText(this, "" + permission + " is already granted", Toast.LENGTH_SHORT).show();
        }
    }

    public void ask(View view) {
        switch (view.getId()) {
            case R.id.buttonl:
                askForPermission(Manifest.permission.READ_EXTERNAL_STORAGE, READ_EXST);
                break;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode) {
                case 1: // CALL
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "{This is a telephone number}"));
                    //callIntent.setData(Uri.parse("tel:" + “053xxxxxxx"));

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                            == PackageManager.PERMISSION_GRANTED) {
                        startActivity(callIntent);
                    }
                    break;

                case 2: // READ_EXST
                    Intent imageIntent =
                            new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    break;
                case 3: // CAM
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, 3);
                    }
                    break;
            }
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            start();
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }
}
