package controller;

import org.example.model.Question;
import org.example.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService=examinerService;

    }
    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestion(@RequestParam("amount") int amount){
        return examinerService.getQuestions(amount);

    }
}
