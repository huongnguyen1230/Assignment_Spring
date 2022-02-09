package com.example.assignment.service;

import com.example.assignment.entity.District;
import com.example.assignment.entity.RoadName;
import com.example.assignment.repository.DistrictRepository;
import com.example.assignment.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService{
    @Autowired
    DistrictRepository districtRepository;
    @Override
    public District save(District district) {
        return districtRepository.save(district);
    }

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public Optional<District> findById(int id) {
        return districtRepository.findById(id);
    }

    @Override
    public District update(District district) {
        return districtRepository.save(district);
    }
}
