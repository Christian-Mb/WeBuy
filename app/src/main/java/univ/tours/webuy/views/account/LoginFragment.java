package univ.tours.webuy.views.account;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.webuy.R;

import univ.tours.webuy.core.user.User;
import univ.tours.webuy.views.deal.AddDealActivity;
import univ.tours.webuy.views.onboarding.OnboardingActivity;

public class LoginFragment extends Fragment {

    private EditText email;
    private EditText password;
    private Button loginBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login, container, false);

        email = (EditText)root.findViewById(R.id.editTextEmail);
        password = (EditText)root.findViewById(R.id.editTextPassword);
        loginBtn = (Button)root.findViewById(R.id.cirLoginButton);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = User.getUserByEmail(email.getText().toString());
                System.out.println("user password : "+user.getPassword());
                System.out.println("password :"+password.getText().toString());
                if(user.getPassword().equals(password.getText().toString())) {
                    Intent intent = new Intent(getContext(), AddDealActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getContext(),"email ou mot de passe erronÃ©",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

}
