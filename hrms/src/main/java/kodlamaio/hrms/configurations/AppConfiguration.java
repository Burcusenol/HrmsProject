package kodlamaio.hrms.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.helpers.imageHelpers.CloudinaryManager;
import kodlamaio.hrms.core.utilities.helpers.imageHelpers.ImageUpload;

@Configuration
public class AppConfiguration {

	@Bean
	public Cloudinary cloudinaryService() {
		return new Cloudinary(
				ObjectUtils.asMap(
						"cloud_name","burcusenol",
						"api_key","564338873722638",
						"api_secret","0Sfc-4dEazP2dvaY4rzYlhXyhJ4"));
	
	}
	
	@Bean
	public ImageUpload imageUpload() {
		return new CloudinaryManager(cloudinaryService());
	}
	
}
