package com.example.courswork2;

import com.example.courswork2.interfaces.QuestionRepository;
import com.example.courswork2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    public MathQuestionService(
            @Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question add(String question, String answer) {
       return questionRepository.add(question,answer);
    }

    @Override
    public Question remove(String question, String answer) {
        return questionRepository.remove(question,answer);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override//понимаю, что этот метод уже без надобности, но пока не стал убирать
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomIndex = random.nextInt(getAll().size());
        List<Question> questionList= getAll().stream().
                collect(Collectors.toList());
        return questionList.get(randomIndex);
    }
}
