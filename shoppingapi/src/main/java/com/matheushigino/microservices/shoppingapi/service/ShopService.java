package com.matheushigino.microservices.shoppingapi.service;

import com.matheushigino.microservices.shoppingapi.dto.ShopDTO;
import com.matheushigino.microservices.shoppingapi.model.Shop;
import com.matheushigino.microservices.shoppingapi.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public List<ShopDTO> getAll(){
        List<Shop> shops = shopRepository.findAll();
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }
}
