package com.example.assignment.controller;

import com.example.assignment.entity.District;
import com.example.assignment.entity.RoadName;
import com.example.assignment.repository.DistrictRepository;
import com.example.assignment.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/districts")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    //get list
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(districtService.findAll(), HttpStatus.OK);
    }

    //create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody District district){
        districtService.save(district);
        return new ResponseEntity<>(district, HttpStatus.CREATED);
    }

    //get details
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id){
        Optional<District> optionalUser = districtService.findById(id);
        if (optionalUser.isPresent()){
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    //update
    @RequestMapping(method = RequestMethod.PUT, path = "{id}") //1: id
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody District updateDistrict){
        Optional<District> optionalDistrict = districtService.findById(id);
        if (optionalDistrict.isPresent()){
            District district = optionalDistrict.get();
            district.setDistrictName(updateDistrict.getDistrictName());
            districtService.save(district);
            return new ResponseEntity<>(district, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
