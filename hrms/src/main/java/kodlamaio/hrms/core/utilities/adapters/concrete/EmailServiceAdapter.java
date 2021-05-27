package kodlamaio.hrms.core.utilities.adapters.concrete;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailService;
import kodlamaio.hrms.email.EmailManager;
import kodlamaio.hrms.entities.abstracts.User;

@Service
public class EmailServiceAdapter implements EmailService {

	@Override
	public boolean emailSend(User user) {
		
		return new EmailManager().emailVerification(user.getEmail());
	}

}
