package com.example.test.a08_callcp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View v) {
        TextView txt = (TextView) findViewById(R.id.textView1);
        ContentResolver cr = getContentResolver();
        Cursor cur = null;
        String result = "";
        switch (v.getId()) {
            case R.id.button1:// 전부 읽기
                cur = cr.query(Uri.parse("content://a07_databasesave.test/people"),
                        null, null, null, null);

                if (cur == null) {
                    txt.setText("CP를 열 수 없습니다.");
                    break;
                }
                result = "학번|이름|나이\n";
                while (cur.moveToNext()) {
                    result += cur.getString(1);
                    result += " | ";
                    result += cur.getString(2);
                    result += " | ";
                    result += cur.getString(3);
                    result += "\n";
                }
                txt.setText(result);
            break;

            case R.id.button2:
                EditText name = (EditText)findViewById(R.id.editText1);
                cur = cr.query(Uri.parse("content://a07_databasesave.test/people/"+name.getText().toString()),
                null, null, null, null);
                if (cur == null) {
                    txt.setText("CP를 열 수 없습니다.");
                    break;
                }
                result = "학번|이름|나이\n";
                while (cur.moveToNext()) {
                    result += cur.getString(1);
                    result += " | ";
                    result += cur.getString(2);
                    result += " | ";
                    result += cur.getString(3);
                    result += "\n";
                }
                txt.setText(result);
                break;

            case R.id.button3:
                cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
                if(cur==null){
                    txt.setText("주소록 CP를 열 수 없습니다.");
                    break;
                }

                int colId = cur.getColumnIndex(ContactsContract.Contacts._ID);
                int colName = cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                int colHasPhone = cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);

                result ="대표이름|전화번호\n";
                while(cur.moveToNext()) {
                    result += cur.getString(colName);
                    result += "|";
                    result += cur.getString(colHasPhone);
                    result += "\n";
                }
                txt.setText(result);
                break;
        }
    }
}
