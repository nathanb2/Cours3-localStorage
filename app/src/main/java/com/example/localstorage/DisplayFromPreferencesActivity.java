package com.example.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class DisplayFromPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_from_preferences);

        initView();
    }

    private void initView() {
        ArrayList<User> users = SharedPref.getInstance(this).getUsers();
        ((TextView)findViewById(R.id.ADFP_tv)).setText(String.format(Locale.getDefault(), "%s age de %d", users.get(0).getName(), users.get(0).getAge()));
    }
}