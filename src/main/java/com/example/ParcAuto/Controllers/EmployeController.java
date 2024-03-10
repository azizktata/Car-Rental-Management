package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.Services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employes")
public class EmployeController {
    @Autowired
    private EmployeService employeService;
}
