package univ.tours.webuy.views.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.webuy.R;

import java.util.ArrayList;

import univ.tours.webuy.core.deal.Deal;
import univ.tours.webuy.core.store.Store;
import univ.tours.webuy.core.utils.Logs;
import univ.tours.webuy.views.deal.DealFragment;
import univ.tours.webuy.views.deal.DealHorizontalFragment;
import univ.tours.webuy.views.store.StoreCircleFragment;
import univ.tours.webuy.views.store.StoreFragment;


public class HomeFragment extends Fragment {
    ArrayList<Deal> deals;
    private TextView seeMoreStores, seeMoreDeals;
    private ArrayList<Store> stores;

    public HomeFragment() {
        // Required empty public constructor
        stores = new ArrayList<>();
        deals = new ArrayList<>();
    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public void setDeals(ArrayList<Deal> deals) {
        this.deals = deals;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        seeMoreDeals = view.findViewById(R.id.viewAllDeals);
        seeMoreStores = view.findViewById(R.id.viewAllStores);
        seeMoreDeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) getView().getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DealFragment()).addToBackStack(null).commit();

            }
        });

        seeMoreStores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) getView().getContext();
                StoreFragment storeFragment = new StoreFragment();
                Logs.info(this, "size stores : " + stores.size());
                storeFragment.setStores(stores);
                storeFragment.setDeals(deals);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, storeFragment).addToBackStack(null).commit();

            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StoreCircleFragment fragment = new StoreCircleFragment();
        fragment.setStores(stores);
        fragment.setDeals(deals);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.storesFrame, fragment).commit();

        DealHorizontalFragment fragment1 = new DealHorizontalFragment();
        fragment1.setDeals(deals);
        FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
        transaction1.replace(R.id.dealsFrame, fragment1).commit();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
}
