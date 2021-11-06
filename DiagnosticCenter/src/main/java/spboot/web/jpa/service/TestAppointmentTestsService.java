package spboot.web.jpa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spboot.web.jpa.entity.TestAppointmentTests;
import spboot.web.jpa.repository.TestAppointmentTestsRepository;
@Service
public class TestAppointmentTestsService
{
        @Autowired
        TestAppointmentTestsRepository testAppointmentTestsRepository;

        @Transactional(readOnly=true)
        public Optional<TestAppointmentTests> getTestAppointmentTest(int testAppointmentTestsId){
                return testAppointmentTestsRepository.findById(testAppointmentTestsId);
}
        @Transactional(readOnly=true)
        public List<TestAppointmentTests> getTestAppointmentTests(){
                List<TestAppointmentTests> testapptestlist = testAppointmentTestsRepository.findAll();
                return testapptestlist;

        }

        @Transactional
        public boolean addOrModifyTestAppointmentTests(TestAppointmentTests testAppointmentTests) {
        	TestAppointmentTests testapptest = testAppointmentTestsRepository.save(testAppointmentTests);
                return testapptest!=null;
        }
        
        @Transactional
    	public void removeTestAppointmentTests(int testAppointmentTestsId) {
    		testAppointmentTestsRepository.deleteById(testAppointmentTestsId);
    	}

}