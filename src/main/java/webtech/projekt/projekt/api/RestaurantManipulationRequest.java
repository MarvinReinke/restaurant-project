package webtech.projekt.projekt.api;

public class RestaurantManipulationRequest {
    private String name;
    private String adresse;
    private String hausnummer;
    private Long kategorieId;


    public RestaurantManipulationRequest(String name, String adresse, String hausnummer, Long kategorieId) {
        this.name = name;
        this.adresse = adresse;
        this.hausnummer = hausnummer;
        this.kategorieId = kategorieId;
    }

    public RestaurantManipulationRequest() {}

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

    public Long getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(Long kategorieId) {
        this.kategorieId = kategorieId;
    }
}
