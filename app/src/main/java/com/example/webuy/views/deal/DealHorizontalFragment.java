package com.example.webuy.views.deal;

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
import com.example.webuy.core.deal.Deal;

import java.util.ArrayList;

public class DealHorizontalFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    ArrayList<Deal> deals;

    public void setDeals(ArrayList<Deal> deals) {
        this.deals = deals;
    }

    public DealHorizontalFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cardview_ring, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.magazinRecyclerView);

        DealListAdapter dealAdapter = new DealListAdapter(getContext(), deals);
        recyclerView.setAdapter(dealAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        return view;
    }
}
