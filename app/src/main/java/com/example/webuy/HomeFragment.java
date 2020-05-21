package com.example.webuy;

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


public class HomeFragment extends Fragment {
    private TextView seeMoreStores, seeMoreDeals;

    public HomeFragment() {
        // Required empty public constructor
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
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StoreFragment()).addToBackStack(null).commit();

            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Fragment fragment = new StoreCircleFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.storesFrame, fragment).commit();

        Fragment fragment1 = new DealHorizontalFragment();
        FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
        transaction1.replace(R.id.dealsFrame, fragment1).commit();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
}
