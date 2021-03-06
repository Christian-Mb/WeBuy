package univ.tours.webuy.views.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import univ.tours.webuy.core.deal.Deal;
import univ.tours.webuy.core.store.Store;
import univ.tours.webuy.views.deal.DealFragment;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    ArrayList<Store> stores;
    Context context;
    ArrayList<Deal> deals;


    public StoreAdapter(Context context, ArrayList<Store> stores, ArrayList<Deal> deals) {
        this.context = context;
        this.stores = stores;
        this.deals = deals;


    }

    @NonNull
    @Override
    public StoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.match_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.item_magazin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                DealFragment DealFragment = new DealFragment();
                DealFragment.setDeals(deals);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, DealFragment).addToBackStack(null).commit();
            }

        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.MyViewHolder holder, int position) {
        if (!stores.isEmpty()) {
            holder.title.setText(stores.get(position).getNom());
            int nbrs = (int) Math.random() * 100;
            int b = (int) Math.random() * 100;
            holder.dealsNumber.setText("" + nbrs);
            holder.storesNumber.setText("" + b);
            Picasso.get().load(stores.get(position).getLogo()).into(holder.logo);

        }

    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, dealsNumber, storesNumber;
        ImageView logo;
        RelativeLayout item_magazin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_magazin = itemView.findViewById(R.id.rl_main_content);
            title = itemView.findViewById(R.id.deal_title);
            dealsNumber = itemView.findViewById(R.id.current_deals);
            storesNumber = itemView.findViewById(R.id.stores_numbers);
            logo = itemView.findViewById(R.id.logo);
        }
    }

}
