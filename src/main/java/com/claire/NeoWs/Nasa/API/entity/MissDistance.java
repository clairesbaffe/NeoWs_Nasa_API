package com.claire.NeoWs.Nasa.API.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "miss_distances")
public class MissDistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private double astronomical;
    private double lunar;
    private double kilometers;
    private double miles;
}
