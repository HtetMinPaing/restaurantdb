package com.paing.restaurantdb.repositories;

import com.paing.restaurantdb.domain.entity.MenuEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuRepository extends CrudRepository<MenuEntity, Long>,
        PagingAndSortingRepository<MenuEntity, Long> {
}
