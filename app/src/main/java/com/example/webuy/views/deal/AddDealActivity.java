package com.example.webuy.views.deal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.webuy.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddDealActivity extends AppCompatActivity {
    static final int RESULT_LOAD_IMG = 1;
    LinearLayout linearLayout;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dealv2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.add_an_offer));
        setSupportActionBar(toolbar);
        Spinner spinner_magazin = findViewById(R.id.store_choice);
        ArrayAdapter<CharSequence> magazin_adapter = ArrayAdapter.createFromResource(this, R.array.magazin, android.R.layout.simple_spinner_item);
        magazin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_magazin.setAdapter(magazin_adapter);

        Spinner spinner_departement = findViewById(R.id.store_address_choice);
        ArrayAdapter<CharSequence> departement_adapter = ArrayAdapter.createFromResource(this, R.array.departement, android.R.layout.simple_spinner_item);
        departement_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_departement.setAdapter(departement_adapter);


        imageView = findViewById(R.id.camera);
        linearLayout = findViewById(R.id.linearLayout);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                startActivityForResult(photoPicker, RESULT_LOAD_IMG);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                linearLayout.setAlpha(0);
                imageView.setVisibility(View.GONE);
                Drawable drawable = new BitmapDrawable(getApplicationContext().getResources(), selectedImage);
                linearLayout.setBackground(drawable);
                //TODO Save image on server
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), getString(R.string.unknown_error), Toast.LENGTH_LONG).show();

            }

        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.choose_image), Toast.LENGTH_LONG).show();

        }
    }
}
