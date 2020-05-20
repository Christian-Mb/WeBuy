package com.example.webuy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DealListAdapter extends RecyclerView.Adapter<DealListAdapter.MyViewHolder> {

    Context context;
    String[] dTitle;
    String[] dDescription;
    int[] dCodePostal;

    public DealListAdapter(Context c, String[] dTitle, String[] dDescription, int[] dCodePostal) {
        this.context = c;
        this.dTitle = dTitle;
        this.dDescription = dDescription;
        this.dCodePostal = dCodePostal;
    }

    @NonNull
    @Override
    public DealListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.deal_cardview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.item_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DealActivity.class));
            }
        });
        return new DealListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealListAdapter.MyViewHolder holder, int position) {
        holder.title.setText(dTitle[position] + " " + dCodePostal[position]);
    }

    @Override
    public int getItemCount() {
        return dTitle.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, descrption, promo_before;
        RelativeLayout item_deal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_deal = itemView.findViewById(R.id.rl_main_content_deal);
            title = itemView.findViewById(R.id.EnseigneText);
            promo_before = itemView.findViewById(R.id.deal_promo_before);
            promo_before.setPaintFlags(promo_before.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

}
