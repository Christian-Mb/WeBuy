package univ.tours.webuy.views.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.webuy.R;

import univ.tours.webuy.views.home.HomeActivity;


public class AccountInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_fragment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("My Account");
        setSupportActionBar(toolbar);
        TextView rel = findViewById(R.id.back);
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save the account information
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go back!
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }


}
