package spboot.web.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="diagnostic_center")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="diagnosticCenterId")
public class DiagnosticCenter {
	
	  @Id
	  @Column(name="diagnostic_center_id")
	  int diagnosticCenterId;
	  
	  @Column(name="diagnostic_center_name")
	  String diagnosticCenterName;
	  
	  @Column(name="diagnostic_center_contact_number")
	  long diagnosticCenterContactNumber;
	  
	  @Column(name="diagnostic_center_address")
	  String diagnosticCenterAddress;
	  
	  @Column(name="diagnostic_center_email")
	  String diagnosticCenterEmail;
	  
	  @OneToMany(cascade = CascadeType.REMOVE,mappedBy="diagnosticCenter")
	  List<Doctor> doctor;
	  
	  public DiagnosticCenter() {}
	  
	  

	public DiagnosticCenter(int diagnosticCenterId, String diagnosticCenterName, long diagnosticCenterContactNumber,
			String diagnosticCenterAddress, String diagnosticCenterEmail, List<Doctor> doctor) {
		super();
		this.diagnosticCenterId = diagnosticCenterId;
		this.diagnosticCenterName = diagnosticCenterName;
		this.diagnosticCenterContactNumber = diagnosticCenterContactNumber;
		this.diagnosticCenterAddress = diagnosticCenterAddress;
		this.diagnosticCenterEmail = diagnosticCenterEmail;
		this.doctor = doctor;
	}



	public int getDiagnosticCenterId() {
		return diagnosticCenterId;
	}

	public void setDiagnosticCenterId(int diagnosticCenterId) {
		this.diagnosticCenterId = diagnosticCenterId;
	}

	public String getDiagnosticCenterName() {
		return diagnosticCenterName;
	}

	public void setDiagnosticCenterName(String diagnosticCenterName) {
		this.diagnosticCenterName = diagnosticCenterName;
	}

	public long getDiagnosticCenterContactNumber() {
		return diagnosticCenterContactNumber;
	}

	public void setDiagnosticCenterContactNumber(long diagnosticCenterContactNumber) {
		this.diagnosticCenterContactNumber = diagnosticCenterContactNumber;
	}

	public String getDiagnosticCenterAddress() {
		return diagnosticCenterAddress;
	}

	public void setDiagnosticCenterAddress(String diagnosticCenterAddress) {
		this.diagnosticCenterAddress = diagnosticCenterAddress;
	}

	public String getDiagnosticCenterEmail() {
		return diagnosticCenterEmail;
	}

	public void setDiagnosticCenterEmail(String diagnosticCenterEmail) {
		this.diagnosticCenterEmail = diagnosticCenterEmail;
	}
	
	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [diagnosticCenterId=" + diagnosticCenterId + ", diagnosticCenterName="
				+ diagnosticCenterName + ", diagnosticCenterContactNumber=" + diagnosticCenterContactNumber
				+ ", diagnosticCenterAddress=" + diagnosticCenterAddress + ", diagnosticCenterEmail="
				+ diagnosticCenterEmail + "]";
	}
}