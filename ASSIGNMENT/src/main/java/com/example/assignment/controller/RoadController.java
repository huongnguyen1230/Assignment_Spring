package com.example.assignment.controller;

import com.example.assignment.entity.RoadName;
import com.example.assignment.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/v1/roads")
public class RoadController {
    @Autowired
    RoadService roadService;

    //get list
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10")int limit )
    {
        HashMap<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("limit", limit);
        response.put("data", roadService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody RoadName roadName){
        roadService.save(roadName);
        return new ResponseEntity<>(roadName, HttpStatus.CREATED);
    }

    //get details
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id){
        Optional<RoadName> optionalUser = roadService.findById(id);
        if (optionalUser.isPresent()){
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    //update
    @RequestMapping(method = RequestMethod.PUT, path = "{id}") //1: id
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody RoadName updateRoad){
        Optional<RoadName> optionalRoad = roadService.findById(id);
        if (optionalRoad.isPresent()){
            RoadName roadName = optionalRoad.get();
            roadName.setRoadName(updateRoad.getRoadName());
            roadName.setCreateAt(updateRoad.getCreateAt());
            roadName.setDescription(updateRoad.getDescription());
            roadName.setStatus(updateRoad.getStatus());
            roadService.save(roadName);
            return new ResponseEntity<>(roadName, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //delete
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<Object>  delete(@PathVariable int id) {
        Optional<RoadName> optionalRoadName = roadService.findById(id);
        if (optionalRoadName.isPresent()) {
            roadService.delete(optionalRoadName.get());
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}

