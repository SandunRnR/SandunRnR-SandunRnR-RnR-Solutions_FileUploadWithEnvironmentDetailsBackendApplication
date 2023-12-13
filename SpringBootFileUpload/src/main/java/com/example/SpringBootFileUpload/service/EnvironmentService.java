package com.example.SpringBootFileUpload.service;

import org.springframework.web.multipart.MultipartFile;

public interface EnvironmentService {
    public String saveEnvironment(double pTemperature,
                                  double pSoilMoisture,
                                  double pHumidity,
                                  double pCustomId,
                                  double pMachineId,
                                  double pLatitude,
                                  double pLongitude,
//                                  LocalDateTime pUploadDateTime,
                                  MultipartFile pFile) throws Exception;

}
