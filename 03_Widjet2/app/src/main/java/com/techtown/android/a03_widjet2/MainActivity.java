package com.techtown.android.a03_widjet2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRgp;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        final Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast msg = Toast.makeText(
                        MainActivity.this,
                        "일반 버튼이 눌렸습니다.",
                        Toast.LENGTH_SHORT
                );
                msg.show();
            }
        });
*/

        mRgp = (RadioGroup)findViewById(R.id.radioGroup);
        mBtn = (Button)findViewById(R.id.button);

        mRgp.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId==View.NO_ID){
                            mBtn.setText("일반버튼");
                        }
                        else{
                            RadioButton rb = (RadioButton)findViewById(checkedId);
                            mBtn.setText(rb.getText().toString()+" 라디오 버튼 선택됨");
                        }
                    }
                }
        );



    }

    public void onClickButton(View v){

        if (v==findViewById(R.id.button)) {
            mRgp.clearCheck();
            Toast msg =Toast.makeText(
                    this,
                    "일반 버튼이 눌렸습니다.",
                    Toast.LENGTH_SHORT
            );
            msg.show();
        }else if(v==findViewById(R.id.checkBox)){

            Toast msg = Toast.makeText(
                    this,
                    ((CheckBox)v).isChecked()?
                            "체크박스가 활성화되었습니다.":
                            "체크박스가 비활성화되었습니다.",
                    Toast.LENGTH_SHORT
            );
            msg.show();
        }

    }

    public void onClickRadio(View v){

        RadioButton rbtn = (RadioButton)v;
        Button button = (Button)findViewById(R.id.button);
        button.setText(rbtn.getText()+"을(를) 좋아합니다.");

    }


}
