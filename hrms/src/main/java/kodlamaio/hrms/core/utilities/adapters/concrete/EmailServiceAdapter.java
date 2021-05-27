package kodlamaio.hrms.core.utilities.adapters.concrete;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailService;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.serviceemail.EmailManager;

@Service
public class EmailServiceAdapter implements EmailService {

	@Override
	public boolean emailSend(User user) {
		
		return new EmailManager().emailVerification(user.getEmail());
	}

}
