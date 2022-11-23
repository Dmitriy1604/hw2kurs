package controller;


import org.example.model.Question;
import org.example.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping ("/java")
public class JavaQuestionController {

    private final JavaQuestionService questionService;


    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

        @GetMapping("/add")
        public Question addQuestion (@RequestParam String question ,
                @RequestParam String answer){
            return questionService.add ( question , answer );
        }
        @GetMapping
        public Collection<Question> getQuestions() {
            return questionService.getAll ();
        }

        @GetMapping("/remove")
        public Question removeQuestion (@RequestParam String question ,
                @RequestParam String answer){
            return questionService.remove ( new Question ( question , answer ) );

        }
    }




