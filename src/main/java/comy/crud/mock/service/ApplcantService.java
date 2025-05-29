package comy.crud.mock.service;

import comy.crud.mock.models.Applicant;
import comy.crud.mock.models.Resume;
import comy.crud.mock.repository.ApplicantCrudRepository;
import comy.crud.mock.repository.ApplicantJpaRepository;
import comy.crud.mock.repository.ApplicantPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplcantService {
    @Autowired
    private ApplicantCrudRepository applicantCrudRepository;
    @Autowired
    private ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository;
    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;
    public List<Applicant> getAllApplicants(){
        Iterable<Applicant> all = applicantCrudRepository.findAll();
       List<Applicant> applicants=new ArrayList<>();
        all.forEach(applicants::add);
        return applicants;
    }
    public List<Applicant> getApplicationByStatus(String status){
        return applicantJpaRepository.findByStatus(status);
    }
    public Applicant saveApplicantCrud(Applicant applicant){
        Resume re=applicant.getResume();
        if (re != null) {
re.setApplicant(applicant);
        }
        return  applicantCrudRepository.save(applicant);
    }
    public Iterable<Applicant> getApplicantWithPagination(int page,int size){
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(page,size));
    }
    public List<Applicant> getApplicantByPartialName(String name){
       return applicantJpaRepository.findApplicantsByPartialName(name);
    }
}
