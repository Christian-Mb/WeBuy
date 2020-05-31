package univ.tours.webuy.views.deal;

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

public class DealFragment extends Fragment {

    private ArrayList<Deal> deals;

    public DealFragment() {

    }

    public void setDeals(ArrayList<Deal> deals) {
        this.deals = deals;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.magazin_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.magazinRecyclerView);

        DealListAdapter dealAdapter = new DealListAdapter(getContext(), deals);
        recyclerView.setAdapter(dealAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
