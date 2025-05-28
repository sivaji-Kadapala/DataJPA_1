package comy.crud.mock.repository;

import comy.crud.mock.models.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantCrudRepository extends CrudRepository<Applicant,Long> {
}
