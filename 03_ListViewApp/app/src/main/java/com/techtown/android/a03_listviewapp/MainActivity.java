package com.techtown.android.a03_listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Android");
        arrayList.add("Apple");
        arrayList.add("Nokia");
        arrayList.add("Rim");
        arrayList.add("Microsoft");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.item,
                R.id.name,
                arrayList
        );

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList

        );*/

        listView.setAdapter(adapter);

    }
}
