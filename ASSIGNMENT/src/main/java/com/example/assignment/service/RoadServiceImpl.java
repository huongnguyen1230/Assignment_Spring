package com.example.assignment.service;

import com.example.assignment.entity.RoadName;
import com.example.assignment.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoadServiceImpl implements RoadService{
    @Autowired
    RoadRepository roadRepository;
    @Override
    public RoadName save(RoadName roadName) {
        return roadRepository.save(roadName);
    }

    @Override
    public List<RoadName> findAll() {
        return roadRepository.findAll();
    }

    @Override
    public Optional<RoadName> findById(int id) {
        return roadRepository.findById(id);
    }

    @Override
    public boolean delete(RoadName roadName) {
        roadRepository.delete(roadName);
        return true;
    }

    @Override
    public RoadName update(RoadName roadName) {
        return roadRepository.save(roadName);
    }
}
