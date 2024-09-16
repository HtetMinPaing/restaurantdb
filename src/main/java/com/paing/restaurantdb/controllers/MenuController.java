package com.paing.restaurantdb.controllers;

import com.paing.restaurantdb.domain.dto.MenuDto;
import com.paing.restaurantdb.domain.entity.MenuEntity;
import com.paing.restaurantdb.mappers.impl.MenuMapper;
import com.paing.restaurantdb.services.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MenuController {

    private MenuService menuService;
    private MenuMapper menuMapper;

    public MenuController(MenuService menuService, MenuMapper menuMapper) {
        this.menuService = menuService;
        this.menuMapper = menuMapper;
    }

    @PostMapping(path = "/menu")
    public ResponseEntity<MenuDto> saveMenu(
            @RequestBody MenuDto menuDto
    ) {
        MenuEntity menuEntity = menuMapper.mapFrom(menuDto);
        MenuEntity savedMenu = menuService.save(menuEntity);
        MenuDto returnMenu = menuMapper.mapTo(savedMenu);
        return new ResponseEntity<>(returnMenu, HttpStatus.CREATED);
    }

    @GetMapping(path = "/menu")
    public Page<MenuDto> listMenu(Pageable pageable) {
        Page<MenuEntity> menus = menuService.findAll(pageable);
        return menus.map(menuMapper::mapTo);
    }

    @GetMapping(path = "/menu/{id}")
    public ResponseEntity<MenuDto> getMenu(
            @PathVariable("id") Long id
    ) {
        Optional<MenuEntity> foundMenu = menuService.findOne(id);
        return foundMenu.map(menuEntity -> {
            MenuDto menuDto = menuMapper.mapTo(menuEntity);
            return new ResponseEntity<>(menuDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));

    }

    @PostMapping(path = "/menu/{id}")
    public ResponseEntity<MenuDto> fullUpdateMenu(
            @PathVariable("id") Long id,
            @RequestBody MenuDto menuDto
    ) {
        Boolean isMenuExisted = menuService.isPresent(id);
        MenuEntity menuEntity = menuMapper.mapFrom(menuDto);
        MenuEntity savedMenu = menuService.update(id, menuEntity);
        MenuDto returnMenu = menuMapper.mapTo(savedMenu);
        return new ResponseEntity<>(returnMenu, HttpStatus.OK);
    }

    @PatchMapping(path = "/menu/{id}")
    public ResponseEntity<MenuDto> partialUpdateMenu(
            @PathVariable("id") Long id,
            @RequestBody MenuDto menuDto
    ) {
        if(!menuService.isPresent(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MenuEntity menuEntity = menuMapper.mapFrom(menuDto);
        MenuEntity saveMenu = menuService.partialUpdate(id, menuEntity);
        MenuDto returnMenu = menuMapper.mapTo(saveMenu);
        return new ResponseEntity<>(returnMenu, HttpStatus.OK);
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity deleteMenu(@PathVariable("id") Long id) {
        menuService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
