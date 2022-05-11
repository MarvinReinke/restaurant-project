package webtech.projekt.projekt.api;

import java.util.List;

public class Kategorie {

    private long id;
    private String kategorienName;
    private String kategorienBeschreibung;
    private List<Long> restaurantIds;

    public Kategorie(long id, String kategorienName, String kategorienBeschreibung, List<Long> restaurantIds){
        this.id = id;
        this.kategorienName = kategorienName;
        this.kategorienBeschreibung = kategorienBeschreibung;
        this.restaurantIds = restaurantIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKategorienName() {
        return kategorienName;
    }

    public void setKategorienName(String kategorienName) {
        this.kategorienName = kategorienName;
    }

    public String getKategorienBeschreibung() {
        return kategorienBeschreibung;
    }

    public void setKategorienBeschreibung(String kategorienBeschreibung) {
        this.kategorienBeschreibung = kategorienBeschreibung;
    }

    public List<Long> getRestaurantIds() {
        return restaurantIds;
    }

    public void setRestaurantIds(List<Long> restaurantIds) {
        this.restaurantIds = restaurantIds;
    }
}
