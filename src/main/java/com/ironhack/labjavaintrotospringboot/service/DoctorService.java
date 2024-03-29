package com.ironhack.labjavaintrotospringboot.service;

import com.ironhack.labjavaintrotospringboot.model.user.Doctor;
import com.ironhack.labjavaintrotospringboot.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() { return doctorRepository.findAll(); }
    public Doctor addNewDoctor(Doctor doctor) { return doctorRepository.save(doctor); }

    public void update(int id, Doctor doctor) {
        Optional<Doctor> $doctor = doctorRepository.findById(id);
        doctor.setDoctorId($doctor.get().getDoctorId());
        doctor.setName($doctor.get().getName());
        doctor.setDepartment($doctor.get().getDepartment());
        doctor.setPatients($doctor.get().getPatients());
        doctorRepository.save(doctor);
    }
}
