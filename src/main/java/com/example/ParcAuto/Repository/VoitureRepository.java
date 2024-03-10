package com.example.ParcAuto.Repository;

import com.example.ParcAuto.Models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
}
