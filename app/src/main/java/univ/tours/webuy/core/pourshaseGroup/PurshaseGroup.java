package univ.tours.webuy.core.pourshaseGroup;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import univ.tours.webuy.core.comment.Comment;
import univ.tours.webuy.core.deal.Deal;
import univ.tours.webuy.core.user.User;
import univ.tours.webuy.core.utils.BaseWebuy;

public class PurshaseGroup extends BaseWebuy implements Serializable {
    private Deal deal;
    private User user;
    private int duration, article_quantity;
    private int nbrs_users_wanted;
    private Timestamp createdAt;
    private String invitationCode;
    private ArrayList<Comment> comments;
    private ArrayList<ParticipateToPurshaseUser> participateToPurshaseUsers;

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getArticle_quantity() {
        return article_quantity;
    }

    public void setArticle_quantity(int article_quantity) {
        this.article_quantity = article_quantity;
    }

    public int getNbrs_users_wanted() {
        return nbrs_users_wanted;
    }

    public void setNbrs_users_wanted(int nbrs_users_wanted) {
        this.nbrs_users_wanted = nbrs_users_wanted;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<ParticipateToPurshaseUser> getParticipateToPurshaseUsers() {
        return participateToPurshaseUsers;
    }

    public void setParticipateToPurshaseUsers(ArrayList<ParticipateToPurshaseUser> participateToPurshaseUsers) {
        this.participateToPurshaseUsers = participateToPurshaseUsers;
    }

    @Override
    public String toString() {
        return "PurshaseGroup{" +
                "deal=" + deal +
                ", user=" + user +
                ", duration=" + duration +
                ", article_quantity=" + article_quantity +
                ", nbrs_users_wanted=" + nbrs_users_wanted +
                ", createdAt=" + createdAt +
                ", invitationCode='" + invitationCode + '\'' +
                ", comments=" + comments +
                ", participateToPurshaseUsers=" + participateToPurshaseUsers +
                '}';
    }
}
