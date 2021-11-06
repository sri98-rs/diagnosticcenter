package spboot.web.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spboot.web.jpa.entity.TestAppointment;
import spboot.web.jpa.repository.TestAppointmentRepository;

@Service
public class TestAppointmentService {
	
	@Autowired
	TestAppointmentRepository testAppointmentRepository;
    
	@Transactional(readOnly=true)
	public Optional<TestAppointment> getTestAppointment(int testAppointmentId) {
		// TODO Auto-generated method stub
		return testAppointmentRepository.findById(testAppointmentId);
	}
    
	@Transactional(readOnly=true)
    public List<TestAppointment> getTestAppointments(){
            List<TestAppointment> testapplist = testAppointmentRepository.findAll();
            return testapplist;

    }

    @Transactional
    public boolean addOrModifyTestAppointment(TestAppointment testAppointment) {
    	TestAppointment testapp = testAppointmentRepository.save(testAppointment);
            return testapp!=null;
    }
    
    @Transactional
	public void removeTestAppointment(int employeeId) {
		testAppointmentRepository.deleteById(employeeId);
	}
}