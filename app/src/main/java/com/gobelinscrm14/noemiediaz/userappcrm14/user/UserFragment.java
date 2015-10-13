package com.gobelinscrm14.noemiediaz.userappcrm14.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gobelinscrm14.noemiediaz.userappcrm14.Authentification;
import com.gobelinscrm14.noemiediaz.userappcrm14.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    //private LoginListener mListener;
    @Bind(R.id.userName) TextView mUserName;
    @Bind(R.id.userPassword) TextView mUserPassword;
    @Bind(R.id.userEmail) TextView mUserMail;


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);

        TextView loginDisplay = (TextView) view.findViewById(R.id.userName);
        TextView emailDisplay = (TextView) view.findViewById(R.id.userEmail);

        User user = Authentification.getInstance().getLogUser();

        loginDisplay.setText(user.getName());
        emailDisplay.setText(user.getEmail());

        return view;
    }


}
