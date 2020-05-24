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
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;

public class StoreCircleAdapter extends RecyclerView.Adapter<StoreCircleAdapter.MyViewHolder> {


    int[] logo;
    Context context;


    public StoreCircleAdapter(Context ct, int[] logo) {
        this.context = ct;
        this.logo = logo;
    }

    @NonNull
    @Override
    public StoreCircleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.card_ring_store, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.item_magazin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                StoreFragment storeFragment = new StoreFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, storeFragment).addToBackStack(null).commit();
            }

        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreCircleAdapter.MyViewHolder holder, int position) {
        holder.logo.setImageResource(logo[position]);
    }

    @Override
    public int getItemCount() {
        return logo.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, dealsNumber, storesNumber;
        ImageView logo;
        RelativeLayout item_magazin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.imageView1);
            item_magazin = itemView.findViewById(R.id.ring);
        }
    }

}
