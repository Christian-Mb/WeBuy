package com.example.webuy;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AddDeal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deal);
        Spinner spinner_magazin = findViewById(R.id.magazin);
        ArrayAdapter<CharSequence> magazin_adapter = ArrayAdapter.createFromResource(this, R.array.magazin, android.R.layout.simple_spinner_item);
        magazin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_magazin.setAdapter(magazin_adapter);

        Spinner spinner_departement = findViewById(R.id.departement);
        ArrayAdapter<CharSequence> departement_adapter = ArrayAdapter.createFromResource(this, R.array.departement, android.R.layout.simple_spinner_item);
        departement_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_departement.setAdapter(departement_adapter);
    }
}
