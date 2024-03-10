package com.example.ParcAuto.Models;

import com.example.ParcAuto.Enum.StatusMission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrdreMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private StatusMission statusMission;
    private Date dateDebut;
    private Date dateFin;
    private String locationDebut;
    private String locationFin;
    private List<String> companions = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private Employe employe;
    @ManyToOne
    @JsonIgnore
    private Voiture voiture;
    @Embedded
    private Consommation consommation;
    @Embedded
    private Report report;
}
