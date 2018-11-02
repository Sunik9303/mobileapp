package com.techtown.android.a04_fragmenttest2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
        }

        FragmentA firstFragment = new FragmentA();
        firstFragment.setArguments(getIntent().getExtras());

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,firstFragment).commit();

    }

    public void selectFragment(View view){

        Fragment fr = null;

        switch(view.getId()){

            case R.id.btnA:
                fr = new FragmentA();
                break;

            case R.id.btnB:
                fr = new FragmentB();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
