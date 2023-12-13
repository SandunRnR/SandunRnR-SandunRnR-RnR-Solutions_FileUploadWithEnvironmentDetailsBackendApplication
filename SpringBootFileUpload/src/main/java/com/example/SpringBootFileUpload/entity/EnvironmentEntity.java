package com.example.SpringBootFileUpload.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "EnvironmentTable")
public class EnvironmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private double temperature;
    private double soilMoisture;
    private double humidity;
    private double customId;
    private double machineId;
    private double latitude;
    private double longitude;
    private LocalDateTime uploadDateAndTime;


    public EnvironmentEntity(
            double pTemperature,
            double pSoilMoisture,
            double pHumidity,
            double pCustomId,
            double pMachineId,
            double pLatitude,
            double pLongitude,
            LocalDateTime pUploadDateTime) {
        this.temperature = pTemperature;
        this.soilMoisture = pSoilMoisture;
        this.humidity = pHumidity;
        this.customId = pCustomId;
        this.machineId = pMachineId;
        this.latitude = pLatitude;
        this.longitude = pLongitude;
        this.uploadDateAndTime = pUploadDateTime;

    }

}
