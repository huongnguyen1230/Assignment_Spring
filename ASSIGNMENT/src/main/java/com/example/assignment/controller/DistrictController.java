package com.example.assignment.controller;

import com.example.assignment.entity.District;
import com.example.assignment.repository.DistrictRepository;
import com.example.assignment.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/districts")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(){

        return new ResponseEntity<>(districtService.findAll(), HttpStatus.OK);
    }
}
