package com.example.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roads")
public class RoadName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roadName;
    private LocalDate createAt;
    private String description;
    private int status;

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false)
    private District district;
}
