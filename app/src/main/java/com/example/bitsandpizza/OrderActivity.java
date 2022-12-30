package com.example.bitsandpizza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class OrderActivity extends AppCompatActivity {
     Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton btn=findViewById(R.id.btnDone);
        btn.setOnClickListener(view -> {
            Snackbar snackbar=Snackbar.make(findViewById(R.id.coordinator),"Your Order has been updated",Snackbar.LENGTH_SHORT);
            snackbar.setAction("Undo",view1 -> {
                Toast.makeText(this, "Undone!", Toast.LENGTH_SHORT).show();
            });
            snackbar.show();
        });
    }
}