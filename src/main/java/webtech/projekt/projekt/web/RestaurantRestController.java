package webtech.projekt.projekt.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webtech.projekt.projekt.api.Restaurant;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantRestController {

    private List<Restaurant> restaurants; //DummyListe solange noch keine Daten in Datenbank

    public RestaurantRestController(){
    restaurants = new ArrayList<>();
    restaurants.add(new Restaurant(1,"Vapiano", "Musteradresse", 90));
    restaurants.add(new Restaurant(2,"Mr.Wong", "Segelweg", 50));


    }


    @GetMapping(path="/api/v1/restaurants") //Benutzen um Daten abzufragen
    public ResponseEntity<List<Restaurant>> fetchRestauraunts() { //ResponseEntity hat builderpattern integriert, was eine http Antwort erzeugt mit Status 200
     return ResponseEntity.ok(restaurants);
    }

}
