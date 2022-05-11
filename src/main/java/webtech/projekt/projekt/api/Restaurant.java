package webtech.projekt.projekt.api;

public class Restaurant {

    public long id;
    public String name;
    public String adresse;
    public int hausnummer;

    public Restaurant(long id, String name, String adresse, int hausnummer) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.hausnummer = hausnummer;
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

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }
}
