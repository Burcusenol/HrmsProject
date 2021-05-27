package kodlamaio.hrms.core.utilities.adapters.concrete;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernis.MernisManager;

@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean userValidate(Candidate candidate) {
		return new MernisManager().userValidate(candidate.getFirstName(), candidate.getLastName(),
				Long.parseLong(candidate.getIdentityNumber()));

	}
}
