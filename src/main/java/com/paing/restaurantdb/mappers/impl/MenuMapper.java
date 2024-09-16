package com.paing.restaurantdb.mappers.impl;

import com.paing.restaurantdb.domain.dto.MenuDto;
import com.paing.restaurantdb.domain.entity.MenuEntity;
import com.paing.restaurantdb.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper implements Mapper<MenuEntity, MenuDto> {

    ModelMapper modelMapper;

    public MenuMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MenuDto mapTo(MenuEntity menuEntity) {
        return modelMapper.map(menuEntity, MenuDto.class);
    }

    @Override
    public MenuEntity mapFrom(MenuDto menuDto) {
        return modelMapper.map(menuDto, MenuEntity.class);
    }
}
