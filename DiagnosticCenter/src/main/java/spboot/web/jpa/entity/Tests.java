package spboot.web.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tests")
//@DynamicUpdate
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="testsId")
public class Tests{
	
	@Id
	@Column(name="tests_id")
	int testsId;

	@Column(name="tests_name")
	String testsName;

	@Column(name="tests_price")
	int testsPrice;

	@Column(name="tests_description")
	String testsDescription;
	
//	@ManyToOne
//	@JoinColumn(name="tests_test_appointment_id")
//	TestAppointment testAppointment;
	
//	@ManyToOne
//	TestAppointment testAppointment;
	
	@OneToOne(cascade = CascadeType.REMOVE,mappedBy="tests")
	TestAppointmentTests testAppointmentTests;
	
	public int getTestsId() {
		return testsId;
	}

	public void setTestsId(int testsId) {
		this.testsId = testsId;
	}

	public String getTestsName() {
		return testsName;
	}

	public void setTestsName(String testsName) {
		this.testsName = testsName;
	}

	public int getTestsPrice() {
		return testsPrice;
	}

	public void setTestsPrice(int testsPrice) {
		this.testsPrice = testsPrice;
	}

	public String getTestsDescription() {
		return testsDescription;
	}

	public void setTestsDescription(String testsDescription) {
		this.testsDescription = testsDescription;
	}

//	public TestAppointment getTestAppointment() {
//		return testAppointment;
//	}
//
//	public void setTestAppointment(TestAppointment testAppointment) {
//		this.testAppointment = testAppointment;
//	}


	public TestAppointmentTests getTestAppointmentTests() {
		return testAppointmentTests;
	}

	public void setTestAppointmentTests(TestAppointmentTests testAppointmentTests) {
		this.testAppointmentTests = testAppointmentTests;
	}

	public Tests(int testsId, String testsName, int testsPrice, String testsDescription, 
		TestAppointmentTests testAppointmentTests) { //TestAppointment testAppointment,
		super();
		this.testsId = testsId;
		this.testsName = testsName;
		this.testsPrice = testsPrice;
		this.testsDescription = testsDescription;
		//this.testAppointment = testAppointment;
		this.testAppointmentTests = testAppointmentTests;
	}

	public Tests() {
		super();
	}

	@Override
	public String toString() {
		return "Tests [testsId=" + testsId + ", testsName=" + testsName + ", testsPrice=" + testsPrice
				+ ", testsDescription=" + testsDescription + ", testAppointmentTests=" + testAppointmentTests + "]";
	}
	
	

}