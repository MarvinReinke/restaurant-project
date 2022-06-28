package webtech.projekt.projekt.api;

import java.util.List;

public class Kategorie {

    private long id;
    private String kategorienName;
    private String kategorienBeschreibung;
    private Long restaurantId;

    public Kategorie(long id, String kategorienName, String kategorienBeschreibung, Long restaurantId){
        this.id = id;
        this.kategorienName = kategorienName;
        this.kategorienBeschreibung = kategorienBeschreibung;
        this.restaurantId = restaurantId;
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

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
