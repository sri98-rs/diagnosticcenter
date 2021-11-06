package spboot.web.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="doctor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="doctorId")
public class Doctor {
 
	 @Id
	 @Column(name="doctor_id")
	int doctorId;
	
	 @Column(name="doctor_name")
	String doctorName;
	
	 @Column(name="doctor_specialization")
	String doctorSpecialization;
	
	 @Column(name="doctor_contact_number")
	long doctorContactNumber;
	 
	 @ManyToOne(cascade = CascadeType.REMOVE)
	 @JoinColumn(name="doctor_diagnostic_center_id")
	 DiagnosticCenter diagnosticCenter;
	 
	 @OneToMany(cascade = CascadeType.REMOVE,mappedBy="doctor")
	 List<DoctorAppointment> doctorAppointment;
 
	public Doctor() {}
	
	public Doctor(int doctorId, String doctorName, String doctorSpecialization, long doctorContactNumber,DiagnosticCenter diagnosticCenter, List<DoctorAppointment> doctorAppointment) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorContactNumber = doctorContactNumber;
		this.diagnosticCenter = diagnosticCenter;
		this.doctorAppointment = doctorAppointment;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}
	
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	
	public long getDoctorContactNumber() {
		return doctorContactNumber;
	}
	
	public void setDoctorContactNumber(long doctorContactNumber) {
		this.doctorContactNumber = doctorContactNumber;
	}
	
	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}
	
	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}
	
	public List<DoctorAppointment> getDoctorAppointment() {
		return doctorAppointment;
	}
	
	public void setDoctorAppointment(List<DoctorAppointment> doctorAppointment) {
		this.doctorAppointment = doctorAppointment;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorSpecialization="
		+ doctorSpecialization + ", doctorContactNumber=" + doctorContactNumber + ", diagnosticCenter="
		+ diagnosticCenter + ", doctorAppointment=" + doctorAppointment + "]";
	}
	
}