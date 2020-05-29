package univ.tours.webuy.core.user;

import univ.tours.webuy.core.comment.Comment;
import univ.tours.webuy.core.pourshaseGroup.PurshaseGroup;
import univ.tours.webuy.core.utils.BaseWebuy;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class User extends BaseWebuy implements Serializable {

    private String username, mobileNumber, email, password, token;
    private Timestamp createdAt;
    private ArrayList<Comment> comments;
    private ArrayList<PurshaseGroup> purshaseGroups;

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
}
