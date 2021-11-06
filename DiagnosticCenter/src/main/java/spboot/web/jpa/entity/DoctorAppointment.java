package spboot.web.jpa.entity;

import java.time.LocalTime;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="doctor_appointment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="doctorAppointmentId")
public class DoctorAppointment { 
 
	@Id
	@Column(name="doctor_appointment_id")
	int doctorAppointmentId;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="doctor_appointment_doctor_id")
	Doctor doctor;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="doctor_appointment_patient_id")
	Patient patient;
	
	@Column(name="doctor_appointment_booking_date")
	LocalDate doctorAppointmentBookingDate;
	
	@Column(name="doctor_appointment_booking_time")
	LocalTime doctorAppointmentBookingTime;
	
	@Column(name="doctor_appointment_date")
	LocalDate doctorAppointmentDate;
	
	@Column(name="doctor_appointment_time")
	LocalTime doctorAppointmentTime;
	
	@Column(name="doctor_appointment_status")
	char doctorAppointmentStatus;
	
	public DoctorAppointment() {}
	
	public DoctorAppointment(int doctorAppointmentId, Doctor doctor, Patient patient,
		LocalDate doctorAppointmentBookingDate, LocalTime doctorAppointmentBookingTime,
		LocalDate doctorAppointmentDate, LocalTime doctorAppointmentTime, char doctorAppointmentStatus) {
			super();
			this.doctorAppointmentId = doctorAppointmentId;
			this.doctor = doctor;
			this.patient = patient;
			this.doctorAppointmentBookingDate = doctorAppointmentBookingDate;
			this.doctorAppointmentBookingTime = doctorAppointmentBookingTime;
			this.doctorAppointmentDate = doctorAppointmentDate;
			this.doctorAppointmentTime = doctorAppointmentTime;
			this.doctorAppointmentStatus = doctorAppointmentStatus;
	}
	
	public int getDoctorAppointmentId() {
		return doctorAppointmentId;
	}
	
	public void setDoctorAppointmentId(int doctorAppointmentId) {
		this.doctorAppointmentId = doctorAppointmentId;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public LocalDate getDoctorAppointmentBookingDate() {
		return doctorAppointmentBookingDate;
	}
	
	public void setDoctorAppointmentBookingDate(LocalDate doctorAppointmentBookingDate) {
		this.doctorAppointmentBookingDate = doctorAppointmentBookingDate;
	}
	
	public LocalTime getDoctorAppointmentBookingTime() {
		return doctorAppointmentBookingTime;
	}
	
	public void setDoctorAppointmentBookingTime(LocalTime doctorAppointmentBookingTime) {
		this.doctorAppointmentBookingTime = doctorAppointmentBookingTime;
	}
	
	public LocalDate getDoctorAppointmentDate() {
		return doctorAppointmentDate;
	}
	
	public void setDoctorAppointmentDate(LocalDate doctorAppointmentDate) {
		this.doctorAppointmentDate = doctorAppointmentDate;
	}
	
	public LocalTime getDoctorAppointmentTime() {
		return doctorAppointmentTime;
	}
	
	public void setDoctorAppointmentTime(LocalTime doctorAppointmentTime) {
		this.doctorAppointmentTime = doctorAppointmentTime;
	}
	
	public char getDoctorAppointmentStatus() {
		return doctorAppointmentStatus;
	}
	
	public void setDoctorAppointmentStatus(char doctorAppointmentStatus) {
		this.doctorAppointmentStatus = doctorAppointmentStatus;
	}
	
	@Override
	public String toString() {
		return "DoctorAppointment [doctorAppointmentId=" + doctorAppointmentId + ", doctor=" + doctor + ", patient="
		+ patient + ", doctorAppointmentBookingDate=" + doctorAppointmentBookingDate
		+ ", doctorAppointmentBookingTime=" + doctorAppointmentBookingTime + ", doctorAppointmentDate="
		+ doctorAppointmentDate + ", doctorAppointmentTime=" + doctorAppointmentTime
		+ ", doctorAppointmentStatus=" + doctorAppointmentStatus + "]";
	}
}