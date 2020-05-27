package com.example.webuy.views.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.webuy.R;
import com.example.webuy.core.store.Store;
import com.example.webuy.core.utils.Toasts;
import com.example.webuy.views.account.AccountActivity;
import com.example.webuy.views.onboarding.OnboardingActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    View.OnClickListener connect = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
            startActivity(intent);
        }
    };
    private ArrayList<Store> stores;
    View.OnClickListener deal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), OnboardingActivity.class);
            intent.putExtra("store", stores);
            startActivity(intent);
        }
    };
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bnSign = findViewById(R.id.btnConnect);
        Button deals = findViewById(R.id.btnDeal);
        deals.setOnClickListener(deal);
        bnSign.setOnClickListener(connect);
        ImageView img = findViewById(R.id.imageAccueil);
        img.setImageDrawable(getDrawable(R.drawable.accueil));

    }

    @Override
    protected void onStart() {
        super.onStart();
        GetAllMagasinsTask task = new GetAllMagasinsTask(MainActivity.this);
        task.execute();
    }


    /**
     * une tâche asynchrone pour obtenir des données json par des requêtes HTTP
     */
    private class GetAllMagasinsTask extends AsyncTask<Void, Void, Void> {

        MainActivity a;

        public GetAllMagasinsTask(MainActivity a) {
            this.a = a;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Stores loading ...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {

            stores = Store.getAllMagasins();


            return null;
        }

        @Override
        protected void onProgressUpdate(Void... progress) {
            super.onProgressUpdate(progress);
            pDialog.setProgress(1);
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            Toasts.ok(getApplicationContext(), R.string.ready);


        }

    }
}
