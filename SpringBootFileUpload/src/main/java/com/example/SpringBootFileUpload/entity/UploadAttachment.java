package com.example.SpringBootFileUpload.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="upload_attachment")
public class UploadAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    private String filePath;


//    @Lob
//    private byte[] imageData;

    public UploadAttachment(
            String pFileName,
            String pFileType,
            String pFilePath) {
        this.fileName = pFileName;
        this.fileType = pFileType;
        this.filePath=pFilePath;
    }

    public UploadAttachment(String fileName, String contentType) {
        this.fileName=fileName;
        this.fileType=contentType;
    }


}
