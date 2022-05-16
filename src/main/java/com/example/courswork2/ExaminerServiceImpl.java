package com.example.courswork2;

import com.example.courswork2.exceptions.QuestionBadRequestException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= questionService.getAll().size()) {
            Set<Question> listOfRandomQuestions = new HashSet<>();
            while (listOfRandomQuestions.size() < amount) {
                listOfRandomQuestions.add(questionService.getRandomQuestion());
            }
            return listOfRandomQuestions;
        } else {
            throw new QuestionBadRequestException("запрошено большее количество вопросов, " +
                    "чем есть в списке");
        }
    }
}
