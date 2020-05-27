package com.example.webuy.core.store;

import android.util.Log;

import com.example.webuy.core.utils.BaseWebuy;
import com.example.webuy.core.utils.HttpHandler;
import com.example.webuy.views.store.StoreFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Store extends BaseWebuy {


    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = StoreFragment.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "/magasins";
    private String nom;
    private String adresse;
    private double latitude;
    private double longitude;

    // liste des promos d'un magasin, à récupérer aussi via le service Web
    //   private ArrayList<Promotion> promotions;
    private String logo; // chaîne de caractère représente le lien  vers l'image du logo

    /**
     * renvoyer tous les magasins qui proposent des promos
     *
     * @return
     */

    public static ArrayList<Store> getAllMagasins() {

        // bloquer la requête pendant 2 seconds: juste pour illustrer l'effet des requêtes lourdes
        // sur l'interface graphique si on n'utilise pas les Threads ou AsyncTask
        // cette partie à supprimer dans votre application
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Store> magasins = new ArrayList<>();

        HttpHandler serviceWebHandler = new HttpHandler();

        // Effectuer la requete on utilisant l'url , la réponse est une chaîne JSON

        String jsonStr = serviceWebHandler.makeServiceCall(api_url);

        Log.e(TAG, "Réponse Serveur: " + jsonStr);

        if (jsonStr != null) {
            try {
                new JSONArray(jsonStr);

                // Récuperer le tableau des magasins
                JSONArray magasins_json = new JSONArray(jsonStr);

                // Pour tous les magasins

                for (int i = 0; i < magasins_json.length(); i++) {

                    // récupérer les valeurs de chaque propriété
                    JSONObject magasin_json = magasins_json.getJSONObject(i);

                    int id_magasin = magasin_json.getInt("id_magasin");
                    String nom = magasin_json.getString("nom");
                    String adresse = magasin_json.getString("adresse");

                    double latitude = magasin_json.getDouble("latitude");
                    double longitude = magasin_json.getDouble("longitude");

                    String logo = magasin_json.getString("logo");

                    // créer un objet magasin en lui rajoutant les propriétés récupérées par json

                    Store magasin = new Store();
                    magasin.setId(id_magasin);
                    magasin.setNom(nom);
                    magasin.setLongitude(latitude);
                    magasin.setLatitude(longitude);
                    magasin.setAdresse(adresse);
                    magasin.setLogo(logo);
                    // réjouter le magasin à la liste des magasins
                    magasins.add(magasin);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON : " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return magasins;

    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


}