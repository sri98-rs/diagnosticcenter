package spboot.web.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spboot.web.jpa.entity.Tests;
import spboot.web.jpa.repository.TestsRepository;
@Service
public class TestsService 
{
	@Autowired
	TestsRepository testsRepository;
	
	@Transactional(readOnly=true)
	public Optional<Tests> getTestsId(int testsId){
		return testsRepository.findById(testsId);
	}
	
	@Transactional(readOnly=true)
	public List<Tests> getTests(){
		List<Tests> tlist = testsRepository.findAll();
		return tlist;

	}
	
	@Transactional 
	public boolean addOrModifyTests(Tests tests) {
		Tests tst = testsRepository.save(tests);
		return tst!=null;
	}
	
	@Transactional
	public void removeTests(int testsId) {
		testsRepository.deleteById(testsId);
	}
		

}