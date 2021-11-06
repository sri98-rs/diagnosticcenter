package spboot.web.jpa.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spboot.web.jpa.entity.Doctor;
import spboot.web.jpa.entity.Patient;
import spboot.web.jpa.repository.DoctorAppointmentRepository;
import spboot.web.jpa.repository.PatientRepository;

@Service
public class PatientService {
        @Autowired
        PatientRepository patientRepository;
        
//        @Autowired
//        DoctorAppointmentService doctorAppointmentService; 

        @Transactional(readOnly=true)
        public Optional<Patient> getPatientId(int patientId){
                return patientRepository.findById(patientId);
        }
        @Transactional(readOnly=true)
        public List<Patient> getPatients(){
                List<Patient> plist = patientRepository.findAll();
                return plist;

        }

        @Transactional
        public boolean addOrModifyPatient(Patient patient) {
        	Patient pat = patientRepository.save(patient);
                return pat!=null;
        }
        
        @Transactional
        public void removePatient(int patientId) {
    		patientRepository.deleteById(patientId);
    	}
        
        //view doctors list
//        @Transactional
//    	public List<Doctor> getDoctorByDiagnosticCenter(int diagnosticCenterId) {
//    			return patientRepository.findAllDoctorsByDiagnosticCenter(diagnosticCenterId);
//    	}
        
//        @Transactional
//        public boolean updateAppointment(LocalDate doctorAppointmentBookingDate, LocalTime doctorAppointmentBookingTime, LocalDate doctorAppointmentDate, LocalTime doctorAppointmentTime, char doctorAppointmentStatus) {
//        	return doctorAppointmentRepository.updateDoctorAppointment(doctorAppointmentBookingDate, doctorAppointmentBookingTime,doctorAppointmentDate,doctorAppointmentTime,doctorAppointmentStatus);
//        }

}