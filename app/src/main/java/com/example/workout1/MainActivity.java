package com.example.workout1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {
    ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.book){
            Toast.makeText(this, "Comming soon...", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClicked(int id) {
        View fragment=findViewById(R.id.fragment_container);
        if(fragment !=null){
            WorkoutDetailFragment detailFragment=new WorkoutDetailFragment();
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            detailFragment.setWorkoutId(id);

            ft.replace(R.id.fragment_container,detailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }else{
            Intent intent=new Intent(MainActivity.this,DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID,id);
            startActivity(intent);
        }

    }
}