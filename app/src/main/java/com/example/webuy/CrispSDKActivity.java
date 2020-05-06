package com.example.webuy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import im.crisp.sdk.Crisp;

public class CrispSDKActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crisp_s_d_k);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Feeback");
        setSupportActionBar(toolbar);
        initCrispSDK();

    }

    public void initCrispSDK() {

        //initialize Crisp-SDK

        //if (accountManager.isUserConnected()) {

            //Crisp.User.setNickname(accountManager.getUser().username);
           // Crisp.User.setEmail(accountManager.getUser().email);
        //}

        Crisp.Session.setData("plateform", "android");
        //Crisp.Session.setData("app_version", AppUtils.getVersion(getContext()));
        //Crisp.Session.setData("device", Devices.getModel());
        Crisp.Session.setSegments("android");

    }



}
