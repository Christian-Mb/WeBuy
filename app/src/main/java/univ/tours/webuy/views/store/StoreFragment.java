package univ.tours.webuy.views.store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;

import java.util.ArrayList;

import univ.tours.webuy.core.deal.Deal;
import univ.tours.webuy.core.store.Store;

public class StoreFragment extends Fragment {

    private View v;
    private RecyclerView recyclerView;


    private ArrayList<Store> stores;
    private ArrayList<Deal> deals;

    public StoreFragment() {

    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public void setDeals(ArrayList<Deal> deals) {
        this.deals = deals;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.magazin_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.magazinRecyclerView);

        StoreAdapter storeAdapter = new StoreAdapter(getContext(), stores, deals);
        recyclerView.setAdapter(storeAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }


}
