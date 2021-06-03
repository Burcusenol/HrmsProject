package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LinkType;

public interface LinkTypeDao extends JpaRepository<LinkType, Integer> {

}
