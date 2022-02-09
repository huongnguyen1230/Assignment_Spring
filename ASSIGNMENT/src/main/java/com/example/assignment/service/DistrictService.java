package com.example.assignment.service;

import com.example.assignment.entity.District;
import com.example.assignment.entity.RoadName;

import java.util.List;
import java.util.Optional;

public interface DistrictService {
    List<District> findAll();
    Optional<District> findById(int id);

    District update(District district);
    District save(District district);
}
