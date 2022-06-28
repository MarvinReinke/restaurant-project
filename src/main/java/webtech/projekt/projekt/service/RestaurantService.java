package webtech.projekt.projekt.service;

import org.springframework.stereotype.Service;
import webtech.projekt.projekt.api.Restaurant;
import webtech.projekt.projekt.api.RestaurantManipulationRequest;
import webtech.projekt.projekt.persistence.KategorieRepository;
import webtech.projekt.projekt.persistence.RestaurantEntity;
import webtech.projekt.projekt.persistence.RestaurantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final KategorieRepository kategorieRepository;
    private final KategorieTransformer kategorieTransformer;

    public RestaurantService(RestaurantRepository restaurantRepository, KategorieRepository kategorieRepository,  KategorieTransformer kategorieTransformer){
        this.restaurantRepository = restaurantRepository;
        this.kategorieRepository = kategorieRepository;
        this.kategorieTransformer = kategorieTransformer;
    }

    public List<Restaurant> findAll(){
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Restaurant findById(Long id){
        var restaurantEntity = restaurantRepository.findById(id);
        return restaurantEntity.map(this::transformEntity).orElse(null);
    }


    public Restaurant create(RestaurantManipulationRequest request){
     var kategorie = kategorieRepository.findById(request.getKategorieId()).orElseThrow();
     var restaurantEntity = new RestaurantEntity(request.getName(), request.getAdresse(), request.getHausnummer(),kategorie);
     restaurantEntity = restaurantRepository.save(restaurantEntity);
     return transformEntity(restaurantEntity);
    }

    public Restaurant update(Long id, RestaurantManipulationRequest request){
        var restaurantEntitiyOptional = restaurantRepository.findById(id);
        if(restaurantEntitiyOptional.isEmpty()) {
            return null;
        }

        var restaurantEntity = restaurantEntitiyOptional.get();
        restaurantEntity.setName(request.getName());
        restaurantEntity.setAdresse(request.getAdresse());
        restaurantEntity.setHausnummer(request.getHausnummer());
        restaurantEntity = restaurantRepository.save(restaurantEntity);

        return transformEntity(restaurantEntity);
    }

    public boolean deleteById(Long id){
        if(!restaurantRepository.existsById(id)){
            return false;
        }

        restaurantRepository.deleteById(id);
        return true;
    }

    private Restaurant transformEntity(RestaurantEntity restaurantEntity){
        return new Restaurant(
                restaurantEntity.getId(),
                restaurantEntity.getName(),
                restaurantEntity.getAdresse(),
                restaurantEntity.getHausnummer(),
                kategorieTransformer.transformEntity(restaurantEntity.getKategorie())
        );
    }
}
