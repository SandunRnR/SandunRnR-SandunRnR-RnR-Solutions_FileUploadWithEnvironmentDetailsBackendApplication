package com.example.SpringBootFileUpload.service;

import com.example.SpringBootFileUpload.entity.EnvironmentEntity;
import com.example.SpringBootFileUpload.repository.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EnvironmentServiceImp implements EnvironmentService {

    @Autowired
    private EnvironmentRepository environmentRepository;

    @Value("${upload.image.path}")
    private String uploadImagePath;

    @Override
    public String saveEnvironment(
            double pTemperature,
            double pSoilMoisture,
            double pHumidity,
            double pCustomId,
            double pMachineId,
            double pLatitude,
            double pLongitude,
//            LocalDateTime pUploadDateTime,
            MultipartFile file
    ) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            LocalDateTime currentDateTime = LocalDateTime.now();

            EnvironmentEntity newObjectAIEntity = new EnvironmentEntity(pTemperature,
                    pSoilMoisture,
                    pHumidity,
                    pCustomId,
                    pMachineId,
                    pLatitude,
                    pLongitude,
                    currentDateTime
//                    (currentDateTime.toString() + "_" + fileName)
            );

            try {
                environmentRepository.save(newObjectAIEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }

            File newFile = new File(uploadImagePath
                    + "\\" + (new Date()).getTime() + "_" + fileName);

            // Transfer the content of MultipartFile to the file
            file.transferTo(newFile);

            return "Successfully Inserted!";
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }


}
