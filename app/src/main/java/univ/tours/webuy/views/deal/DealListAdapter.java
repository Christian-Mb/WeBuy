package univ.tours.webuy.views.deal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import univ.tours.webuy.core.deal.Deal;

public class DealListAdapter extends RecyclerView.Adapter<DealListAdapter.MyViewHolder> {

    private ArrayList<Deal> deals;
    private Context context;

    public DealListAdapter(Context context, ArrayList<Deal> deals) {
        this.context = context;
        this.deals = deals;
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
                context.startActivity(new Intent(context, DealDetailsActivity.class));
            }
        });
        return new DealListAdapter.MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DealListAdapter.MyViewHolder holder, int position) {
        if (!deals.isEmpty()) {

            holder.title.setText(deals.get(position).getProduct().getLabel() + " " +
                    deals.get(position).getStores().getStoreAddress().getDepartment());
            holder.promo_price.setText(String.valueOf(deals.get(position).getPrice_promo()));
            holder.price_before.setText(String.valueOf(deals.get(position).getPrice_before_promo()));
            holder.quantity_available.setText(String.valueOf(deals.get(position).getQuantity_available()));
            holder.quantity_to_buy.setText(String.valueOf(deals.get(position).getQuantity_min_to_Buy()));
            holder.deal_user.setText(String.valueOf(deals.get(position).getUser().getUsername()));
            holder.deal_likes.setText(String.valueOf(deals.get(position).getUserLike()));
            holder.deal_unlikes.setText(String.valueOf(deals.get(position).getUserDislike()));
            holder.nbr_group_purshase.setText(String.valueOf(deals.get(position).getPurshaseGroup().size()));
            Timestamp beginAt = deals.get(position).getStartedAt();
            Timestamp endAt = deals.get(position).getEndedAt();
            LocalDate now = LocalDate.now();
            Timestamp t = Timestamp.valueOf(now.toString());
            if (t.before(endAt)) {
                Long duree = t.getTime() - beginAt.getTime() / 60;
                if (duree / 60 != 0) {
                    holder.deal_time.setText(duree + "min");
                } else {
                    holder.deal_time.setText(duree / 60 + "h");
                }

            }
        }

    }

    @Override
    public int getItemCount() {
        //return deals.size();
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, price_before, promo_price, deal_time, quantity_available, quantity_to_buy, deal_user, deal_likes, deal_unlikes, nbr_group_purshase;
        RelativeLayout item_deal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_deal = itemView.findViewById(R.id.rl_main_content_deal);
            title = itemView.findViewById(R.id.deal_title);
            promo_price = itemView.findViewById(R.id.deal_promo_after);
            deal_time = itemView.findViewById(R.id.purshase_time);
            quantity_available = itemView.findViewById(R.id.nbrs_left_person);
            quantity_to_buy = itemView.findViewById(R.id.quantity_to_buy);
            deal_user = itemView.findViewById(R.id.deal_user);
            deal_likes = itemView.findViewById(R.id.deal_likes);
            deal_unlikes = itemView.findViewById(R.id.deal_unlike);
            nbr_group_purshase = itemView.findViewById(R.id.nbr_purshase_group);
            price_before = itemView.findViewById(R.id.deal_promo_before);
            price_before.setPaintFlags(price_before.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

}
