package com.example.webuy.views.store;

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
import com.example.webuy.core.store.Store;

import java.util.ArrayList;

public class StoreFragment extends Fragment {

    private View v;
    private RecyclerView recyclerView;


    private ArrayList<Store> stores;

    public StoreFragment() {

    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.magazin_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.magazinRecyclerView);

        StoreAdapter storeAdapter = new StoreAdapter(getContext(), stores);
        recyclerView.setAdapter(storeAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }


}
