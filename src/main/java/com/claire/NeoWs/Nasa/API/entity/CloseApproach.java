package com.claire.NeoWs.Nasa.API.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "close_approaches")
public class CloseApproach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "approach_date")
    private Date date;

    private double kilometersPerSecond;
    private double kilometersMissDistance;

    @ManyToOne
    private NearEarthObject neo;
}
