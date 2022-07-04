package webtech.projekt.projekt.web;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webtech.projekt.projekt.api.Kategorie;
import webtech.projekt.projekt.api.KategorieManipulationRequest;
import webtech.projekt.projekt.service.KategorieService;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
public class KategorieRestController {

    private final KategorieService kategorieService;

    public KategorieRestController(KategorieService kategorieService){
        this.kategorieService = kategorieService;
    }

    @GetMapping(path = "/api/v1/kategorien")
    public ResponseEntity<List<Kategorie>> fetchKategorien() {
        return ResponseEntity.ok(kategorieService.findAll());
    }

    @GetMapping(path = "/api/v1/kategorien/{id}")
    public ResponseEntity<Kategorie> fetchKategorieById(@PathVariable Long id){
        var kategorie = kategorieService.findById(id);
        return kategorie != null? ResponseEntity.ok(kategorie) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/kategorien")
    public ResponseEntity<Void> createKategorie(@Valid @RequestBody KategorieManipulationRequest request) throws URISyntaxException{
        var kategorie = kategorieService.create(request);
        URI uri = new URI("/api/v1/kategorien/" + kategorie.getId());
        return ResponseEntity
                .created(uri)
                .header("Acces-Control-Expose-Headers", "Location")
                .build();
    }

    @PutMapping(path = "/api/v1/kategorien({id}")
    public ResponseEntity<Kategorie> updateKategorie(@PathVariable Long id, @RequestBody KategorieManipulationRequest request){
        var kategorie = kategorieService.update(id, request);
        return kategorie != null? ResponseEntity.ok(kategorie) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/kategorien/{id}")
    public ResponseEntity<Void> deleteKategorie(@PathVariable Long id){
        boolean successful = kategorieService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
