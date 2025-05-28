package comy.crud.mock.repository;

import comy.crud.mock.models.Applicant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicantPagingAndSortingRepository extends PagingAndSortingRepository<Applicant,Long> {
}
