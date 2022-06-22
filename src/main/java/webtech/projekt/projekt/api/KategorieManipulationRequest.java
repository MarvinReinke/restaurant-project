package webtech.projekt.projekt.api;

public class KategorieManipulationRequest {
    private String kategorienName;
    private String kategorienBeschreibung;

    public KategorieManipulationRequest(String kategorienName, String kategorienBeschreibung){
        this.kategorienName = kategorienName;
        this.kategorienBeschreibung = kategorienBeschreibung;
    }

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
