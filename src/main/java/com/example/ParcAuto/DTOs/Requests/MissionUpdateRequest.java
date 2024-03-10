package com.example.ParcAuto.DTOs.Requests;

import com.example.ParcAuto.Models.Consommation;
import com.example.ParcAuto.Models.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionUpdateRequest {
    private Consommation consommation;
    private Report report;
}
