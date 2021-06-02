package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDetailsDto {

	private String companyName;
	private String jobtitle;
	private int quata;
	private String city;
	private LocalDateTime createdDate;
	private LocalDateTime applicationDeadline;
	private String description;
}
