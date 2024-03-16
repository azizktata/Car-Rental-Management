package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.Services.EmployeService;
import com.example.ParcAuto.Services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;
}
