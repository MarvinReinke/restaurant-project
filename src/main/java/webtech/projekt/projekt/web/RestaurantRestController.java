package webtech.projekt.projekt.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webtech.projekt.projekt.api.Restaurant;
import webtech.projekt.projekt.api.RestaurantManipulationRequest;
import webtech.projekt.projekt.service.RestaurantService;

import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping(path="/api/v1/restaurants/{id}")
    public ResponseEntity<Restaurant> fetchRestaurantById(@PathVariable Long id){
        var restaurant = restaurantService.findById(id);
        return restaurant != null? ResponseEntity.ok(restaurant) : ResponseEntity.notFound().build();
    }

    @PostMapping(path="/api/v1/restaurants")
    public ResponseEntity<Void> createRestaurant(@RequestBody RestaurantManipulationRequest request) throws URISyntaxException {
        var restaurant =restaurantService.create(request);
        URI uri = new URI("/api/v1/restaurants/" + restaurant.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path= "/api/v1/restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantManipulationRequest request){
        var restaurant = restaurantService.update(id, request);
        return restaurant != null? ResponseEntity.ok(restaurant) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path= "/api/v1/restaurants/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id){
        boolean successful = restaurantService.deleteById(id);
        return successful? ResponseEntity.ok().build(): ResponseEntity.notFound().build();

    }
}
