package univ.tours.webuy.views.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import univ.tours.webuy.core.user.User;

public class UserCircleAdapter extends RecyclerView.Adapter<UserCircleAdapter.MyViewHolder> {


    private ArrayList<User> users;

    private Context context;


    public UserCircleAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;

    }

    @NonNull
    @Override
    public UserCircleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.card_ring_store, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.item_magazin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                //Afficher des detais sur l'utilisateur

            }

        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserCircleAdapter.MyViewHolder holder, int position) {
        if (!users.isEmpty()) Picasso.get().load(users.get(position).getAvatar()).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView logo;
        RelativeLayout item_magazin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.imageView1);
            item_magazin = itemView.findViewById(R.id.ring);
        }
    }

}
