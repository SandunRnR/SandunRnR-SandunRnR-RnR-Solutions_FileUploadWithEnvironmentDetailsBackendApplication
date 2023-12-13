package com.example.SpringBootFileUpload.controller;

import com.example.SpringBootFileUpload.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/environment")
public class EnvironmentController {
    @Autowired
    private EnvironmentService environmentService;

    @PostMapping("/save")
    public String saveEnvironment(
    @RequestParam("temperature") double pTemperature,
    @RequestParam("soilMoisture") double pSoilMoisture,
    @RequestParam("humidity") double pHumidity,
    @RequestParam("customId") double pCustomId,
    @RequestParam("machineId") double pMachineId,
    @RequestParam("latitude") double pLatitude,
    @RequestParam("longitude") double pLongitude,
//    @RequestParam("uploadDateAndTime") LocalDateTime pUploadDateTime,
    @RequestParam("file") MultipartFile pFile) throws Exception {

        return environmentService.saveEnvironment(pTemperature,
                pSoilMoisture,
                pHumidity,
                pCustomId,
                pMachineId,
                pLatitude,
                pLongitude,
//                pUploadDateTime,
                pFile);
    }
}
