package spboot.web.jpa.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="test_appointment")
//@DynamicUpdate
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="testAppointmentId")
public class TestAppointment {
		
	
	@Id
	@Column(name="test_appointment_id")
	int testAppointmentId;
	
	@Column(name="test_appointment_booking_date")
	LocalDate testAppointmentBookingDate;
	
	@Column(name="test_appointment_booking_time")
	LocalTime testAppointmentBookingTime;
	
	@Column(name="test_appointment_test_date")
	LocalDate testAppointmentTestDate;
	
	@Column(name="test_appointment_test_time")
	LocalTime testAppointmentTestTime;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="test_appointment_customer_id")
	Customer customer;
	
	@Column(name="test_appointment_status")
	char testAppointmentStatus;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy ="testAppointment")
	List<TestAppointmentTests> testAppointmentTests;
	
	public TestAppointment() {}
	
	public TestAppointment(int testAppointmentId, LocalDate testAppointmentbookingDate, LocalTime testAppointmentBookingTime,
			LocalDate testAppointmentTestDate, LocalTime testAppointmentTestTime, Customer customer,
			char testAppointmentStatus, List<TestAppointmentTests> testAppointmentTests) {  
		super();
		this.testAppointmentId = testAppointmentId;
		this.testAppointmentBookingDate = testAppointmentbookingDate;
		this.testAppointmentBookingTime = testAppointmentBookingTime;
		this.testAppointmentTestDate = testAppointmentTestDate;
		this.testAppointmentTestTime = testAppointmentTestTime;
		this.customer = customer;
		this.testAppointmentStatus = testAppointmentStatus;
		this.testAppointmentTests = testAppointmentTests;
	}

	public int getTestAppointmentId() {
		return testAppointmentId;
	}

	public void setTestAppointmentId(int testAppointmentId) {
		this.testAppointmentId = testAppointmentId;
	}
	
	public LocalDate getTestAppointmentBookingDate() {
		return testAppointmentBookingDate;
	}

	public void setTestAppointmentBookingDate(LocalDate testAppointmentBookingDate) {
		this.testAppointmentBookingDate = testAppointmentBookingDate;
	}

	public LocalTime getTestAppointmentBookingTime() {
		return testAppointmentBookingTime;
	}

	public void setTestAppointmentBookingTime(LocalTime testAppointmentBookingTime) {
		this.testAppointmentBookingTime = testAppointmentBookingTime;
	}

	public LocalDate getTestAppointmentTestDate() {
		return testAppointmentTestDate;
	}

	public void setTestAppointmentTestDate(LocalDate testAppointmentTestDate) {
		this.testAppointmentTestDate = testAppointmentTestDate;
	}

	public LocalTime getTestAppointmentTestTime() {
		return testAppointmentTestTime;
	}

	public void setTestAppointmentTestTime(LocalTime testAppointmentTestTime) {
		this.testAppointmentTestTime = testAppointmentTestTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public char getTestAppointmentStatus() {
		return testAppointmentStatus;
	}

	public void setTestAppointmentStatus(char testAppointmentStatus) {
		this.testAppointmentStatus = testAppointmentStatus;
	}

	public List<TestAppointmentTests> getTestAppointmentTests() {
		return testAppointmentTests;
	}

	public void setTestAppointmentTests(List<TestAppointmentTests> testAppointmentTests) {
		this.testAppointmentTests = testAppointmentTests;
	}

	@Override
	public String toString() {
		return "TestAppointment [testAppointmentId=" + testAppointmentId + ", testappointmentbookingDate="
				+ testAppointmentBookingDate + ", testappointmentbookingTime=" + testAppointmentBookingTime
				+ ", testappointmenttestDate=" + testAppointmentTestDate + ", testappointmenttestTime="
				+ testAppointmentTestTime + ", customer=" + customer + ", testAppointmentStatus="
				+ testAppointmentStatus + ", testAppointmentTests=" + testAppointmentTests + "]";
	}
}