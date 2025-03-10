package com.claire.NeoWs.Nasa.API.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "relative_velocities")
public class RelativeVelocity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private double kilometersPerSecond;
    private double kilometersPerHour;
    private double milesPerHour;
}
