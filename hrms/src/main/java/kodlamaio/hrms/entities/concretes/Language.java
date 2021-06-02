package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="languages" )
public class Language {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "language_name")
	@NotBlank(message = "language name cannot be empty!")
	private String languageName;
	
	@Column(name = "language_level")
	@Min(1)
	@Max(5)
	private int languageLevel;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate=LocalDateTime.now();

	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
}
