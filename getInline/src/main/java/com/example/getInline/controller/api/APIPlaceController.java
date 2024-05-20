package com.example.getInline.controller.api;

import com.example.getInline.constant.PlaceType;
import com.example.getInline.domain.Place;
import com.example.getInline.dto.APIDateResponse;
import com.example.getInline.dto.PlaceDTO;
import com.example.getInline.dto.PlaceResponse;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIPlaceController {

    @GetMapping("/places")
    public APIDateResponse<List<PlaceResponse>> getPlaces() {
        return APIDateResponse.of(List.of(PlaceResponse.of(PlaceType.COMMON,
                "필라배드민턴장",
                "서울시 강남구",
                "010-1234-5678",
                30,
                "신장개업")));
    }

    @PostMapping("/places")
    public Boolean createPlace() {
        return true;
    }

    @GetMapping("/places/{placeId}")
    public APIDateResponse<PlaceDTO> getPlace(@PathVariable Integer placeId) {
        if (placeId.equals(2)) {
            return APIDateResponse.of(null);
        }
        return APIDateResponse.of(PlaceDTO.of(PlaceType.COMMON,
                "필라배드민턴장",
                "서울시 강남구",
                "010-1234-5678",
                30,
                "신장개업"));
    }

    @PutMapping("/places/{placeId}")
    public Boolean modifyPlace(@PathVariable Integer placeId) {
        return true;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean removePlace(@PathVariable Integer placeId) {
        return true;
    }
}