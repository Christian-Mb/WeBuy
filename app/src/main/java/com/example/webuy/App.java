package com.example.webuy;

import android.app.Application;

import im.crisp.sdk.Crisp;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Crisp.initialize(this);
        Crisp.getInstance().setWebsiteId("7598bf86-9ebb-46bc-8c61-be8929bbf93d");
    }

}
