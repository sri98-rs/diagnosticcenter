package spboot.web.jpa.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spboot.web.jpa.entity.Doctor;
import spboot.web.jpa.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
//	List<Doctor> findAllDoctorsByDiagnosticCenter(int diagnosticCenterId);
	
}
