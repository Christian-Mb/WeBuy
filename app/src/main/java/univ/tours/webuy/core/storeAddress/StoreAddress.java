package univ.tours.webuy.core.storeAddress;

import univ.tours.webuy.core.utils.BaseWebuy;

import java.io.Serializable;

public class StoreAddress extends BaseWebuy implements Serializable {

    private double Longitude, latitude;
    private String department;

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "StoreAddress{" +
                "Longitude=" + Longitude +
                ", latitude=" + latitude +
                ", department='" + department + '\'' +
                '}';
    }
}
