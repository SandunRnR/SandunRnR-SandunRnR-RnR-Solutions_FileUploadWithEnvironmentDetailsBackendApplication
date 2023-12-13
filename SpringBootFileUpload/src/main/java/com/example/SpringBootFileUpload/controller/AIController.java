//package com.example.SpringBootFileUpload.controller;
//
//import com.example.SpringBootFileUpload.service.AIService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//public class AIController {
//
//    @Autowired
//    private AIService aiService;
//
//    @PostMapping("/aiupload")
//    public String uploadFile(
//            @RequestParam("CustomerID") int pCustomerID,
//            @RequestParam("file") MultipartFile pFile,
//            @RequestParam("IdentifiedObject") String pIdentifiedObject) throws Exception {
//
//        return aiService.uplaod(pCustomerID, pFile, pIdentifiedObject);
//    }
//
//}
