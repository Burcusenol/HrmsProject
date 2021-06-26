package kodlamaio.hrms.dataAccess.abstracts;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	
	Optional<Candidate>findByIdentityNumber(String identityNumber);
	Candidate getById(int id);

	
}
