package webtech.projekt.projekt.web;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import webtech.projekt.projekt.api.Kategorie;
import webtech.projekt.projekt.service.KategorieService;

import javax.print.attribute.standard.Media;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(KategorieRestController.class)
class KategorieRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KategorieService kategorieService;

    @Test
    @DisplayName("should return found categories from kategorie service")
    void should_return_found_categories_from_kategorie_service() throws Exception{
    //given
        var kategorien = List.of(
                new Kategorie(1, "Asiatisch", "Hier sind asiatische Restaurants", Collections.emptyList()),
                new Kategorie(2, "Italienisch", "Hier sind italienische Restaurants", Collections.emptyList()));
        doReturn(kategorien).when(kategorieService).findAll();

        //when
        mockMvc.perform(get("/api/v1/kategorien"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].kategorienName").value("Asiatisch"))
                .andExpect(jsonPath("$[0].kategorienBeschreibung").value("Hier sind asiatische Restaurants"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].kategorienName").value("Italienisch"))
                .andExpect(jsonPath("$[1].kategorienBeschreibung").value("Hier sind italienische Restaurants"));
    }

    @Test
    @DisplayName("should return 404 if kategorie is not found")
    void should_return_404_if_kategorie_is_not_found() throws Exception{
        //given
        doReturn(null).when(kategorieService).findById(anyLong());

        //when
        mockMvc.perform(get("/api/v1/kategorien/2348"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a kategorie")
    void should_return_201_http_status_and_location_header_when_creating_a_kategorie() throws Exception {
        String kategorieToCreateAsJson = "{\"kategorienName\": \"Asiatisch\", \"kategorienBeschreibung\":\"Hier findest du asiatische Restaurants\"}";
        var kategorie = new Kategorie(341, null, null, null);
        doReturn(kategorie).when(kategorieService).create(any());

        //when
        mockMvc.perform(
                post("/api/v1/kategorien")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(kategorieToCreateAsJson)
        )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/kategorien/" + kategorie.getId()))));
    }

    @Test
    @DisplayName("should validate create kategorie request with too short name")
    void should_validate_create_kategorie_request_with_too_short_name() throws Exception {
        //given
        String kategorieToCreateAsJson = "{\"kategorienName\": \"A\", \"kategorienBeschreibung\":\"Hier findest du asiatische Restaurants\"}";

        //when
        mockMvc.perform(
                post("/api/v1/kategorien")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(kategorieToCreateAsJson)
        )
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("should validate create kategorie request with empty beschreibung field")
    void should_validate_create_kategorie_request_with_empty_beschreibung_field() throws Exception {
        //given
        String kategorieToCreateAsJson = "{\"kategorienName\": \"Asiatisch\", \"kategorienBeschreibung\":\"\"}";

        //when
        mockMvc.perform(
                post("/api/v1/kategorien")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(kategorieToCreateAsJson)
        )
                .andExpect(status().isBadRequest());
    }
}
