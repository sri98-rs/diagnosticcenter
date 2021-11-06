package spboot.web.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spboot.web.jpa.entity.TestAppointment;

public interface TestAppointmentRepository extends JpaRepository<TestAppointment, Integer> {

}
