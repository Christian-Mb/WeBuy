package univ.tours.webuy.views.deal;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.webuy.R;
import univ.tours.webuy.views.purshaseGroup.BuyingGroupActivity;

public class DealDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_deal_fragment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.deal));
        setSupportActionBar(toolbar);
        TextView promo_before = findViewById(R.id.deal_promo_before);
        promo_before.setPaintFlags(promo_before.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Button btnParticipate = findViewById(R.id.BtnParticipate);
        btnParticipate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuyingGroupActivity.class);
                startActivity(intent);
            }
        });


    }
}
