package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.Models.Voiture;
import com.example.ParcAuto.Services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    @GetMapping
    public List<Voiture> getAll(){
        return voitureService.getLesVoitures();
    }

    @GetMapping("/{id}")
    public Voiture getVoiture(@PathVariable Long voitureId){
        return voitureService.getVoiture(voitureId);
    }
}
