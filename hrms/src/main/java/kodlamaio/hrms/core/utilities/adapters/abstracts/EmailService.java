package kodlamaio.hrms.core.utilities.adapters.abstracts;

import kodlamaio.hrms.entities.abstracts.User;

public interface EmailService {

	public boolean emailSend(User user);
}
