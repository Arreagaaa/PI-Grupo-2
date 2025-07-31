package com.clinic.clinicpatients.model;

import lombok.Data;

@Data // Lombok will generate getters, setters, toString, equals, and hashCode methods
public class Patient {
    private int patientID;
    private String name;
    private String lastname;
    private String identificationNumber;
    private String documentType;
    private String birthDate;
    private String gender;
    private String address;
    private String department;
    private String municipality;
    private String phoneNumber;
    private String email;
    private String patientType;
}
