package com.example.assignment.service;

import com.example.assignment.entity.District;
import com.example.assignment.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService{
    @Autowired
    DistrictRepository districtRepository;

    @Override
    public List<District> findAll() {
        return null;
    }
}
