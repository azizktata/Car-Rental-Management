package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.DashboardResponse;
import com.example.ParcAuto.DTOs.Requests.LoginRequest;
import com.example.ParcAuto.DTOs.Requests.LoginResponse;
import com.example.ParcAuto.DTOs.Requests.RegisterRequest;
import com.example.ParcAuto.Enum.StatusMission;
import com.example.ParcAuto.Enum.StatusVoiture;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Repository.EmployeRepository;
import com.example.ParcAuto.Repository.OrdreMissionRepository;
import com.example.ParcAuto.Repository.ReportRespository;
import com.example.ParcAuto.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashService {
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private ReportRespository reportRespository;
    @Autowired
    private OrdreMissionRepository missionRepository;


    public DashboardResponse getDashData(){
        return DashboardResponse.builder()
                .numClient(employeRepository.count())
                .numMission(missionRepository.count())
                .numReport(reportRespository.count())
                .numVoiture(voitureRepository.count())
                .missionE(missionRepository.countByStatusMission(StatusMission.Encours))
                .missionA(missionRepository.countByStatusMission(StatusMission.Annulé))
                .missionV(missionRepository.countByStatusMission(StatusMission.Validé))
                .voitureDispo(voitureRepository.countByStatusVoiture(StatusVoiture.disponible))
                .voitureIndispo(voitureRepository.countByStatusVoiture(StatusVoiture.indisponible))
                .voitureParPort(voitureRepository.findVoituresByPort())
                .build();

    }



}
