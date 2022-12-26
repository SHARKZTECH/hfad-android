package com.example.workout1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "workoutId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        WorkoutDetailFragment fragment=
                (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.desc_fragment);

        int workoutId= (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        fragment.setWorkoutId(workoutId);
    }
}