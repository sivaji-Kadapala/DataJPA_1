package comy.crud.mock.repository;

import comy.crud.mock.models.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantJpaRepository extends JpaRepository<Applicant,Long> {
    List<Applicant> findByStatus(String status);
    @Query("SELECT a FROM Applicant a WHERE a.name LIKE CONCAT('%', :name, '%')")
    List<Applicant> findApplicantsByPartialName(@Param("name") String name);
}
