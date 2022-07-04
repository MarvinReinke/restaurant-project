package webtech.projekt.projekt.service;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import webtech.projekt.projekt.persistence.RestaurantRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest implements WithAssertions {

    @Mock
    private RestaurantRepository repository;

    @InjectMocks
    private RestaurantService underTest;

    @Test
    @DisplayName("should return true if delete was successfull")
    void should_return_true_if_delete_was_successfull(){
        //given
        Long givenId = 30L;
        doReturn(true).when(repository).existsById(givenId);

        //when
        boolean result = underTest.deleteById(givenId);

        //then
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if restaurant to delete does not exist")
    void should_return_false_if_restaurant_to_delete_does_not_exist(){
        //given
        Long givenId = 30L;
        doReturn(false).when(repository).existsById(givenId);

        //when
        boolean result = underTest.deleteById(givenId);

        //then
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();

    }

}
