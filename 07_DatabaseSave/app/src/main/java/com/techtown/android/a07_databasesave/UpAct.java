package com.techtown.android.a07_databasesave;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class UpAct extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up);
        loadDB();
    }

    public void loadDB(){
        SQLiteDatabase db = openOrCreateDatabase(
                "student.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null);

        db.execSQL("CREATE TABLE IF NOT EXISTS people"
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, sno INTEGER , name TEXT, age INTEGER);" );

        Cursor c = db.rawQuery("SELECT * FROM people;",null);
        startManagingCursor(c);

        ListAdapter adapt = new SimpleCursorAdapter(
                this,
                R.layout.listview3,
                c,
                new String[]{"sno","name","age"},
                new int[]{R.id.text1,R.id.text2,R.id.text3},0);

        setListAdapter(adapt);

        if(db != null){
            db.close();
        }
    }

    public void onClickButton(View v){

        EditText txt1 = null;
        EditText txt2 = null;
        EditText txt3 = null;
        txt1 = (EditText)findViewById(R.id.editText1);
        String sno = txt1.getText().toString();
        txt2 = (EditText)findViewById(R.id.editText2);
        String name = txt2.getText().toString();
        txt3 = (EditText)findViewById(R.id.editText3);
        String age = txt3.getText().toString();


        if(Integer.parseInt(age)<=150){

            String sql = "UPDATE people SET name = '"+name+ "',age = '"+age +"' WHERE sno = "+sno+";";

            SQLiteDatabase db = openOrCreateDatabase(
                    "student.db",
                    SQLiteDatabase.CREATE_IF_NECESSARY,
                    null);

            db.execSQL(sql);

        }else{

            Toast.makeText(this,"나이는 150 이내의 숫자 입니다.",Toast.LENGTH_SHORT).show();

        }

        txt1.setText("");
        txt2.setText("");
        txt3.setText("");

        loadDB();

    }


}
