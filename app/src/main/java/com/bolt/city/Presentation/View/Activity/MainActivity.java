package com.bolt.city.Presentation.View.Activity;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bolt.city.Presentation.View.Fragment.KeyFragment;
import com.bolt.city.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences preferences = getSharedPreferences("CityData", MODE_PRIVATE);
        String key = preferences.getString("ApiKey", "n/a");

        if (Objects.equals(key, "n/a")) {
            // TODO: Get Key from the user
            inItFragment(KeyFragment.createInstance());

        } else {
            // TODO: Start application
        }
    }

    private void inItFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment).commit();
    }
}
