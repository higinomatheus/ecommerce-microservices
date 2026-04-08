package com.matheushigino.microservices.shoppingapi.model;

import com.matheushigino.microservices.shoppingapi.dto.ShopDTO;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shop")
@Table(name = "shop", schema = "shopping")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userIdentifier;
    private LocalDateTime date;
    private float total;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Item> items;

    public static Shop convert(ShopDTO shopDTO){
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setTotal(shopDTO.getTotal());
        shop.setDate(shopDTO.getDate());

        List<Item> items = shopDTO.getItems()
                .stream()
                .map(Item::convert)
                .collect(Collectors.toList());

        items.forEach(item -> item.setShop(shop));

        shop.setItems(items);

        return shop;
    }
}
