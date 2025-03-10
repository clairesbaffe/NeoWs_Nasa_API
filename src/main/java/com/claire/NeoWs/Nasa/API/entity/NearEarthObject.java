package com.claire.NeoWs.Nasa.API.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
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

    private boolean isPotentiallyHazardousAsteroid;

    private Date orbitDeterminationDate;
    private Date firstObservationDate;
    private Date lastObservationDate;

    private int dataArcInDays;
    private int observationsUsed;
    private String orbitUncertainty;
    private double minimumOrbitIntersection;

    private double eccentricity;
    private double semiMajorAxis;
    private double inclination;
    private double ascendingNodeLongitude;
    private double orbitalPeriod;

    private double perihelionDistance;
    private double perihelionArgument;
    private double aphelionDistance;
    private double perihelionTime;

    private double meanAnomaly;
    private double meanMotion;
    private double equinox;

    @OneToMany(mappedBy = "neo")
    private List<CloseApproach> closeApproaches;
}
