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

public class DealHorizontalFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    String[] dTitle = {"Lait ", "Cristalline", "PS4", "M&M'S", "Machin", "Et", "Bidule"};
    String[] dDescription = {"Une description", "Une description", "Une description", "Une description", "Une description", "Une description", "Une description"};
    int[] dCodePostal = {37, 95, 44, 45, 12, 78, 14};


    public DealHorizontalFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cardview_ring, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.magazinRecyclerView);

        DealListAdapter dealAdapter = new DealListAdapter(getContext(), dTitle, dDescription, dCodePostal);
        recyclerView.setAdapter(dealAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        return view;
    }
}
