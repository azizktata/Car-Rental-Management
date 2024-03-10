package com.example.ParcAuto.Models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
@Embeddable
public class Consommation {
    private String kilometrage;
    private String gazoile;
}
