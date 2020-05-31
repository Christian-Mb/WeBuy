package univ.tours.webuy.views.deal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.webuy.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import univ.tours.webuy.core.deal.Deal;
import univ.tours.webuy.core.utils.Logs;
import univ.tours.webuy.views.purshaseGroup.BuyingGroupActivity;

public class DealDetailsActivity extends AppCompatActivity {

    Deal deal;
    private ArrayList<Deal> deals;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_deal_fragment);
        Intent intent = getIntent();
        deals = (ArrayList<Deal>) intent.getSerializableExtra("deal");

        position = intent.getIntExtra("position", 0);
        deal = deals.get(1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        Logs.info(this, deal.toString());

        toolbar.setTitle(getString(R.string.deal));
        setSupportActionBar(toolbar);


        init();


        Button btnParticipate = findViewById(R.id.BtnParticipate);
        btnParticipate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuyingGroupActivity.class);
                startActivity(intent);
            }
        });


    }


    public void init() {

        ImageView im = findViewById(R.id.img);


        Picasso.get().load(deal.getProduct().getImage()).into(im);
        TextView title = findViewById(R.id.deal_title_detail);
        title.setText(deal.getProduct().getLabel());
        TextView price_after = findViewById(R.id.deal_promo_after);
        price_after.setText(deal.getPrice_promo() + "");
        TextView price_before = findViewById(R.id.deal_promo_before);
        price_before.setText(String.valueOf(deal.getPrice_before_promo()));
        TextView user = findViewById(R.id.deal_user);
        // user.setText(deal.getUser().getUsername()+"");
        TextView content = findViewById(R.id.deal_description);
        content.setText(deal.getProduct().getContent());
        TextView available = findViewById(R.id.deal_stock);
        //available.setText(String.valueOf(deal.getQuantity_available()));
        TextView to_buy = findViewById(R.id.nbr_available);
        to_buy.setText(deal.getQuantity_min_to_Buy() + "");
        TextView store_title = findViewById(R.id.txt_store_title);
        store_title.setText(deal.getStores().getNom());
        TextView store_address = findViewById(R.id.txt_store_address);
        store_address.setText(deal.getStores().getStoreAddress().getDepartment());

    }
}
