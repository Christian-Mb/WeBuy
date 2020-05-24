package com.example.webuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.webuy.views.account.AccountActivity;
import com.example.webuy.views.onboarding.OnboardingActivity;

public class MainActivity extends AppCompatActivity {

    View.OnClickListener connect = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener deal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), OnboardingActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bnSign = findViewById(R.id.btnConnect);
        Button deals = findViewById(R.id.btnDeal);
        deals.setOnClickListener(deal);
        bnSign.setOnClickListener(connect);
        ImageView img = findViewById(R.id.imageAccueil);
        img.setImageDrawable(getDrawable(R.drawable.accueil));
    }
}
