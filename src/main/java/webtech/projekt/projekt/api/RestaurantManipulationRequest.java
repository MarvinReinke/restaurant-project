package webtech.projekt.projekt.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class RestaurantManipulationRequest {

    @Size(min = 2, message ="Bitte gebe ein Restaurant mit mindestens 2 Buchstaben ein")
    private String name;

    @NotBlank(message="Bitte gebe die Adresse des Restaurants an")
    private String adresse;

    @NotBlank(message="Bitte gebe noch die Hausnummer des Restaurants mit an")
    private String hausnummer;

    @Positive(message="Bitte gebe die ID der Kategorie an, zu der das Restaurant gehört")
    private Long kategorieId;


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
