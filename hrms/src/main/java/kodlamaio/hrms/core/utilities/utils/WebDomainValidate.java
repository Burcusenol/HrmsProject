package kodlamaio.hrms.core.utilities.utils;

import kodlamaio.hrms.entities.concretes.Employer;

public class WebDomainValidate {

	 public static boolean isEmailDomainCheck(Employer employer){
	        String email = employer.getEmail();
	        String webAddress = employer.getWebAddress();

	        String domain = webAddress.split("www.")[1];
	        if(domain.equals(email.split("@")[1])){
	            return true;
	        }
	        System.out.println("Domain must be same");
	        return false;
	    }
}
