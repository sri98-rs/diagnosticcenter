package spboot.web.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spboot.web.jpa.entity.Doctor;
import spboot.web.jpa.entity.DoctorAppointment;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

//	@Query("select d.doctorAppointment from Doctor d where d.doctorId = :doctorId and d.doctorAppointment.doctorAppointmentDate in (:doctorAppointmentDate)")
	@Query(value="select dp.doctor_appointment_doctor_id from doctor d inner join doctor_appointment dp on d.doctor_id = dp.doctor_appointment_doctor_id where d.doctor_id = :doctorId and dp.doctor_appointment_date = :doctorAppointmentDate",nativeQuery=true)
	List<DoctorAppointment> findAppointmentsByDoctorIdAndDoctorAppointmentDate(@Param("doctorId") int doctorId ,@Param("doctorAppointmentDate") LocalDate doctorAppointmentDate);
	
}
