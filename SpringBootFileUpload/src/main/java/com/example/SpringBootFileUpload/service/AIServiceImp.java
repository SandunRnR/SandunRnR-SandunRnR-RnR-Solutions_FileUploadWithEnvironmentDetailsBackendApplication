//package com.example.SpringBootFileUpload.service;
//
//import com.example.SpringBootFileUpload.entity.AIEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//import com.example.SpringBootFileUpload.repository.AIRepository;
//
//import java.io.File;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//
//@Service
//public class AIServiceImp implements AIService {
//
//
//    @Autowired
//    private AIRepository aiRepository;
//
//    @Value("${upload.image.path}")
//    private String uploadImagePath;
//
//    @Override
//    public String uplaod(
//            int pCustomerID,
//            MultipartFile file,
//            String pIdentifiedObject) throws Exception {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        try {
//            if (fileName.contains("..")) {
//                throw new Exception("Filename contains invalid path sequence "
//                        + fileName);
//            }
//
//            LocalDateTime currentDateTime = LocalDateTime.now();
//
//            AIEntity newObjectAIEntity = new AIEntity(pCustomerID,
//                    currentDateTime,
//                    fileName,
//                    (currentDateTime.toString() + "_" + fileName),
//                    pIdentifiedObject);
//
//            try {
//                aiRepository.save(newObjectAIEntity);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            File newFile = new File(uploadImagePath
//                    + "\\" + (new Date()).getTime() + "_" + fileName);
//
//            // Transfer the content of MultipartFile to the file
//            file.transferTo(newFile);
//
//            return "Successfully Inserted!";
//        } catch (Exception e) {
//            throw new Exception("Could not save File: " + fileName);
//        }
//    }
//}
