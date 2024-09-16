package com.paing.restaurantdb.services.impl;

import com.paing.restaurantdb.domain.entity.MenuEntity;
import com.paing.restaurantdb.repositories.MenuRepository;
import com.paing.restaurantdb.services.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public MenuEntity save(MenuEntity menuEntity) {
        return menuRepository.save(menuEntity);
    }

    @Override
    public Page<MenuEntity> findAll(Pageable pageable) {
        return menuRepository.findAll(pageable);
    }

    @Override
    public Optional<MenuEntity> findOne(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public Boolean isPresent(Long id) {
        return menuRepository.existsById(id);
    }

    @Override
    public MenuEntity partialUpdate(Long id, MenuEntity menuEntity) {
        menuEntity.setId(id);
        return menuRepository.findById(id).map(existingMenu -> {
            Optional.ofNullable(menuEntity.getName()).ifPresent(existingMenu::setName);
            Optional.ofNullable(menuEntity.getDescription()).ifPresent(existingMenu::setDescription);
            Optional.ofNullable(menuEntity.getPrice()).ifPresent(existingMenu::setPrice);
            Optional.ofNullable(menuEntity.getImage()).ifPresent(existingMenu::setImage);
            Optional.ofNullable(menuEntity.getStars()).ifPresent(existingMenu::setStars);
            Optional.ofNullable(menuEntity.getDiscountRate()).ifPresent(existingMenu::setDiscountRate);
            Optional.ofNullable(menuEntity.getTrending()).ifPresent(existingMenu::setTrending);
            Optional.ofNullable(menuEntity.getInDiscounted()).ifPresent(existingMenu::setInDiscounted);
            Optional.ofNullable(menuEntity.getOutOfStock()).ifPresent(existingMenu::setOutOfStock);
            Optional.ofNullable(menuEntity.getCategory()).ifPresent(existingMenu::setCategory);
            return existingMenu;
        }).orElseThrow(() -> new RuntimeException("Menu not found"));
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public MenuEntity update(Long id, MenuEntity menuEntity) {
        menuEntity.setId(id);
        return menuRepository.save(menuEntity);
    }
}
