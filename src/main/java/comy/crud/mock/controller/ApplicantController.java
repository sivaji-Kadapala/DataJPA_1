package comy.crud.mock.controller;

import comy.crud.mock.models.Applicant;
import comy.crud.mock.service.ApplcantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    @Autowired
    private ApplcantService applcantService;
    @GetMapping
    public List<Applicant> getApplicants(){
        return applcantService.getAllApplicants();
    }
    @PostMapping
    public Applicant saveApplicant(@RequestBody Applicant applicant){
        return applcantService.saveApplicantCrud(applicant);
    }
    @GetMapping("/page")
    public Iterable<Applicant> getApplicantsWithPagination(
            @RequestParam int page,
            @RequestParam int size
    ){
        return applcantService.getApplicantWithPagination(page,size);
    }
    @GetMapping("/getByStatus")
    public Iterable<Applicant> getByStatus(
            @RequestParam String status
    ){
        return applcantService.getApplicationByStatus(status);
    }
    @GetMapping("/getByName")
    public Iterable<Applicant> getApplicantByPartialName(
            @RequestParam String name
    ){
        return applcantService.getApplicantByPartialName(name);
    }
}
