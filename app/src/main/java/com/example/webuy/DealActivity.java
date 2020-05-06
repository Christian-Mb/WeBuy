package com.example.webuy;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
        TextView promo_before = findViewById(R.id.deal_promo_before);
        promo_before.setPaintFlags(promo_before.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


    }
}
