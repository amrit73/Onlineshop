package onlineshop.com;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {
    private EditText loginusername;
    private EditText loginpassword;
    private Button btnlogin;
    private String un, pw;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginusername = view.findViewById(R.id.loginusername);
        loginpassword = view.findViewById(R.id.loginpassword);
        btnlogin = view.findViewById(R.id.btnlogin);
        preferences = getContext().getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
        editor = preferences.edit();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                un = preferences.getString("USERNAME", "");
                pw = preferences.getString("PASSWORD", "");


                if (TextUtils.isEmpty(loginusername.getText().toString())) {
                    Toast.makeText(getActivity(), "USERNAME cannot be empty", Toast.LENGTH_SHORT).show();
                    loginusername.setText("");
                    loginpassword.setText("");
                } else if (TextUtils.isEmpty(loginpassword.getText().toString())) {
                    Toast.makeText(getActivity(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
                    loginpassword.setText("");
                } else {

                    if (un.equals(loginusername.getText().toString())
                            && pw.equals(loginpassword.getText().toString())) {
                        Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Items.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), "Authentication Error", Toast.LENGTH_SHORT).show();
                        loginusername.setText("");
                        loginpassword.setText("");
                    }


                }

            }
        });


        return view;
    }
}
