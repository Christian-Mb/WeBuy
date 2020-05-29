package univ.tours.webuy.views.purshaseGroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.webuy.R;

import java.util.ArrayList;

import univ.tours.webuy.core.pourshaseGroup.PurshaseGroup;
import univ.tours.webuy.core.user.User;
import univ.tours.webuy.views.user.UserHorizontalCircleFragment;

public class DetailsGroupFragment extends Fragment {
    ArrayList<User> users;
    PurshaseGroup purshaseGroup;

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setPurshaseGroup(PurshaseGroup purshaseGroup) {
        this.purshaseGroup = purshaseGroup;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        Button btn = view.findViewById(R.id.BtnParticipate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add user to Group Todo
            }
        });


        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UserHorizontalCircleFragment fragment = new UserHorizontalCircleFragment();
        fragment.setUser(users);

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment).commit();

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DetailsGroupFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}
