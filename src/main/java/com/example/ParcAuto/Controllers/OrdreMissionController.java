package com.example.ParcAuto.Controllers;

import com.example.ParcAuto.Services.OrdreMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/missions")
public class OrdreMissionController {
    @Autowired
    private OrdreMissionService ordreMissionService;
}
