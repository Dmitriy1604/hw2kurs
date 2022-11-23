package service;

import org.example.exception.NotEnoughQuestionsException;
import org.example.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    public ExaminerServiceImpl(JavaQuestionService questionService){
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount){
        Collection<Question> questions = questionService.getAll();
        if(amount > questions.size() || amount < 1){
            try {
                throw new NotEnoughQuestionsException ();
            } catch (NotEnoughQuestionsException e) {
                throw new RuntimeException ( e );
            }

        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount){
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
