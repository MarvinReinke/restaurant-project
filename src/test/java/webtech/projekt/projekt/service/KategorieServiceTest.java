package webtech.projekt.projekt.service;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import webtech.projekt.projekt.persistence.KategorieRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class KategorieServiceTest implements WithAssertions {

    @Mock
    private KategorieRepository repository;

    @InjectMocks
    private KategorieService underTest;

    @Test
    @DisplayName("should return true if delete was successfull")
    void should_return_true_if_delete_was_successfull() {
        //given
        Long givenId = 321L;
        doReturn(true).when(repository).existsById(givenId);

        //when
        boolean result = underTest.deleteById(givenId);

        //then
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if category to delete was not successfull")
    void should_return_false_if_category_to_delete_was_not_successfull() {
        //given
        Long givenId = 321L;
        doReturn(false).when(repository).existsById(givenId);

        //when
        boolean result = underTest.deleteById(givenId);

        //then
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}
