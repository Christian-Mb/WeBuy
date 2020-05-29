package univ.tours.webuy.views.purshaseGroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;

import java.util.ArrayList;

import univ.tours.webuy.core.pourshaseGroup.PurshaseGroup;

public class DetailsGroupFragment extends Fragment {

    private ArrayList<PurshaseGroup> purshaseGroups;

    public void setPurshaseGroups(ArrayList<PurshaseGroup> purshaseGroups) {
        this.purshaseGroups = purshaseGroups;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View view = inflater.inflate(R.layout.magazin_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.magazinRecyclerView);
        ListGroupAdapter listGroupAdapter = new ListGroupAdapter(getContext(), purshaseGroups);
        recyclerView.setAdapter(listGroupAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.join_us).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DetailsGroupFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

    }


}
