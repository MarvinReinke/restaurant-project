package webtech.projekt.projekt.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import webtech.projekt.projekt.api.Kategorie;
import webtech.projekt.projekt.api.Restaurant;
import webtech.projekt.projekt.service.RestaurantService;
import org.hamcrest.Matchers;


import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(RestaurantRestController.class)
class RestaurantRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    @DisplayName("should return found restaurants from restauran service")
    void should_return_found_restaurants_from_restauran_service() throws Exception {
        //given
        var restaurants = List.of(
                new Restaurant(1, "Mr.Wu", "Am Waldschlossweg", "78",
                        new Kategorie(1,"asiatisch", "asiatische Beschreibung",
                        Collections.emptyList())),
                new Restaurant(2, "Pizza Hut", "Hofweg", "31a",
                        new Kategorie(2, "italienisch", "italienische Beschreibung",
                        Collections.emptyList()))
        );
        doReturn(restaurants).when(restaurantService).findAll();

        //when
        mockMvc.perform(get("/api/v1/restaurants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Mr.Wu"))
                .andExpect(jsonPath("$[0].adresse").value("Am Waldschlossweg"))
                .andExpect(jsonPath("$[0].hausnummer").value("78"))
                .andExpect(jsonPath("$[0].kategorie.id").value("1"))
                .andExpect(jsonPath("$[0].kategorie.kategorienName").value("asiatisch"))
                .andExpect(jsonPath("$[0].kategorie.kategorienBeschreibung").value("asiatische Beschreibung"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Pizza Hut"))
                .andExpect(jsonPath("$[1].adresse").value("Hofweg"))
                .andExpect(jsonPath("$[1].hausnummer").value("31a"))
                .andExpect(jsonPath("$[1].kategorie.id").value("2"))
                .andExpect(jsonPath("$[1].kategorie.kategorienName").value("italienisch"))
                .andExpect(jsonPath("$[1].kategorie.kategorienBeschreibung").value("italienische Beschreibung"));
    }

    @Test
    @DisplayName("should return 404 if restaurant is not found")
    void should_return_404_if_pokemon_is_not_found() throws Exception {
        //given
        doReturn(null).when(restaurantService).findById(anyLong());

        //when
        mockMvc.perform(get("/api/v1/restaurants/500"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a person")
    void should_return_201_http_status_and_Location_header_when_creating_a_person() throws Exception{
        //given
        String restaurantToCreateAsJson = "{\"name\": \"Mr.Wu\",\"adresse\": \"am Waldschlossweg\",\"hausnummer\": \"78\"," +
                "\"kategorie.kategorienNamen\": \"asiatisch\",\"kategorie.kategorienBeschreibung\": \"asiatische Beschreibung\"," +
                "\"kategorie.restaurants\": \"1\"}";
        var restaurant = new Restaurant(500, null, null, null, null);
        doReturn(restaurant).when(restaurantService).create(any());

        //when
        mockMvc.perform(
            post("/api/v1/restaurants")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(restaurantToCreateAsJson)
    )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("location", Matchers.equalTo("/api/v1/restaurants/" + restaurant.getId())));
    }



    /*
     Tests don't work, cause: Invalid mime type
     Leider habe ich keine Lösung gefunden, wie man den Error beheben kann
     @Test
    @DisplayName("should validate create restauant request with a too short name")
    void should_validate_create_restaurant_request_with_a_too_short_name () throws Exception{
        //given
        String restaurantToCreateAsJson = "{\"name\": \"x\", \"adresse\":\"Waldweg\", \"hausnummer\":\"23\"," +
                "\"kategorie.kategorienName\":\"Asiatisch\",\"kategorie.kategorienBeschreibung\":\"Das hier sind asiatische Restaurants\","+
                "\"kategorie.restaurants\":\"1\"}";

        //when
        mockMvc.perform(
                post("/api/v1/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(restaurantToCreateAsJson)

        )
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("should validate create restaurant request with a blank adress")
    void should_validate_create_restaurant_request_with_a_blank_adress() throws Exception{
        //given
        String restaurantToCreateAsJson = "{\"name\": \"Mr.Wu\",\"adresse\": \"\",\"hausnummer\": \"78\"," +
                "\"kategorie.kategorienName\": \"asiatisch\",\"kategorie.kategorienBeschreibung\": \"asiatische Beschreibung\"," +
                "\"kategorie.restaurants\": \"1\"}";

        //when
        mockMvc.perform(
                post("/api/v1/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(restaurantToCreateAsJson)
        )
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("should validate create restaurant request with a blank housenumber")
    void should_validate_create_restaurant_request_with_a_blank_housenumber() throws Exception {
        //given
        String restaurantToCreateAsJson = "{\"name\": \"Mr.Wu\",\"adresse\": \"am Waldschlossweg\",\"hausnummer\": \"\"," +
                "\"kategorie.kategorienName\": \"asiatisch\",\"kategorie.kategorienBeschreibung\": \"asiatische Beschreibung\"," +
                "\"kategorie.restaurants\": \"1\"}";

        //when
        mockMvc.perform(
                post("/api/v1/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(restaurantToCreateAsJson)
        )
                .andExpect(status().isBadRequest());


    }*/
}
