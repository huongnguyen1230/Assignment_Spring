package com.example.assignment.service;


import com.example.assignment.entity.RoadName;

import java.util.List;
import java.util.Optional;

public interface RoadService {

    List<RoadName> findAll();

    Optional<RoadName> findById(int id);

    boolean delete(RoadName roadName);

    RoadName update(RoadName roadName);
    RoadName save(RoadName roadName);
}
