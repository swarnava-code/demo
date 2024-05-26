package com.swarna.graphql_demo.controller;

import com.swarna.graphql_demo.model.Item;
import com.swarna.graphql_demo.model.Location;
import com.swarna.graphql_demo.model.Product;
import com.swarna.graphql_demo.repository.ItemRepository;
import com.swarna.graphql_demo.repository.LocationRepository;
import com.swarna.graphql_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class ItemController {
    private final ItemRepository itemRepository;
    private final ProductRepository productRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository, ProductRepository productRepository, LocationRepository locationRepository) {
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
        this.locationRepository = locationRepository;
    }

    @QueryMapping
    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    @MutationMapping
    public Location createLocation(
            @Argument final String area,
            @Argument final String coordinates,
            @Argument final String pinCode,
            @Argument final String address,
            @Argument final String country,
            @Argument final String state,
            @Argument final String fcName
    ) {
        var location = Location.builder()
                .area(area)
                .coordinates(coordinates)
                .pinCode(pinCode)
                .address(address)
                .country(country)
                .state(state)
                .fcName(fcName)
                .build();
        return locationRepository.save(location);
    }

    @QueryMapping
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    @MutationMapping
    public Product createProduct(
            @Argument String productName,
            @Argument String brand,
            @Argument String color,
            @Argument String material,
            @Argument String shape,
            @Argument String notes,
            @Argument String extraNotes
    ){
        return productRepository.save(
                new Product(null, productName, brand, color, material, shape, notes, extraNotes)
        );
    }

    @QueryMapping
    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }

    @MutationMapping
    public Item createItem(
            @Argument Float mrpPrice,
            @Argument Integer discountByPercentage,
            @Argument Integer productId,
            @Argument Integer locationId
    ) {
        Product product = productRepository.getReferenceById(productId);
        Location location = locationRepository.getReferenceById(locationId);
        return itemRepository.save(
                new Item(null, mrpPrice, discountByPercentage, product, location)
        );
    }

    @QueryMapping
    public Item findItem(@Argument Integer id){
        return itemRepository.findById(id).get();
    }

}
