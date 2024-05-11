package com.example.reactivedemo.repo;

import com.example.reactivedemo.model.Dummy;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DemoRepo extends ReactiveCrudRepository<Dummy, Integer> {
}