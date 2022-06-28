package webtech.projekt.projekt.service;

import org.springframework.stereotype.Service;
import webtech.projekt.projekt.api.Kategorie;
import webtech.projekt.projekt.api.KategorieManipulationRequest;
import webtech.projekt.projekt.api.Restaurant;
import webtech.projekt.projekt.persistence.KategorieEntity;
import webtech.projekt.projekt.persistence.KategorieRepository;
import webtech.projekt.projekt.persistence.RestaurantEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KategorieService {

    private final KategorieRepository kategorieRepository;
    private final KategorieTransformer kategorieTransformer;

    public KategorieService(KategorieRepository kategorieRepository, KategorieTransformer kategorieTransformer){
        this.kategorieRepository = kategorieRepository;
        this.kategorieTransformer = kategorieTransformer;
    }


    public List<Kategorie> findAll(){
        List<KategorieEntity> kategorien = kategorieRepository.findAll();
        return kategorien.stream()
                .map(kategorieTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Kategorie findById(Long id){
        var kategorieEntity = kategorieRepository.findById(id);
        return kategorieEntity.map(kategorieTransformer::transformEntity).orElse(null);
    }


    public Kategorie create(KategorieManipulationRequest request){
        var kategorieEntity = new KategorieEntity(request.getKategorienName(), request.getKategorienBeschreibung());
        kategorieEntity = kategorieRepository.save(kategorieEntity);
        return kategorieTransformer.transformEntity(kategorieEntity);
    }

    public Kategorie update(Long id, KategorieManipulationRequest request){
        var kategorieEntityOptional = kategorieRepository.findById(id);
        if (kategorieEntityOptional.isEmpty()){
            return null;
        }

        var kategorieEntity = kategorieEntityOptional.get();
        kategorieEntity.setKategorienName(request.getKategorienName());
        kategorieEntity.setKategorienBeschreibung(request.getKategorienBeschreibung());
        kategorieEntity = kategorieRepository.save(kategorieEntity);

        return kategorieTransformer.transformEntity(kategorieEntity);
    }

    public boolean deleteById(Long id){
        if(!kategorieRepository.existsById(id)){
            return false;
        }
        kategorieRepository.deleteById(id);
        return true;
    }
}
