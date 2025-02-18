package com.claire.NeoWs.Nasa.API.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "near_earth_objects")
public class NearEarthObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int neoReferenceId;
    private String name;
    private String nameLimited;

    @Column(name = "absolute_magnitude_h")
    private double absoluteMagnitudeH;

    private double estimatedDiameterMin;
    private double estimatedDiameterMax;

    @OneToMany(mappedBy = "neo")
    private List<CloseApproach> closeApproaches;
}
