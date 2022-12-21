package com.example.starbuuz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        ImageView imageView=findViewById(R.id.img);
        TextView name=findViewById(R.id.name);
        TextView desc=findViewById(R.id.desc);

        int drinkId= (int) getIntent().getExtras().get(EXTRA_DRINK);
        Drinks drinks=Drinks.drinks[drinkId];

        imageView.setImageResource(drinks.getImageId());
        imageView.setContentDescription(drinks.getName());
        name.setText(drinks.getName());
        desc.setText(drinks.getDescription());


    }
}