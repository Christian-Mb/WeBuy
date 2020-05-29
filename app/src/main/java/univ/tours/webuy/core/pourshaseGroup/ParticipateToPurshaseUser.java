package univ.tours.webuy.core.pourshaseGroup;

import java.io.Serializable;

import univ.tours.webuy.core.user.User;
import univ.tours.webuy.core.utils.BaseWebuy;

public class ParticipateToPurshaseUser extends BaseWebuy implements Serializable {
    private User user;
    private PurshaseGroup purshaseGroup;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PurshaseGroup getPurshaseGroup() {
        return purshaseGroup;
    }

    public void setPurshaseGroup(PurshaseGroup purshaseGroup) {
        this.purshaseGroup = purshaseGroup;
    }

    @Override
    public String toString() {
        return "ParticipateToPurshaseUser{" +
                "user=" + user +
                ", purshaseGroup=" + purshaseGroup +
                '}';
    }
}
