package com.gobelinscrm14.noemiediaz.userappcrm14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.AuthData;
import com.firebase.client.FirebaseError;
import com.gobelinscrm14.noemiediaz.userappcrm14.user.LoginFragment;
import com.gobelinscrm14.noemiediaz.userappcrm14.user.RegisterFragment;
import com.gobelinscrm14.noemiediaz.userappcrm14.user.UserActivity;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginListener, Authentification.FirebaseListener, RegisterFragment.RegisterListener {


    private static final String TAG = "mainActivity";
    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ADD TOOLBAR
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        //ADD FRAGMENT ON MAIN ACTIVITY
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContent, new LoginFragment())
                .commit();
    }


    //CREATE MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //OPTION MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuMainRegisterItem) {
            //Register Clicked
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainContent, new RegisterFragment())
                    .commit();

            return true;
        } else if (item.getItemId() == R.id.menuMainLoginItem) {
            // Login Clicked
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainContent, new LoginFragment())
                    .commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLoginClicked(CharSequence loginEmail, CharSequence passwordName) {
        Log.d(TAG, loginEmail.toString() + passwordName.toString());
        Authentification.getInstance().authenticate(loginEmail.toString(),passwordName.toString(),this);
    }

    @Override
    public void onRegisterClicked(CharSequence loginEmail, CharSequence passwordName) {
        Log.d(TAG, loginEmail.toString() + passwordName.toString());
        Authentification.getInstance().createUser(loginEmail.toString(),passwordName.toString(), this);
    }

    @Override
    public void onSucessAuth(AuthData authData) {
        Intent intent = new Intent(MainActivity.this, UserActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSucessRegister(Map<String, Object>  stringObjectMap) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContent, new LoginFragment())
                .commit();
    }

    @Override
    public void onErrorAuth(FirebaseError firebaseError) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContent, new RegisterFragment())
                .commit();
    }

}
