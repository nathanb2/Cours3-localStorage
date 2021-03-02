package com.example.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        mNameEt = findViewById(R.id.AM_name_et);
    }

    private void initListener() {
        findViewById(R.id.AM_open_display_activity_btn).setOnClickListener(view -> {
            User user = new User(mNameEt.getText().toString(), 25);
            ArrayList<User> users = new ArrayList<>();
            users.add(user);
            users.add(user);
            SharedPref.getInstance(this).setUsers(users);
//            SharedPref.getInstance(this).setName(mNameEt.getText().toString());
            startActivity(new Intent(MainActivity.this, DisplayFromPreferencesActivity.class));
        });
    }

}