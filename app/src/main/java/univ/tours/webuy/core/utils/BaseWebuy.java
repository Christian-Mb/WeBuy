package univ.tours.webuy.core.utils;

public class BaseWebuy {

    public static String api_url = "http://192.168.56.1:8080";
    public static String api_urlZ = "https://webuy.sciences.univ-tours.fr/api/v1";

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
