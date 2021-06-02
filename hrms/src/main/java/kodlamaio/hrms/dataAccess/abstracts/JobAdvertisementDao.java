package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailsDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getByisActiveTrue();
	
	List<JobAdvertisement> getByisActiveTrueOrderByApplicationDeadlineDesc();
	
	List<JobAdvertisement> getByisActiveTrueAndEmployer_Id(int employerId);
	
	JobAdvertisement getById(int id);
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementDetailsDto(e.companyName,t.title,j.quata, c.cityName,j.applicationDeadline,j.createdDate,j.description) " +
			"from JobAdvertisement j inner join j.employer e inner join j.jobTitle t inner join j.city c")
	List<JobAdvertisementDetailsDto> getAdvertisementWithEmployerDetails();
	
}
