package com.example.reactivedemo.controller;

import com.example.reactivedemo.model.Dummy;
import com.example.reactivedemo.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DummyController {

    public final DummyService dummyService;

    @Autowired
    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @PostMapping("/dummy")
    public Mono<Dummy> insertData(@RequestBody Dummy dummy){
        return dummyService.insertData(dummy);
    }

    @PutMapping("/dummy")
    public Mono<Dummy> updateData(@RequestBody Dummy dummy){
        return dummyService.updateData(dummy);
    }

    @GetMapping("/dummy")
    public Mono<Dummy> getData(@RequestParam Integer id){
        return dummyService.getData(id);
    }

    @GetMapping("/dummy/all")
    public Flux<Dummy> getAllData(){
        return dummyService.getAllData();
    }

    @DeleteMapping("/dummy")
    public Mono<Void> deleteData(@RequestParam Integer id){
        return dummyService.deleteData(id);
    }

    @RequestMapping("/test")
    public String test(){
        return "connected";
    }

}
