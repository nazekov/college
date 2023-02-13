package kg.mega.college.controller;

import kg.mega.college.model.Subject;
import kg.mega.college.model.dto.SubjectDto;
import kg.mega.college.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/save")
    public String save(@RequestBody SubjectDto subjectDto) {
        return subjectService.save(subjectDto);
    }

//    @PostMapping("/save-list")
//    public List<Subject> save(@RequestBody List<SubjectDto> subjectDtoList) {
//        return subjectService.saveAll(subjectDtoList);
//    }

    @GetMapping("/get-all")
    public List<Subject> getAll() {
        return subjectService.findAll();
    }

    @GetMapping("/get/{subjectName}")
    public String getSubject(@PathVariable String subjectName) {
        return subjectService.findByName(subjectName);
    }

    @PutMapping("/update")
    public String updateSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.update(subjectDto);
    }

//    @DeleteMapping("/remove/{subjectName}")
//    public String removeSubject(@PathVariable String subjectName) {
//        return subjectService.removeByName(subjectName);
//    }
}
