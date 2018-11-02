package com.techtown.android.a04_fragmenttest3;


import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WordsFragment extends ListFragment {
    OnWordsSelectedListener mCallback; //액티비티를 참조하는 변수

    public interface OnWordsSelectedListener{
        public void onWordSelected(int position);
    }

    public WordsFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1: android.R.layout.simple_list_item_1;
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Data.words));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mCallback = (OnWordsSelectedListener) activity;
        }catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnWordSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallback.onWordSelected(position);
        getListView().setItemChecked(position, true);
    }

}
