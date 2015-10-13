package com.gobelinscrm14.noemiediaz.userappcrm14;

import com.firebase.client.Firebase;

/**
 * Created by noemiediaz on 13/10/15.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
