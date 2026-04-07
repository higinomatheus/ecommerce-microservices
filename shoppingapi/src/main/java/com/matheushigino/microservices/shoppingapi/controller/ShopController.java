package com.matheushigino.microservices.shoppingapi.controller;

import com.matheushigino.microservices.shoppingapi.dto.ShopDTO;
import com.matheushigino.microservices.shoppingapi.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @GetMapping("/shopping")
    public List<ShopDTO> getShops(){
        return shopService.getAll();
    }
}
