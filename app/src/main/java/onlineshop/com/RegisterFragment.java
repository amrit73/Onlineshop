package onlineshop.com;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterFragment extends Fragment {

    private EditText firstname, lastname, email, password;
    private Button btnregister;
    private String fn, ln, un, pwd;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        firstname = view.findViewById(R.id.fname);
        lastname = view.findViewById(R.id.lname);
        email = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        btnregister = view.findViewById(R.id.btnregister);

        preferences = getContext().getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
        editor = preferences.edit();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn = firstname.getText().toString();
                ln = lastname.getText().toString();
                un = email.getText().toString();
                pwd = password.getText().toString();

                if (fn.isEmpty()) {
                    Toast.makeText(getActivity(), "First Name cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (ln.isEmpty()) {
                    Toast.makeText(getActivity(), "Last Name cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (un.isEmpty()) {
                    Toast.makeText(getActivity(), "Username cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (pwd.isEmpty()) {
                    Toast.makeText(getActivity(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("FIRSTNAME", fn);
                    editor.putString("LASTNAME", ln);
                    editor.putString("USERNAME", un);
                    editor.putString("PASSWORD", pwd);
                    editor.commit();

                    Toast.makeText(getActivity(), "Successfully registered.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
