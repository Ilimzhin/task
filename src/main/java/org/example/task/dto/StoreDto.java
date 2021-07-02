package org.example.task.dto;

import org.example.task.domain.Store;

public class StoreDto {

    private Long id;

    private String name;

    private String country;

    public StoreDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static StoreDto fromEntity(final Store entity) {
        final var storeDto = new StoreDto();
        storeDto.setId(entity.getId());
        storeDto.setName(entity.getName());
        storeDto.setCountry(entity.getCountry());
        return storeDto;
    }

}
