package webtech.projekt.projekt.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webtech.projekt.projekt.api.Restaurant;
import webtech.projekt.projekt.persistence.RestaurantEntity;
import webtech.projekt.projekt.persistence.RestaurantRepository;
import webtech.projekt.projekt.service.RestaurantService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    public RestaurantRestController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(path="/api/v1/restaurants") //Benutzen um Daten abzufragen
    public ResponseEntity<List<Restaurant>> fetchRestauraunts() { //ResponseEntity hat builderpattern integriert, was eine http Antwort erzeugt mit Status 200
        return ResponseEntity.ok(restaurantService.findAll());
    }
}
