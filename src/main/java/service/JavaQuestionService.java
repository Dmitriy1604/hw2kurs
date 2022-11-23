package service;

import org.example.exception.QuestionAlreadyExistException;
import org.example.exception.QuestionNotFoundException;
import org.example.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random;

    private final Set<Question> questions;
    public JavaQuestionService() {
        this.random = new Random ();
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question ,
                        String answer){
        return add(new Question(question, answer));
    }
    @Override
    public Question add(Question question){
        if(!questions.add(question)){
            try {
                throw new QuestionAlreadyExistException ();
            } catch (QuestionAlreadyExistException e) {
                throw new RuntimeException ( e );
            }
        }
        return question;
    }
    @Override
    public Question remove(Question question){
        if (!questions.remove(question)){
            try {
                throw new QuestionNotFoundException ();
            } catch (QuestionNotFoundException e) {
                throw new RuntimeException ( e );
            }
        }
        return question;
    }
    @Override
    public Collection<Question> getAll(){
        return new ArrayList<>(questions);
    }
    @Override
    public Question getRandomQuestion(){
        if(questions.size()== 0){
            return null;
        }
        return questions.stream().skip(random.nextInt(questions.size()))
                .findAny()
                .orElse(null);

    }
}




