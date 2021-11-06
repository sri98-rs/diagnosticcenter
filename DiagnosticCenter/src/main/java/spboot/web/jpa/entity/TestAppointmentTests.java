package spboot.web.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="test_appointment_tests")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="testAppointmentTestsId")
public class TestAppointmentTests {
	@Id
	@Column(name="test_appointment_tests_id")
	int testAppointmentTestsId;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="test_appointment_tests_test_app_id")
	TestAppointment testAppointment;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="test_appointment_tests_test_id")
	Tests tests;

	public TestAppointmentTests() {
		super();
	}
	
	public TestAppointmentTests(int testAppointmentTestsId, TestAppointment testAppointment, Tests tests) {
		super();
		this.testAppointmentTestsId = testAppointmentTestsId;
		this.testAppointment = testAppointment;
		this.tests = tests;
	}

	public int getTestAppointmentTestsId() {
		return testAppointmentTestsId;
	}

	public void setTestAppointmentTestsId(int testAppointmentTestsId) {
		this.testAppointmentTestsId = testAppointmentTestsId;
	}

	public TestAppointment getTestAppointment() {
		return testAppointment;
	}

	public void setTestAppointment(TestAppointment testAppointment) {
		this.testAppointment = testAppointment;
	}
	
	public Tests getTests() {
		return tests;
	}

	public void setTests(Tests tests) {
		this.tests = tests;
	}

	@Override
	public String toString() {
		return "TestAppointmentTests [testAppointmentTestsId=" + testAppointmentTestsId + ", testAppointment="
				+ testAppointment + ", tests=" + tests + "]";
	}

	
}
