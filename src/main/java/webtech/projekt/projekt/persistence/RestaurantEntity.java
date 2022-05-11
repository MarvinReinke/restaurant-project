package webtech.projekt.projekt.persistence;


import webtech.projekt.projekt.api.Restaurant;

import javax.persistence.*;

@Entity(name= "restaurants")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "adresse", nullable = false)
    public String adresse;

    @Column(name = "hausnummer", nullable = false)
    public int hausnummer;

    public RestaurantEntity(long id, String name, String adresse, int hausnummer) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.hausnummer = hausnummer;
    }

    protected RestaurantEntity(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }
}
