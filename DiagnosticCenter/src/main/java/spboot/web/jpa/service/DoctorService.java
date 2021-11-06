package spboot.web.jpa.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spboot.web.jpa.entity.Doctor;
import spboot.web.jpa.entity.DoctorAppointment;
import spboot.web.jpa.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	DoctorAppointmentService doctorAppointmentService;
	
	@Transactional(readOnly=true)
	public Optional<Doctor> getDoctor(int doctorId) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(doctorId);
	}
	
	@Transactional(readOnly=true)
	public List<Doctor> getDoctors(){
	        List<Doctor> doclist = doctorRepository.findAll();
	        return doclist;

	}

	@Transactional
	public boolean addOrModifyDoctor(Doctor doctor) {
		Doctor doc = doctorRepository.save(doctor);
	        return doc!=null;
	}
	
	@Transactional
	public void removeDoctor(int doctorId) {
		doctorRepository.deleteById(doctorId);
	}
	
	@Transactional(readOnly = true)
	public  List<DoctorAppointment> getAppointmentsByDoctorIdAndDate(int doctorId, LocalDate appointmentDate){
		System.out.println("Hii");
		return doctorRepository.findAppointmentsByDoctorIdAndDoctorAppointmentDate(doctorId,appointmentDate);
	}

}