package onlineshop.com;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Authentication extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        tabLayout = findViewById(R.id.authenticationTab);
        viewPager = findViewById(R.id.authenticationPager);
        getSupportActionBar().setTitle("Authentication");

        AuthentiationAdapter authentiationAdapter = new AuthentiationAdapter(getSupportFragmentManager());
        authentiationAdapter.addFragment(new LoginFragment(), "Login");
        authentiationAdapter.addFragment(new RegisterFragment(), "Register");
        viewPager.setAdapter(authentiationAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
