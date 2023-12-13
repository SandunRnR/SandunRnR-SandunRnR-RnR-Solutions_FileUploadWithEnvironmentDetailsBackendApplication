package com.example.SpringBootFileUpload.service;

import com.example.SpringBootFileUpload.entity.Attachment;
import com.example.SpringBootFileUpload.entity.UploadAttachment;
import com.example.SpringBootFileUpload.repository.AttachmentRepository;
import com.example.SpringBootFileUpload.repository.UploadAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public  class AttachmentServiceImpl implements AttachmentService{
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private UploadAttachmentRepository uploadAttachmentRepository;

    @Value("${upload.image.path}")
    private String uploadImagePath;
    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(
            MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            Attachment attachment
                    = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes());

            UploadAttachment uploadAttachment
                    = new UploadAttachment(fileName,
                    file.getContentType());

            File newFile = new File(uploadImagePath
                    + "\\" + (new Date()).getTime() + "_" + fileName);

            try {
                uploadAttachmentRepository.save(uploadAttachment);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Attachment tempAttachment = attachmentRepository.save(attachment);

            // Transfer the content of MultipartFile to the file
            file.transferTo(newFile);

            return tempAttachment;

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepository
                .findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }


}
