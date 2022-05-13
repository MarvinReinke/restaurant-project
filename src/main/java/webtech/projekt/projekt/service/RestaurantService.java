package webtech.projekt.projekt.service;

import org.springframework.stereotype.Service;
import webtech.projekt.projekt.api.Restaurant;
import webtech.projekt.projekt.api.RestaurantCreateRequest;
import webtech.projekt.projekt.persistence.RestaurantEntity;
import webtech.projekt.projekt.persistence.RestaurantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAll(){
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Restaurant create(RestaurantCreateRequest request){
     var restaurantEntity = new RestaurantEntity(request.getName(), request.getAdresse(), request.getHausnummer());
     restaurantEntity = restaurantRepository.save(restaurantEntity);
     return transformEntity(restaurantEntity);
    }

    private Restaurant transformEntity(RestaurantEntity restaurantEntity){
        return new Restaurant(
                restaurantEntity.getId(),
                restaurantEntity.getName(),
                restaurantEntity.getAdresse(),
                restaurantEntity.getHausnummer()
        );
    }
}
