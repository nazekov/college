package kg.mega.college.controller;

import kg.mega.college.model.dto.ExamDto;
import kg.mega.college.model.dto.ExamDtoUpdate;
import kg.mega.college.service.ExamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/save")
    public String save(@RequestBody ExamDto examDto) {
        return examService.save(examDto);
    }

    @GetMapping("/get/{examId}")
    public String get(@PathVariable Long examId) {
        return examService.get(examId);
    }

    @PutMapping("/update")
    public String update(@RequestBody ExamDtoUpdate examDto) {
        return examService.update(examDto);
    }
}
