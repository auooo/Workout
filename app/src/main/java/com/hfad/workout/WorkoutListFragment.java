package com.hfad.workout;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutListFragment extends ListFragment {

    interface WorkoutListListener {
        void itemClicked(long id);
    }

    private WorkoutListListener listListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, names);
        setListAdapter(listAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        Log.d("aaaabbb", "aaaaaa");
//        this.listListener = (WorkoutListListener)activity;
//    }


    @Override
    public void onAttach(Context context) {
        Log.d("=======", "onAttach");
        super.onAttach(context);
        Activity activity = (Activity) context;
        this.listListener = (WorkoutListListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listListener != null) {
            listListener.itemClicked(id);
        }
    }
}