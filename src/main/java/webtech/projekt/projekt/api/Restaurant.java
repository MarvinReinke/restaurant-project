package webtech.projekt.projekt.api;

public class Restaurant {

    private long id;
    private String name;
    private String adresse;
    private String hausnummer;
    private Kategorie kategorie;

    public Restaurant(long id, String name, String adresse, String hausnummer, Kategorie kategorie) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.hausnummer = hausnummer;
        this.kategorie = kategorie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }
}
