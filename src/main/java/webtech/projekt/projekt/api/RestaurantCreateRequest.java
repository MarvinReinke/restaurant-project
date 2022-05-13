package webtech.projekt.projekt.api;

public class RestaurantCreateRequest {
    private String name;
    private String adresse;
    private int hausnummer;

    public RestaurantCreateRequest(String name, String adresse, int hausnummer) {
        this.name = name;
        this.adresse = adresse;
        this.hausnummer = hausnummer;
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
