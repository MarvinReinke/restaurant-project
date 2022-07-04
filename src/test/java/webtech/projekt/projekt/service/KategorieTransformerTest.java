package webtech.projekt.projekt.service;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import webtech.projekt.projekt.persistence.KategorieEntity;
import webtech.projekt.projekt.persistence.RestaurantEntity;

import java.util.List;

import static org.mockito.Mockito.doReturn;

class KategorieTransformerTest implements WithAssertions {
    private final KategorieTransformer underTest = new KategorieTransformer();

    @Test
    @DisplayName("should transform KategorieEntity to Kategorie")
    void should_transform_kategorie_entity_to_kategorie() {
        //given
        var kategorieEntity = Mockito.mock(KategorieEntity.class);
        doReturn(60L).when(kategorieEntity).getId();
        doReturn("Amerikanisch").when(kategorieEntity).getKategorienName();
        doReturn("Dies ist eine Beschreibung").when(kategorieEntity).getKategorienBeschreibung();
        doReturn(List.of(new RestaurantEntity())).when(kategorieEntity).getRestaurants();

        //when
        var result = underTest.transformEntity(kategorieEntity);

        //then
        assertThat(result.getId()).isEqualTo(60L);
        assertThat(result.getKategorienName()).isEqualTo("Amerikanisch");
        assertThat(result.getKategorienBeschreibung()).isEqualTo("Dies ist eine Beschreibung");
        assertThat(result.getRestaurants()).hasSize(1);
    }


}
