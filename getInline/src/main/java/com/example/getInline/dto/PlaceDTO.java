package com.example.getInline.dto;

import com.example.getInline.constant.PlaceType;
import com.example.getInline.domain.AdminPlaceMap;

public record PlaceDTO(
        PlaceType placeType,
        String placeName,
        String address,
        String phoneNumber,
        Integer capacity,
        String memo) {
    public static PlaceDTO of(PlaceType placeType, String placeName, String address, String phoneNumber, Integer capacity, String memo) {
        return new PlaceDTO(placeType, placeName, address, phoneNumber, capacity, memo);
    }
}
