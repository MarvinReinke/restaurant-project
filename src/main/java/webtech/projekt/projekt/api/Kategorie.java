package webtech.projekt.projekt.api;

import java.util.List;

public class Kategorie {

    private long id;
    private String kategorienName;
    private String kategorienBeschreibung;
    private List<Long> restaurants;

    public Kategorie(long id, String kategorienName, String kategorienBeschreibung, List<Long> restaurants){
        this.id = id;
        this.kategorienName = kategorienName;
        this.kategorienBeschreibung = kategorienBeschreibung;
        this.restaurants = restaurants;
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

    public List<Long> getRestaurants() {
        return restaurants;
    }

    public void setRestaurantIds(List<Long> restaurants) {
        this.restaurants = restaurants;
    }
}
