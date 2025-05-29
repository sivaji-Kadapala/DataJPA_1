package comy.crud.mock.service;

import comy.crud.mock.models.Applicant;
import comy.crud.mock.models.Resume;
import comy.crud.mock.repository.ApplicantJpaRepository;
import comy.crud.mock.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {
    @Autowired
    ApplicantJpaRepository applicantJpaRepository;
    @Autowired
    ResumeRepository resumeRepository;
    public Resume addResume(Long applicationId,Resume resume){
        Optional<Applicant> applicantOptional = applicantJpaRepository.findById(applicationId);
        if (applicantOptional.isPresent()) {
            Applicant applicant=applicantOptional.get();
            resume.setApplicant(applicant);
            return resumeRepository.save(resume);
        }else{
            throw  new RuntimeException("Applicant not found witn id:"+applicationId);
        }
    }
}
