package webtech.projekt.projekt.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class KategorieManipulationRequest {
    @Size(min = 2, message = "Die Kategorie muss mehr als 2 Zeichen lang sein")
    private String kategorienName;

    @NotBlank(message = "Die Kategorie muss eine Beschreibung haben")
    private String kategorienBeschreibung;

    public KategorieManipulationRequest(){}

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
