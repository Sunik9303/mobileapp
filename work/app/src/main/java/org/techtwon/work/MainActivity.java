package org.techtwon.work;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int limit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveBtn = (Button)findViewById(R.id.save);
        Button cancelBtn = (Button)findViewById(R.id.cancel);
        Button exitBtn = (Button)findViewById(R.id.exit);
        final EditText editText = (EditText)findViewById(R.id.editText);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                limit = charSequence.toString().length();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        editText.addTextChangedListener(textWatcher);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(limit>=50){
                    Toast msg = Toast.makeText(MainActivity.this, "저장할 수 없습니다.",Toast.LENGTH_SHORT);
                    msg.show();
                }else{
                    Toast msg = Toast.makeText(MainActivity.this, editText.getText().toString()+"가 save 되었습니다.",Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText.setText("");
                Toast msg = Toast.makeText(MainActivity.this, "cancel 버튼이 클릭되었습니다.",Toast.LENGTH_SHORT);
                msg.show();

            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast msg = Toast.makeText(MainActivity.this, "exit 버튼이 클릭되었습니다.",Toast.LENGTH_SHORT);
                msg.show();
            }
        });

    }

}
