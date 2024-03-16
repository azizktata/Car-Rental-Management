package com.example.ParcAuto.Services;

import com.example.ParcAuto.DTOs.Requests.EmployeRequest;
import com.example.ParcAuto.DTOs.Requests.ReportRequest;
import com.example.ParcAuto.Exceptions.ObjectNotFoundException;
import com.example.ParcAuto.Models.Employe;
import com.example.ParcAuto.Models.Report;
import com.example.ParcAuto.Repository.EmployeRepository;
import com.example.ParcAuto.Repository.ReportRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRespository reportRepository;

    public Report addReport(Report report){
        return reportRepository.save(report);
    }

    public List<Report> getLesReports(Long reportId){
        return reportRepository.findAll();
    }

    public Report getReport(Long reportId){
        return reportRepository.findById(reportId).orElseThrow(()-> new ObjectNotFoundException("report not found"));
    }

    public Report updateReport(Long reportId, ReportRequest request){
        Report savedReport = reportRepository.findById(reportId).orElseThrow(()-> new ObjectNotFoundException("report not found"));
        savedReport.setSubject(request.getSubject());
        savedReport.setDescription(request.getDescription());

        return reportRepository.save(savedReport);
    }

    public void deleteReport(Long reportId){
       reportRepository.deleteById(reportId);
    }
}
