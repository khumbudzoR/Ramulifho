package com.example.codetribe.copy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String TAG = "MainActivity";

            ImageView Animals = (ImageView) findViewById(R.id.Animals);


            Animals.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent AnimalsIntent = new Intent(MainActivity.this,Animals.class);
                    startActivity(AnimalsIntent);
                }
            });


            ImageView Fruits = (ImageView) findViewById(R.id.Fruits);


            Fruits.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent FruitsIntent = new Intent(MainActivity.this, Fruits.class);
                    startActivity(FruitsIntent);
                }
            });


            ImageView Shapes = (ImageView) findViewById(R.id.Shapes);


            Shapes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent ShapesIntent = new Intent(MainActivity.this, Colours.class);
                    startActivity(ShapesIntent);
                }
            });


            ImageView Months = (ImageView) findViewById(R.id.Months);


            Months.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent MonthsIntent = new Intent(MainActivity.this, Months.class);
                    startActivity(MonthsIntent);
                }
            });
        }
    }
