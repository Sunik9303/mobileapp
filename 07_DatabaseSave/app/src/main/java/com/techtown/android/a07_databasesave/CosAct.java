package com.techtown.android.a07_databasesave;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class CosAct extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos);
        loadDB();
    }

    public void loadDB(){
        SQLiteDatabase db = openOrCreateDatabase(
                "student.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null);

        db.execSQL("CREATE TABLE IF NOT EXISTS student0"
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, sno INTEGER , name TEXT, age INTEGER);" );

        Cursor c = db.rawQuery("SELECT * FROM student0;",null);
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
        EditText txt = null;
        txt = (EditText)findViewById(R.id.edit1);
        String query = txt.getText().toString();

        SQLiteDatabase db = openOrCreateDatabase(
                "student.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null);

        db.execSQL(query);

        txt.setText("");

        loadDB();

    }

}
