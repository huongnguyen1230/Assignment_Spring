package com.example.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String districtName;
    private String description;

    @OneToMany(mappedBy = "district")
    @JsonIgnore
    private Set<RoadName> roadNameSet;
}
