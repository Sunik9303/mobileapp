package com.techtown.android.a10_audio;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer = null;
    private ProgressBar mProgressBar = null;
    private SeekBar mSeekBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMusic();
    }


    @Override
    protected void onDestroy() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        super.onDestroy();
    }

    private void initMusic() {
        mMediaPlayer = MediaPlayer.create(this, R.raw.music);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mProgressBar.setProgress(0);
        mProgressBar.setMax(0);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("progress","progress : "+progress);
                //Log.i("progress","calculation : "+mMediaPlayer.getDuration()*1000*progress);
                mMediaPlayer.seekTo(progress);
                mSeekBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ProgressThread thread = new ProgressThread();
        thread.setDaemon(true);
        thread.start();
    }


    public void startMusic(View view) {
        Button button;
        button = (Button)findViewById(R.id.button1);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button2);
        button.setEnabled(true);

        mProgressBar.setProgress(0);
        mProgressBar.setMax(mMediaPlayer.getDuration());
        mSeekBar.setMax(mMediaPlayer.getDuration());
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();

    }

    public void stopMusic(View view) {
        mMediaPlayer.stop();
        initMusic();

        Button button;
        button = (Button)findViewById(R.id.button1);
        button.setEnabled(true);
        button = (Button)findViewById(R.id.button2);
        button.setEnabled(false);

        mProgressBar.setProgress(0);
        mProgressBar.setMax(0);
        mSeekBar.setProgress(0);
        TextView output = (TextView)findViewById(R.id.textView);
        output.setText("중지");
    }

    public void pauseMusic(View view) {
        if(mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            TextView output = (TextView)findViewById(R.id.textView);
            output.setText("일시정지");
            Button button = (Button)findViewById(R.id.button3);
            button.setText("계속");

        } else {
            mMediaPlayer.start();
            Button button = (Button)findViewById(R.id.button3);
            button.setText("일시정지");
        }
    }

    public void showProgress() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mProgressBar.setProgress(mMediaPlayer.getCurrentPosition());
            //mSeekBar.setProgress(mMediaPlayer.getCurrentPosition());
            TextView output = (TextView) findViewById(R.id.textView);
            output.setText("재생 중"
                    + "\n현재 위치: " + mMediaPlayer.getCurrentPosition() / 1000
                    + "\n전체 길이: " + mMediaPlayer.getDuration() / 1000);
            Log.i("progress","mMediaPlayer.getDuration() : "+mMediaPlayer.getCurrentPosition());
            mSeekBar.setProgress(mMediaPlayer.getCurrentPosition());
        }
    }


    class ProgressThread extends Thread {
        public Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what  == 1) {
                    showProgress();
                }
            }
        };

        @Override
        public void run() {
            super.run();
            while(mMediaPlayer != null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                mHandler.sendMessage(Message.obtain(mHandler, 1));
            }
        }
    }



}
