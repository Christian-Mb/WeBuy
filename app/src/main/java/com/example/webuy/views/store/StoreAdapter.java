package com.example.webuy.views.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.example.webuy.views.deal.DealFragment;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    String[] titre, dealsNumber, storesNumber;
    int[] logo;
    Context context;


    public StoreAdapter(Context ct, String[] titre, String[] dealsNumber, String[] storesNumber, int[] logo) {
        this.context = ct;
        this.titre = titre;
        this.dealsNumber = dealsNumber;
        this.storesNumber = storesNumber;
        this.logo = logo;
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
                Fragment selectedFragment = new DealFragment();
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                DealFragment DealFragment = new DealFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, DealFragment).addToBackStack(null).commit();
            }

        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.MyViewHolder holder, int position) {
        holder.title.setText(titre[position]);
        holder.dealsNumber.setText(dealsNumber[position]);
        holder.storesNumber.setText(storesNumber[position]);
        holder.logo.setImageResource(logo[position]);
    }

    @Override
    public int getItemCount() {
        return titre.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, dealsNumber, storesNumber;
        ImageView logo;
        RelativeLayout item_magazin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_magazin = itemView.findViewById(R.id.rl_main_content);
            title = itemView.findViewById(R.id.EnseigneText);
            dealsNumber = itemView.findViewById(R.id.current_deals);
            storesNumber = itemView.findViewById(R.id.stores_numbers);
            logo = itemView.findViewById(R.id.logo);
        }
    }

}
