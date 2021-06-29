package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailsDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementFilter;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getByisActiveTrue();
	
	List<JobAdvertisement> getByisActiveTrueAndConfirmStatusTrue();
	
	
	List<JobAdvertisement> getByisActiveTrueOrderByApplicationDeadlineDesc();
	
	List<JobAdvertisement> getByisActiveTrueAndEmployer_Id(int employerId);
	
	JobAdvertisement getById(int id);
	
	JobAdvertisement getByIdAndEmployer_Id(int id,int employerId);
	
	List<JobAdvertisement> getByEmployer_Id(int employerid);
	
	List<JobAdvertisement> getByConfirmStatusFalse();
	
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementDetailsDto(e.companyName,t.title,j.quata, c.cityName,j.createdDate,j.applicationDeadline,j.description) " +
			"from JobAdvertisement j inner join j.employer e inner join j.jobTitle t inner join j.city c")
	List<JobAdvertisementDetailsDto> getAdvertisementWithEmployerDetails();
	
	@Modifying
	@Query("update JobAdvertisement set confirmStatus=true where id=:id")
	int updateconfirmStatus(@Param("id")int id);
	
	 @Query("Select j from kodlamaio.hrms.entities.concretes.JobAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
		        +" and ((:#{#filter.jobTitleId}) IS NULL OR j.jobTitle.id IN (:#{#filter.jobTitleId}))"
		        +" and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))"
		        +" and ((:#{#filter.workTimeTypeId}) IS NULL OR j.workTimeType.id IN (:#{#filter.workTimeTypeId}))"
		        +" and j.isActive=true")
		    public Page<JobAdvertisement> getByFilter(@Param("filter") JobAdvertisementFilter jobAdvertisementFilter, Pageable pageable);
	
	@Modifying
	@Query("update JobAdvertisement set isActive=false where id=:id and employer.id=:employerId")
	int updateisActive(@Param("id")int jobAdvertisementId,@Param("employerId") int employerId);
}
