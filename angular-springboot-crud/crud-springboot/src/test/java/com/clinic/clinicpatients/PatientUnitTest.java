package com.clinic.clinicpatients;

import com.clinic.clinicpatients.controller.PatientController;
import com.clinic.clinicpatients.model.Patient;
import com.clinic.clinicpatients.model.ServiceResponse;
import com.clinic.clinicpatients.service.IPatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class PatientUnitTest {

    @Mock
    private IPatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testList() {
        List<Patient> mockList = new ArrayList<>();
        mockList.add(new Patient());
        when(patientService.findAll()).thenReturn(mockList);

        ResponseEntity<List<Patient>> response = patientController.list();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testSave() {
        Patient patient = new Patient();
        when(patientService.save(any(Patient.class))).thenReturn(1);

        ResponseEntity<EntityModel<ServiceResponse>> response = patientController.save(patient);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<ServiceResponse> entity = response.getBody();
        assertNotNull(entity);
        ServiceResponse serviceResponse = entity.getContent();
        assertNotNull(serviceResponse);
        assertTrue(serviceResponse.getSuccess());
        assertEquals("Patient saved successfully", serviceResponse.getMessage());
    }

    @Test
    void testUpdate() {
        Patient patient = new Patient();
        when(patientService.update(any(Patient.class))).thenReturn(1);

        ResponseEntity<EntityModel<ServiceResponse>> response = patientController.update(patient);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<ServiceResponse> entity = response.getBody();
        assertNotNull(entity);
        ServiceResponse serviceResponse = entity.getContent();
        assertNotNull(serviceResponse);
        assertTrue(serviceResponse.getSuccess());
        assertEquals("Patient updated successfully", serviceResponse.getMessage());
    }

    @Test
    void testDelete() {
        when(patientService.deleteById(anyInt())).thenReturn(1);

        ResponseEntity<EntityModel<ServiceResponse>> response = patientController.delete(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<ServiceResponse> entity = response.getBody();
        assertNotNull(entity);
        ServiceResponse serviceResponse = entity.getContent();
        assertNotNull(serviceResponse);
        assertTrue(serviceResponse.getSuccess());
        assertEquals("Patient deleted successfully", serviceResponse.getMessage());
    }
}
