package com.example.ParcAuto.Models;

import com.example.ParcAuto.Enum.TypeMaintenance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private TypeMaintenance type;

    @ManyToOne
    private Voiture voiture;
}
