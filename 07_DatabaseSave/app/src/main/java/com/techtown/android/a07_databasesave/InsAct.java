package com.techtown.android.a07_databasesave;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins);
    }

    public void onClickButton(View v){
        EditText txt = null;
        txt = (EditText)findViewById(R.id.editText1);
        String sno = txt.getText().toString();
        txt = (EditText)findViewById(R.id.editText2);
        String name = txt.getText().toString();
        txt = (EditText)findViewById(R.id.editText3);
        String age = txt.getText().toString();

        if(Integer.parseInt(age)<=150){

            String sql = "INSERT INTO people (sno,name, age) Values ("+sno+",'"+name + "',"+age+");";

            SQLiteDatabase db = openOrCreateDatabase(
                    "student.db",
                    SQLiteDatabase.CREATE_IF_NECESSARY,
                    null);

            db.execSQL(sql);

            finish();

        }else{

            Toast.makeText(this,"나이는 150 이내의 숫자 입니다.",Toast.LENGTH_SHORT).show();

        }


    }


}
