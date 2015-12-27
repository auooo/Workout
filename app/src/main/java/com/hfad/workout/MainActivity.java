package com.hfad.workout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity
                            implements WorkoutListFragment.WorkoutListListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
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
        } else {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id);
            startActivity(intent);
        }
    }
}
