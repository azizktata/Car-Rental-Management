package com.example.ParcAuto.DTOs.Requests;

import com.example.ParcAuto.Enum.StatusMission;
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
public class MissionRequest {
    private Date dateDebut;
    private Date dateFin;
    private String locationDebut;
    private String locationFin;
    private List<String> companions = new ArrayList<>();
}
