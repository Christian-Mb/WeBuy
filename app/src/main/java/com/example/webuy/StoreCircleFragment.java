package com.example.webuy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StoreCircleFragment extends Fragment {

    private View v;

    private int[] logo = {R.drawable.logo_auchan, R.drawable.logo_leclerc, R.drawable.logo_carrefour, R.drawable.logo_u};

    public StoreCircleFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cardview_ring, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.magazinRecyclerView);

        StoreCircleAdapter storeCircleAdapter = new StoreCircleAdapter(getContext(), logo);
        recyclerView.setAdapter(storeCircleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        return view;
    }


}
