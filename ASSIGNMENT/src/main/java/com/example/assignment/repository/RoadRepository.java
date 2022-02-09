package com.example.assignment.repository;

import com.example.assignment.entity.District;
import com.example.assignment.entity.RoadName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoadRepository extends JpaRepository<RoadName, Integer> {
    @Query("select r from RoadName r where r.roadName = :roadName and r.id = :id")
    List<RoadName> searchRoadName(String roadName, int id);

//    List<RoadName> findRoadNameByDistrict_Id(int id);
}
