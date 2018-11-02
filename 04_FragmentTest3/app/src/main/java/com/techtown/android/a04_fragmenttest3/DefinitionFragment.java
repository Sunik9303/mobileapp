package com.techtown.android.a04_fragmenttest3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DefinitionFragment extends Fragment {


    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    TextView def;

    public DefinitionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        View fragmentView = inflater.inflate(R.layout.fragment_definition, container, false);
        def = (TextView) fragmentView.findViewById(R.id.definition);
        return fragmentView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if(args != null) {
            updateDefinitionView(args.getInt(ARG_POSITION));
        }else if(mCurrentPosition != -1) {
            updateDefinitionView(mCurrentPosition);
        }
    }

    public void updateDefinitionView(int position){
        def.setText(Data.definitions[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("destroy","definition fragment destroyed");
    }
}
