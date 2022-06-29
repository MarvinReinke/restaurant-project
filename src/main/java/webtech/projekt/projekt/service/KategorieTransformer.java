package webtech.projekt.projekt.service;

import org.springframework.stereotype.Service;
import webtech.projekt.projekt.api.Kategorie;
import webtech.projekt.projekt.persistence.KategorieEntity;
import webtech.projekt.projekt.persistence.RestaurantEntity;

import java.util.stream.Collectors;

@Service
public class KategorieTransformer {
    public Kategorie transformEntity(KategorieEntity kategorieEntity){
        var restaurantIds = kategorieEntity.getRestaurants().stream().map(RestaurantEntity::getId).collect(Collectors.toList());
        return new Kategorie(
                kategorieEntity.getId(),
                kategorieEntity.getKategorienName(),
                kategorieEntity.getKategorienBeschreibung(),
                restaurantIds
        );
    }
}
