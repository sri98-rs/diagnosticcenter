package spboot.web.jpa.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spboot.web.jpa.entity.Doctor;
import spboot.web.jpa.entity.DoctorAppointment;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Integer> {
	
	@Modifying
	@Query("update DoctorAppointment d set d.doctorAppointmentStatus = :status where d.doctorAppointmentId = :appId")
	public int updateDoctorAppointmentStatus(@Param("status") char status, @Param("appId") int doctorAppointmentId);
	
//	@Query("select * from DoctorAppointment d where d.doctorAppointmentDoctorId = :doctorId and d.doctorAppointmentDate = :doctorAppointmentDate")
//	DoctorAppointment findAppointmentsByDoctorIdAndDoctorAppointmentDate(@Param("doctorId") int doctorId ,@Param("doctorAppointmentDate") LocalDate doctorAppointmentDate); 

}
