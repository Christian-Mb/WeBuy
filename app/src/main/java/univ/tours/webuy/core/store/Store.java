package univ.tours.webuy.core.store;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import univ.tours.webuy.core.storeAddress.StoreAddress;
import univ.tours.webuy.core.utils.BaseWebuy;
import univ.tours.webuy.core.utils.HttpHandler;
import univ.tours.webuy.views.store.StoreFragment;

public class Store extends BaseWebuy implements Serializable {


    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = StoreFragment.class.getSimpleName();
    private static BaseWebuy BaseWeBuy;
    private static String api_url = BaseWebuy.api_url + "/stores/AllStores";
    private String nom;
    private StoreAddress storeAddress;

    // liste des promos d'un magasin, à récupérer aussi via le service Web
    //   private ArrayList<Promotion> promotions;
    private String logo; // chaîne de caractère représente le lien  vers l'image du logo

    /**
     * renvoyer tous les magasins qui proposent des promos
     *
     * @return
     */

    public static ArrayList<Store> getAllStores() {

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

                    int id_magasin = (int) magasin_json.getLong("store_id");
                    String nom = magasin_json.getString("name");


                    JSONObject adresse = magasin_json.getJSONObject("address");
                    int address_id = (int) adresse.getLong("address_id");
                    double latitude = adresse.getDouble("latitude");
                    double longitude = adresse.getDouble("longitude");
                    String depatment = adresse.getString("department");

                    String logo = magasin_json.getString("logo");

                    // créer un objet magasin en lui rajoutant les propriétés récupérées par json
                    StoreAddress s = new StoreAddress();
                    s.setId(address_id);
                    s.setDepartment(depatment);
                    s.setLatitude(latitude);
                    s.setLongitude(longitude);

                    Store magasin = new Store();
                    magasin.setId(id_magasin);
                    magasin.setNom(nom);
                    magasin.setLogo(logo);
                    magasin.setStoreAddress(s);
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


    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public StoreAddress getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(StoreAddress storeAddress) {
        this.storeAddress = storeAddress;
    }


}
