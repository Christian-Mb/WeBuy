package com.example.webuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bnSign = findViewById(R.id.btnConnect);
        Button deals= findViewById(R.id.btnDeal);
        deals.setOnClickListener(deal);
        bnSign.setOnClickListener(connect);
        ImageView img = findViewById(R.id.imageAccueil);
        img.setImageDrawable(getDrawable(R.drawable.accueil));
    }

    View.OnClickListener connect = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener deal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), StartActivity.class);
            startActivity(intent);
        }
    };
}
