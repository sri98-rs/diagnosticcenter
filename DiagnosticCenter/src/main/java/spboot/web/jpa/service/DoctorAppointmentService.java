package spboot.web.jpa.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spboot.web.jpa.entity.Doctor;
import spboot.web.jpa.entity.DoctorAppointment;
import spboot.web.jpa.repository.DoctorAppointmentRepository;
@Service
public class DoctorAppointmentService {
	//int count =0;
	@Autowired
	DoctorAppointmentRepository doctorAppointmentRepository;
	
	@Transactional(readOnly=true)
	public  Optional<DoctorAppointment> getDoctorAppointmentServiceId(int doctorAppointmentId){
		return doctorAppointmentRepository.findById(doctorAppointmentId);
	}
	
	@Transactional(readOnly=true)
	public List<DoctorAppointment> getDoctorAppointments(){
		List<DoctorAppointment> dalist = doctorAppointmentRepository.findAll();
		return dalist;

	}
	
	@Transactional 
	public boolean addOrModifyDoctorAppointment(DoctorAppointment doctorAppointment) {
		DoctorAppointment dapp = doctorAppointmentRepository.save(doctorAppointment);
		return dapp!=null;
	}
	
	@Transactional
	public boolean modifyDoctorAppointmentStatus(char status,int doctorAppointmentId) {
		int count = doctorAppointmentRepository.updateDoctorAppointmentStatus(status, doctorAppointmentId);
		return count == 1;
	}
	
	@Transactional
	public void removeDoctorAppointment(int doctorAppointmentId) {
		doctorAppointmentRepository.deleteById(doctorAppointmentId);
	}
	
//	@Transactional(readOnly = true)
//	public  DoctorAppointment getAppointmentsByDoctorIdAndDate(int doctorId, LocalDate appointmentDate){
//		System.out.println("Hii");
//		return doctorAppointmentRepository.findAppointmentsByDoctorIdAndDoctorAppointmentDate(doctorId,appointmentDate);
//	}

}