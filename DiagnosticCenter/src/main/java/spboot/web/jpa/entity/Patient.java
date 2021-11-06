package spboot.web.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalTime;
import java.time.LocalDate;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="patient")
//@DynamicUpdate
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="patientId")
public class Patient 
 {
	  @Id
	  @Column(name="patient_id")
	  int patientId;
	 
	 @Column(name="patient_name")
	  String patientName;
	 
	 @Column(name="patient_gender")
	  char patientGender;
	 
	 @Column(name="patient_phone_number")
	  long patientPhoneNumber;
	 
	 @Column(name="patient_address")
	  String patientAddress;
	 
	 @Column(name="patient_age")
	 int patientAge;
	 
	 @OneToOne(mappedBy="patient",cascade = CascadeType.REMOVE)
	// @JoinColumn(name="patient_doctor_appointment_id")
	  DoctorAppointment doctorAppointment;
	 
	 public Patient() {}
	 
	 public Patient(int patientId, String patientName, char patientGender, long patientPhoneNumber,
				String patientAddress, int patientAge, DoctorAppointment doctorAppointment) {
			
			this.patientId = patientId;
			this.patientName = patientName;
			this.patientGender = patientGender;
			this.patientPhoneNumber = patientPhoneNumber;
			this.patientAddress = patientAddress;
			this.patientAge = patientAge;
			this.doctorAppointment = doctorAppointment;
			
		}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public char getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(char patientGender) {
		this.patientGender = patientGender;
	}

	public long getPatientPhoneNumber() {
		return patientPhoneNumber;
	}

	public void setPatientPhonenumber(long patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public DoctorAppointment getDoctorAppointment() {
		return doctorAppointment;
	}

	public void setDoctorAppointment(DoctorAppointment doctorAppointment) {
		this.doctorAppointment = doctorAppointment;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientGender=" + patientGender
				+ ", patientPhoneNumber=" + patientPhoneNumber + ", patientAddress=" + patientAddress + ", patientAge="
				+ patientAge + ", doctorAppointment=" + doctorAppointment + "]";
	}
 }