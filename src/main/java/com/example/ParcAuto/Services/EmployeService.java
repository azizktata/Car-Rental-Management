package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.EmployeRequest;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    public Employe addEmploye(Employe employe){
        return employeRepository.save(employe);
    }

    public List<Employe> getLesEmployes(Long employeId){
        return employeRepository.findAll();
    }

    public Employe getEmploye(Long employeId){
        return employeRepository.findById(employeId).orElseThrow(()-> new ObjectNotFoundException("employe not found"));
    }

    public Employe updateEmploye(Long employeId, EmployeRequest employeRequest){
        Employe savedEmploye = employeRepository.findById(employeId).orElseThrow(()-> new ObjectNotFoundException("employe not found"));
        savedEmploye.setFirstName(employeRequest.getFirstName());
        savedEmploye.setLastName(employeRequest.getLastName());
        savedEmploye.setEmail(employeRequest.getEmail());
        savedEmploye.setFonction(employeRequest.getFonction());

        return employeRepository.save(savedEmploye);
    }

    public void deleteEmploye(Long employeId){
       employeRepository.deleteById(employeId);
    }

    //my reports
    //my missions

}
