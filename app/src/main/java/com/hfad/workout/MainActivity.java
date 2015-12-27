package com.hfad.workout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity
                            implements WorkoutListFragment.WorkoutListListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        // the code to set the detail will go here
        WorkoutDetailFragment details = new WorkoutDetailFragment();
        // start the fragment transaction
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        details.setWorkoutId(id);
        // replace the fragment and add it to the back stack
        ft.replace(R.id.fragment_container, details);
        ft.addToBackStack(null);
        // get the new and old fragment to fade in and out
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // commit the changes to the activity
        ft.commit();
    }
}
