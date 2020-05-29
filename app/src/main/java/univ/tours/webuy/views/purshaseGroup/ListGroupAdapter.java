package univ.tours.webuy.views.purshaseGroup;

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

import com.example.webuy.R;
import univ.tours.webuy.views.deal.DealDetailsActivity;

public class ListGroupAdapter extends RecyclerView.Adapter<ListGroupAdapter.MyViewHolder> {

    Context context;
    String[] dTitle;
    String[] dDescription;
    int[] dCodePostal;

    public ListGroupAdapter(Context c, String[] dTitle, String[] dDescription, int[] dCodePostal) {
        this.context = c;
        this.dTitle = dTitle;
        this.dDescription = dDescription;
        this.dCodePostal = dCodePostal;
    }

    @NonNull
    @Override
    public ListGroupAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_group, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.item_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DealDetailsActivity.class));
            }
        });
        return new ListGroupAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListGroupAdapter.MyViewHolder holder, int position) {
        holder.title.setText(dTitle[position] + " " + dCodePostal[position]);
    }

    @Override
    public int getItemCount() {
        return dTitle.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, descrption, promo_before;

        RelativeLayout item_group;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_group = itemView.findViewById(R.id.rl_main_content_group);
            title = itemView.findViewById(R.id.EnseigneText);
            promo_before = itemView.findViewById(R.id.deal_promo_before);
            promo_before.setPaintFlags(promo_before.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

}
