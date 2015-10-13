package com.gobelinscrm14.noemiediaz.userappcrm14.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.gobelinscrm14.noemiediaz.userappcrm14.Authentification;
import com.gobelinscrm14.noemiediaz.userappcrm14.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //ADD TOOLBAR
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        //ADD FRAGMENT ON MAIN ACTIVITY
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContent, new UserFragment())
                .commit();

    }
}
