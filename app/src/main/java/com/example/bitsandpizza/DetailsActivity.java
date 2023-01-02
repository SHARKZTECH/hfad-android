package com.example.bitsandpizza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_PIZZA_ID = "pizzaId";
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

          toolbar=findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);

       ActionBar actionBar=getSupportActionBar();
       actionBar.setDisplayHomeAsUpEnabled(true);

        int pizzaId= (int) getIntent().getExtras().get(EXTRA_PIZZA_ID);

        ImageView imageView=findViewById(R.id.img);
        TextView textView=findViewById(R.id.text);

        imageView.setImageResource(Pizza.pizza[pizzaId].getImgId());
        textView.setText(Pizza.pizza[pizzaId].getName());


    }

}