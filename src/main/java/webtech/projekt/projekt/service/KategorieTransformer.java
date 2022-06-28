package webtech.projekt.projekt.service;

import org.springframework.stereotype.Service;
import webtech.projekt.projekt.api.Kategorie;
import webtech.projekt.projekt.persistence.KategorieEntity;

@Service
public class KategorieTransformer {
    public Kategorie transformEntity(KategorieEntity kategorieEntity){
        var restaurantId = kategorieEntity.getRestaurant() != null ? kategorieEntity.getRestaurant().getId() : null;
        return new Kategorie(
                kategorieEntity.getId(),
                kategorieEntity.getKategorienName(),
                kategorieEntity.getKategorienBeschreibung(),
                restaurantId
        );
    }
}
