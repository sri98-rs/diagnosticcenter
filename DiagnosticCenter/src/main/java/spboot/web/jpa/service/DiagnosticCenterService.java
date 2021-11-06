package spboot.web.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spboot.web.jpa.entity.DiagnosticCenter;
import spboot.web.jpa.repository.DiagnosticCenterRepository;
@Service
public class DiagnosticCenterService {
	@Autowired
	DiagnosticCenterRepository diagnosticCenterRepository;
	
	@Transactional(readOnly=true)
	public Optional<DiagnosticCenter> getDiagnosticCenterId(int diagnosticCenterId){
		return diagnosticCenterRepository.findById(diagnosticCenterId);
	}
	
	@Transactional(readOnly=true)
	public List<DiagnosticCenter> getDiagnosticCenters(){
		List<DiagnosticCenter> dclist = diagnosticCenterRepository.findAll();
		return dclist;

	}
	
	@Transactional 
	public boolean addOrModifyDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		DiagnosticCenter dcent = diagnosticCenterRepository.save(diagnosticCenter);
		return dcent!=null;
	}
	
	@Transactional
	public void removeDiagnosticCenter(int diagnosticCenterId) {
		diagnosticCenterRepository.deleteById(diagnosticCenterId);
	}

}