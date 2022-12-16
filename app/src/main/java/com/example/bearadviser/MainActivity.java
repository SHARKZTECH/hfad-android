package com.example.bearadviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView brand;
    Spinner colo;

    private BeerExpert expert=new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.findBeer);
        brand=findViewById(R.id.brand);
        colo=findViewById(R.id.color);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value=String.valueOf(colo.getSelectedItem());
                List<String> results=expert.getBrands(value);
                StringBuilder brands=new StringBuilder();

                for(String brand:results){
                     brands.append(brand).append("\n");
                }
                brand.setText(brands);

            }
        });
    }
}