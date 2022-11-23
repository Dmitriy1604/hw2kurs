package test.java.org.example.service;


import org.example.exception.NotEnoughQuestionsException;
import org.example.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> javaQuestions = new ArrayList<>();

    @BeforeEach
    public void beforeEach(){
        javaQuestions.clear();

        javaQuestions.addAll(
                Stream.of(
                        new Question("Вопрос по Java - 1","Ответ по Java - 1"),
                        new Question("Вопрос по Java - 1","Ответ по Java - 1"),
                        new Question("Вопрос по Java - 1","Ответ по Java - 1")
                ).collect(Collectors.toSet())
        );
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
    }

    @Test
    public void getQuestionNegativeTest(){
        assertThatExceptionOfType(NotEnoughQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));

    }

    @Test
    public void getQuestionNegativeTest(){
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new Question("Вопрос по Java -1","Ответ по Java -1"),
                new Question("Вопрос по Java - 1","Ответ по Java - 1"),
                new Question("Вопрос по Java - 1","Ответ по Java - 1"),
                new Question("Вопрос по Java - 3","Ответ по Java - 3")

        );

        assertThat(examinerService.getQuestions(2))
                .hasSize(2);
                .containsExactlyInAnyOrder(
                        new Question("Вопрос по Java -1","Ответ по Java -1"),
                        new Question("Вопрос по Java - 3","Ответ по Java - 3")

        );

}

}