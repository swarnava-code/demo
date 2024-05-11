package com.example.reactivedemo.service;

import com.example.reactivedemo.model.Dummy;
import com.example.reactivedemo.repo.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DummyService {
    public final DemoRepo demoRepo;

    @Autowired
    public DummyService(DemoRepo demoRepo) {
        this.demoRepo = demoRepo;
    }

    public Mono<Dummy> insertData(Dummy dummy) {
        dummy.setId(null);
        return demoRepo.save(dummy);
    }

    public Mono<Dummy> updateData(Dummy dummy) {
        return demoRepo.save(dummy);
    }

    public Mono<Dummy> getData(Integer id) {
        return demoRepo.findById(id);
    }

    public Flux<Dummy> getAllData() {
        return demoRepo.findAll();
    }

    public Mono<Void> deleteData(Integer id) {
        return demoRepo.deleteById(id);
    }

}
