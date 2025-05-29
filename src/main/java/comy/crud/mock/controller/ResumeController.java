package comy.crud.mock.controller;

import comy.crud.mock.models.Resume;
import comy.crud.mock.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResumeController {
    @Autowired
    ResumeService resumeService;
    @PostMapping("/{applicantId}/resume")
    public ResponseEntity<Resume> addResume(@PathVariable Long applicantId, @RequestBody Resume resume){
        return ResponseEntity.ok(resumeService.addResume(applicantId,resume));
    }
}
