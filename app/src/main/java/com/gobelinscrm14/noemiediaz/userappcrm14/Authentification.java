package com.gobelinscrm14.noemiediaz.userappcrm14;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.gobelinscrm14.noemiediaz.userappcrm14.user.User;

/**
 * Created by noemiediaz on 13/10/15.
 */
public class Authentification {

    User logUser;

    private static Authentification ourInstance = new Authentification();

    private Firebase myFirebaseRef;

    public static Authentification getInstance() {
        return ourInstance;
    }

    private Authentification() {
        myFirebaseRef = new Firebase("https://crm14firebase.firebaseio.com/");
    }

    public User getLogUser() {
        return logUser;
    }

    public void setLogUser(User logUser) {
        this.logUser = logUser;
    }

    public void authenticate(String email, String password, final FirebaseListener listener){

        myFirebaseRef.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {

                /*User user = new User();
                user.setName(name);
                user.setEmail(email);
                setLogUser(user);*/

                listener.onSucessAuth(authData);
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                listener.onErrorAuth(firebaseError);
            }
        });
    }

    public interface FirebaseListener {
        void onSucessAuth(AuthData authData);
        void onErrorAuth(FirebaseError firebaseError);
    }



}
