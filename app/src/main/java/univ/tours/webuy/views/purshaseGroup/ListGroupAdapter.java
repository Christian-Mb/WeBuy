package univ.tours.webuy.views.purshaseGroup;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;

import java.util.ArrayList;

import univ.tours.webuy.core.pourshaseGroup.PurshaseGroup;
import univ.tours.webuy.core.user.User;

public class ListGroupAdapter extends RecyclerView.Adapter<ListGroupAdapter.MyViewHolder> {

    private ArrayList<PurshaseGroup> purshaseGroups;
    private ArrayList<User> users;
    private Context context;



    public ListGroupAdapter(Context context, ArrayList<PurshaseGroup> purshaseGroups) {
        this.context = context;
        this.purshaseGroups = purshaseGroups;
        users = new ArrayList<>();


    }


    @NonNull
    @Override
    public ListGroupAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.card_group, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.item_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  users = purshaseGroups.get(viewHolder.getAdapterPosition()).getParticipants();

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                DetailsGroupFragment DealFragment = new DetailsGroupFragment();
                DealFragment.setUsers(users);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container, DealFragment).addToBackStack(null).commit();

            }
        });
        return new ListGroupAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListGroupAdapter.MyViewHolder holder, int position) {
        /*if (!purshaseGroups.isEmpty()) {

            holder.title.setText(purshaseGroups.get(position).getDeal().getProduct().getLabel() + " " + purshaseGroups.get(position).getDeal().getStores().getStoreAddress().getDepartment());
            holder.promo_price.setText(String.valueOf(purshaseGroups.get(position).getDeal().getPrice_promo()));
            holder.price_before.setText(String.valueOf(purshaseGroups.get(position).getDeal().getPrice_before_promo()));
            holder.person_left.setText(String.valueOf(purshaseGroups.get(position).getNbrs_users_wanted() - purshaseGroups.get(position).getParticipateToPurshaseUsers().size()));
            holder.quantity_to_buy.setText(String.valueOf(purshaseGroups.get(position).getArticle_quantity()));
            holder.deal_user.setText(String.valueOf(purshaseGroups.get(position).getUser().getUsername()));
            holder.nbrs_users.setText(String.valueOf(purshaseGroups.get(position).getParticipateToPurshaseUsers().size()));
            holder.purshase_time.setText(purshaseGroups.get(position).getDuration() + "min");


        }
*/
    }

    @Override
    public int getItemCount() {
        //return purshaseGroups.size();
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, price_before, promo_price, purshase_time, person_left, quantity_to_buy, deal_user, nbrs_users;


        RelativeLayout item_group;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_group = itemView.findViewById(R.id.rl_main_content_group);
            title = itemView.findViewById(R.id.deal_title);
            promo_price = itemView.findViewById(R.id.deal_promo_after);
            purshase_time = itemView.findViewById(R.id.purshase_time);
            quantity_to_buy = itemView.findViewById(R.id.quantity_to_buy);
            deal_user = itemView.findViewById(R.id.deal_user);
            person_left = itemView.findViewById(R.id.nbr_purshase_group);
            nbrs_users = itemView.findViewById(R.id.nbr_user);
            price_before = itemView.findViewById(R.id.deal_promo_before);
            price_before.setPaintFlags(price_before.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

}
