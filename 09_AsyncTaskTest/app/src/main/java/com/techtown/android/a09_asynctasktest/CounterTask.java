package com.techtown.android.a09_asynctasktest;
import android.os.AsyncTask;
import android.widget.TextView;

public class CounterTask extends AsyncTask<Integer, Integer, Integer> {
    TextView mOutput;
    int mCount = 0;
    int total = 0;

    public void setOutputView(TextView txt) {
        mOutput = txt;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCount = 0;
    }

    @Override
    protected Integer doInBackground(Integer... integers) { // 내부 스레드에서 진행 됨
        for(int i = 0; i < integers[0]; i++) {
            mCount++;
            total = total + mCount;
            publishProgress(mCount,total); // trigger the execution of onProgressUpdate( )
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {;}
        }
        return total;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mOutput.setText("진행상황: " + values[0]
        +"\n현재까지합: "+values[1]);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        mOutput.setText("결과: " + integer);
    }

    @Override
    protected void onCancelled(Integer integer) {
        super.onCancelled(integer);
        mOutput.setText("취소됨");
    }
}
