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

public class MagazinFragment extends Fragment {

   private View v;
   private RecyclerView recyclerView;
   private String[] mTitle = {"Auchan", "Leclerc", "Carrefour", "Super U"};
   private String[] mQuantiteDeals = {"12", "50", "25", "34"};
   private String[] mQuantiteStores = {"34", "12", "45", "21"};

   private int[] logo = {R.drawable.logo_auchan, R.drawable.logo_leclerc, R.drawable.logo_carrefour, R.drawable.logo_u};

    public MagazinFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.magazin_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.magazinRecyclerView);

        MagazinAdapter magazinAdapter = new MagazinAdapter(getContext(), mTitle, mQuantiteDeals,mQuantiteStores, logo);
        recyclerView.setAdapter(magazinAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }


}
