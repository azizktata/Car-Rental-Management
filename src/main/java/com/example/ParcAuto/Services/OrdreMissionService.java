package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.MissionRequest;
import com.example.ParcAuto.DTOs.Requests.MissionUpdateRequest;
import com.example.ParcAuto.Enum.StatusMission;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Consommation;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Models.OrdreMission;
import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Repository.EmployeRepository;
import com.example.ParcAuto.Repository.OrdreMissionRepository;
import com.example.ParcAuto.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdreMissionService {
    @Autowired
    private OrdreMissionRepository ordreMissionRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private VoitureRepository voitureRepository;

    public OrdreMission getOrdreMission(Long missionId){
        return ordreMissionRepository.findById(missionId).orElseThrow(()-> new ObjectNotFoundException("Mission not found"));
    }

    public List<OrdreMission> getAllMissions(){
        return ordreMissionRepository.findAll();
    }

    public List<OrdreMission> getMissionsByEmployeId(Long employeId){
        return ordreMissionRepository.findByEmployeId(employeId);
    }
    public List<OrdreMission> getMissionsByVoitureId(Long voitureId){
        return ordreMissionRepository.findByVoitureId(voitureId);
    }

    public OrdreMission addMission(Long employeId, Long voitureId, MissionRequest missionRequest){
        Employe employe = employeRepository.findById(employeId).orElseThrow(()-> new ObjectNotFoundException("employe not found"));
        Voiture voiture = voitureRepository.findById(voitureId).orElseThrow(()-> new ObjectNotFoundException("voiture not found"));
        OrdreMission ordreMission = OrdreMission.builder()
                .locationDebut(missionRequest.getLocationDebut())
                .locationFin(missionRequest.getLocationFin())
                .dateDebut(missionRequest.getDateDebut())
                .dateFin(missionRequest.getDateFin())
                .companions(missionRequest.getCompanions())
                .statusMission(StatusMission.Encours)
                .employe(employe)
                .voiture(voiture)
                .build();
        return ordreMissionRepository.save(ordreMission);
    }

    public OrdreMission changeMissionStatus(Long missionId, String status){
        OrdreMission ordreMission = ordreMissionRepository.findById(missionId).orElseThrow(()-> new ObjectNotFoundException("Mission not found"));

        if (status == "ok"){
            ordreMission.setStatusMission(StatusMission.Valider);
        }
        else if (status == "ko")
            ordreMission.setStatusMission(StatusMission.Refuser);

        return ordreMissionRepository.save(ordreMission);
    }

    public OrdreMission ajoutConsommationEtReport(Long missionId, MissionUpdateRequest request){
        OrdreMission ordreMission = ordreMissionRepository.findById(missionId).orElseThrow(()-> new ObjectNotFoundException("Mission not found"));
        ordreMission.setConsommation(request.getConsommation());
        ordreMission.setReport(request.getReport());
        return ordreMissionRepository.save(ordreMission);
    }
    public void deleteMission(Long missionId){
        ordreMissionRepository.deleteById(missionId);
    }
}
