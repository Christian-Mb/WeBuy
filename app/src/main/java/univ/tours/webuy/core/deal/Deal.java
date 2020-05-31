package univ.tours.webuy.core.deal;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import univ.tours.webuy.core.comment.Comment;
import univ.tours.webuy.core.pourshaseGroup.PurshaseGroup;
import univ.tours.webuy.core.product.Product;
import univ.tours.webuy.core.store.Store;
import univ.tours.webuy.core.storeAddress.StoreAddress;
import univ.tours.webuy.core.user.User;
import univ.tours.webuy.core.utils.BaseWebuy;
import univ.tours.webuy.core.utils.HttpHandler;
import univ.tours.webuy.views.deal.DealFragment;


public class Deal extends BaseWebuy implements Serializable {

    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = DealFragment.class.getSimpleName();
    private static BaseWebuy BaseWeBuy;
    private static String api_url = BaseWebuy.api_url + "/deals/AllDeals";
    private double price_before_promo;
    private double price_promo;
    private int quantity_min_to_Buy, quantity_available;
    private Store stores;
    private Product product;
    private static ArrayList<PurshaseGroup> purshaseGroup = new ArrayList<>();
    private long userLike, userDislike;
    private Timestamp createdAt, startedAt, endedAt;
    private User user;
    private ArrayList<Comment> comments;


    public double getPrice_before_promo() {
        return price_before_promo;
    }

    public void setPrice_before_promo(double price_before_promo) {
        this.price_before_promo = price_before_promo;
    }

    public double getPrice_promo() {
        return price_promo;
    }

    public void setPrice_promo(double price_promo) {
        this.price_promo = price_promo;
    }

    public int getQuantity_min_to_Buy() {
        return quantity_min_to_Buy;
    }

    public void setQuantity_min_to_Buy(int quantity_min_to_Buy) {
        this.quantity_min_to_Buy = quantity_min_to_Buy;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    public Store getStores() {
        return stores;
    }

    public void setStores(Store stores) {
        this.stores = stores;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<PurshaseGroup> getPurshaseGroup() {
        return purshaseGroup;
    }

    public static ArrayList<Deal> getAllDeals() {

        // bloquer la requête pendant 2 seconds: juste pour illustrer l'effet des requêtes lourdes
        // sur l'interface graphique si on n'utilise pas les Threads ou AsyncTask
        // cette partie à supprimer dans votre application
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Deal> deals = new ArrayList<>();

        HttpHandler serviceWebHandler = new HttpHandler();

        // Effectuer la requete on utilisant l'url , la réponse est une chaîne JSON

        String jsonStr = serviceWebHandler.makeServiceCall(api_url);

        Log.e(TAG, "Réponse Serveur: " + jsonStr);

        if (jsonStr != null) {
            try {
                new JSONArray(jsonStr);

                // Récuperer le tableau des magasins
                JSONArray jsonArray = new JSONArray(jsonStr);

                // Pour tous les magasins

                for (int i = 0; i < jsonArray.length(); i++) {

                    // récupérer les valeurs de chaque propriété
                    JSONObject deal_json = jsonArray.getJSONObject(i);

                    Deal d = new Deal();
                    int deal_id = (int) deal_json.getLong("deal_id");
                    double price = deal_json.getDouble("price");
                    double price_promo = deal_json.getDouble("price_pomo");
                    int quantity_availble = deal_json.getInt("quantity_available");
                    int quantity_to_buy = deal_json.getInt("quantity_to_buy");
                    int userLike = deal_json.getInt("userLike");
                    int userDislike = deal_json.getInt("userDislike");
                    String createdAt = deal_json.getString("createdAt");
                    String endedAt = deal_json.getString("endedAt");
                    String startedAt = deal_json.getString("startedAt");

                    d.setPrice_before_promo(price);
                    d.setPrice_promo(price_promo);
                    d.setQuantity_available(quantity_availble);
                    d.setQuantity_min_to_Buy(quantity_to_buy);
                    d.setUserDislike(userDislike);
                    d.setUserLike(userLike);
                    // d.setCreatedAt(Timestamp.valueOf(createdAt));
                    //d.setStartedAt(Timestamp.valueOf(startedAt));
                    //d.setEndedAt(Timestamp.valueOf(endedAt));
                    d.setId(deal_id);

                    //SAve product
                    JSONObject product = deal_json.getJSONObject("product");

                    String label = product.getString("label");
                    String content = product.getString("content");
                    String image = product.getString("image");

                    Product p = new Product();

                    p.setLabel(label);
                    p.setContent(content);
                    p.setImage(image);
                    d.setProduct(p);

                    JSONObject store = deal_json.getJSONObject("store");

                    int id_magasin = (int) store.getLong("store_id");
                    String nom = store.getString("name");
                    String logo = store.getString("logo");


                    Store magasin = new Store();
                    magasin.setId(id_magasin);
                    magasin.setNom(nom);
                    magasin.setLogo(logo);


                    JSONObject address = store.getJSONObject("address");
                    int address_id = (int) address.getLong("address_id");
                    double latitude = address.getDouble("latitude");
                    double longitude = address.getDouble("longitude");
                    String depatment = address.getString("department");


                    StoreAddress s = new StoreAddress();
                    s.setId(address_id);
                    s.setDepartment(depatment);
                    s.setLatitude(latitude);
                    s.setLongitude(longitude);
                    magasin.setStoreAddress(s);

                    d.setStores(magasin);


                    //save user
                    JSONObject user = deal_json.getJSONObject("user");
                    String username = user.getString("username");
                    User u = new User();
                    u.setUsername(username);
                    d.setUser(u);


                    // réjouter le magasin à la liste des magasins
                    deals.add(d);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON : " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return deals;

    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public long getUserLike() {
        return userLike;
    }

    public void setUserLike(long userLike) {
        this.userLike = userLike;
    }

    public long getUserDislike() {
        return userDislike;
    }

    public void setUserDislike(long userDislike) {
        this.userDislike = userDislike;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Timestamp startedAt) {
        this.startedAt = startedAt;
    }

    public Timestamp getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Timestamp endedAt) {
        this.endedAt = endedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPurshaseGroup(ArrayList<PurshaseGroup> purshaseGroup) {
        Deal.purshaseGroup = purshaseGroup;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "price_before_promo=" + price_before_promo +
                ", price_promo=" + price_promo +
                ", quantity_min_to_Buy=" + quantity_min_to_Buy +
                ", quantity_available=" + quantity_available +
                ", stores=" + stores +
                ", product=" + product +
                ", purshaseGroup=" + purshaseGroup +
                ", userLike=" + userLike +
                ", userDislike=" + userDislike +
                ", createdAt=" + createdAt +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
