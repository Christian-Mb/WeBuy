package univ.tours.webuy.views.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.webuy.R;

public class RegisterFragment extends Fragment {

    private EditText registerName;
    private EditText registerEmail;
    private EditText registerNumber;
    private EditText registerPassword;
    private String api_url = "http://192.168.0.29:8080/users/add";
    private View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.register, container, false);
        v = root;
        Button registerBtn = root.findViewById(R.id.cirRegisterButton);
        registerName = root.findViewById(R.id.RegisterName);
        registerEmail = root.findViewById(R.id.RegisterMail);
        registerNumber = root.findViewById(R.id.RegisterNumber);
        registerPassword = root.findViewById(R.id.RegisterPassword);

        return root;
    }

    /**
     private void InsertSV(){
     // this.api_url = api_url + this.registerEmail.getText().toString();
     StringRequest stringRequest = new StringRequest(Request.Method.POST, api_url, new Response.Listener<String>() {
    @Override public void onResponse(String response) {

    }
    }, new Response.ErrorListener() {
    @Override public void onErrorResponse(VolleyError error) {

    }
    }
     ){
    @Override protected Map<String, String> getParams() throws AuthFailureError {
    Map<String, String> params = new HashMap<String,String>();
    params.put("email",registerEmail.getText().toString());
    params.put("password",registerPassword.getText().toString());
    params.put("username",registerName.getText().toString());
    params.put("mobile_number", registerNumber.getText().toString());
    return params;
    }

    @Override public Map<String, String> getHeaders() throws AuthFailureError {
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("Content-Type", "application/json; charset=utf-8");
    return headers;
    }
    }
     ;
     RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
     requestQueue.add(stringRequest);
     }
     **/
}
