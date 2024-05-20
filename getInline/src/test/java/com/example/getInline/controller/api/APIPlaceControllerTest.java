package com.example.getInline.controller.api;

import static org.junit.jupiter.api.Assertions.*;

import com.example.getInline.constant.ErrorCode;
import com.example.getInline.constant.PlaceType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@WebMvcTest(APIPlaceController.class)
class APIPlaceControllerTest {

    private final MockMvc mvc;

    public APIPlaceControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[API] [GET] 장소 리스트 조회")
    @Test
    void givenNothing_whenRequestPlaces_thenReturnListOfPlacesInStandardResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/places"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].placeType").value(PlaceType.COMMON.name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].placeName").value("필라배드민턴장"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].address").value("서울시 강남구"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].phoneNumber").value("010-1234-5678"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].capacity").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].memo").value("신장개업"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(ErrorCode.OK.getMessage()));

    }

    @DisplayName("[API] [GET] 단일 장소 조회")
    @Test
    void givenPlaceId_whenRequestPlace_thenReturnPlaceInStandardResponse() throws Exception {
        int placeId = 1;

        mvc.perform(MockMvcRequestBuilders.get("/api/places/" + placeId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isMap())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.placeType").value(PlaceType.COMMON.name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.placeName").value("필라배드민턴장"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.address").value("서울시 강남구"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.phoneNumber").value("010-1234-5678"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.capacity").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.memo").value("신장개업"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(ErrorCode.OK.getMessage()));

    }

    @DisplayName("[API] [GET] 단일 장소 조회 - 장소 없는 경우")
    @Test
    void givenPlaceId_whenRequestPlace_thenReturnEmptyInStandardResponse() throws Exception {
        int placeId = 2;

        mvc.perform(MockMvcRequestBuilders.get("/api/places/" + placeId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(ErrorCode.OK.getMessage()));

    }

}