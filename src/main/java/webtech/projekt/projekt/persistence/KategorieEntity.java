package webtech.projekt.projekt.persistence;

import webtech.projekt.projekt.api.Restaurant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name= "kategorie")
public class KategorieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kategorienName")
    private String kategorienName;

    @Column(name = "kategorienBeschreibung")
    private String kategorienBeschreibung;

    public KategorieEntity(String kategorienName, String kategorienBeschreibung){
        this.kategorienName = kategorienName;
        this.kategorienBeschreibung = kategorienBeschreibung;
    }

    protected KategorieEntity(){}

    public Long getId() {
        return id;
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
}
