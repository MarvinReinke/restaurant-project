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
    public String hausnummer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "kategorie_id", referencedColumnName = "id")
    private KategorieEntity kategorie;

    public RestaurantEntity(String name, String adresse, String hausnummer, KategorieEntity kategorie) {
        this.name = name;
        this.adresse = adresse;
        this.hausnummer = hausnummer;
        this.kategorie = kategorie;
    }

    public RestaurantEntity(){}

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

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public KategorieEntity getKategorie() {
        return kategorie;
    }

    public void setKategorie(KategorieEntity kategorie) {
        this.kategorie = kategorie;
    }
}
