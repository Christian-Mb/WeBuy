package univ.tours.webuy.core.user;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import univ.tours.webuy.core.comment.Comment;
import univ.tours.webuy.core.pourshaseGroup.PurshaseGroup;
import univ.tours.webuy.core.utils.BaseWebuy;
import univ.tours.webuy.core.utils.HttpHandler;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class User extends BaseWebuy implements Serializable {

    private static BaseWebuy BaseWeBuy;
    private static String api_url = BaseWebuy.api_url + "/users";
    private String username, mobileNumber, email, password, avatar, token;
    private Timestamp createdAt;
    private ArrayList<Comment> comments;
    private ArrayList<PurshaseGroup> purshaseGroups;

    public static User getUserByEmail(String email) {
        final String em = email;
        final User user = new User();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpHandler serviceWebHandler = new HttpHandler();

                String jsonStr = serviceWebHandler.makeServiceCall(api_url + "/get/" + em);
                Log.e(TAG, "Réponse Serveur: " + jsonStr);
                if (jsonStr != null) {
                    try {
                        new JSONObject(jsonStr);
                        JSONObject user_json = new JSONObject(jsonStr);
                        user.setId(user_json.getInt("user_id"));
                        user.setUsername(user_json.getString("username"));
                        user.setEmail(user_json.getString("email"));
                        user.setPassword(user_json.getString("password"));
                        user.setMobileNumber(user_json.getString("mobileNumber"));
                    } catch (final JSONException e) {
                        Log.e(TAG, "Erreur de parsing JSON : " + e.getMessage());

                    }
                } else {
                    Log.e(TAG, "Réponse vide !, pas de JSON");
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return user;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<PurshaseGroup> getPurshaseGroups() {
        return purshaseGroups;
    }

    public void setPurshaseGroups(ArrayList<PurshaseGroup> purshaseGroups) {
        this.purshaseGroups = purshaseGroups;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
