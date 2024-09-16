package com.paing.restaurantdb.services;

import com.paing.restaurantdb.domain.entity.MenuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MenuService {
    MenuEntity save(MenuEntity menuEntity);

    Page<MenuEntity> findAll(Pageable pageable);

    Optional<MenuEntity> findOne(Long id);

    Boolean isPresent(Long id);

    MenuEntity partialUpdate(Long id, MenuEntity menuEntity);

    void delete(Long id);

    MenuEntity update(Long id, MenuEntity menuEntity);
}
