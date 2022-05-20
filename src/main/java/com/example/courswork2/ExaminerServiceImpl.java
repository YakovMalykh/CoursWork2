package com.example.courswork2;

import com.example.courswork2.exceptions.QuestionBadRequestException;
import com.example.courswork2.interfaces.ExaminerService;
import com.example.courswork2.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    QuestionService javaQuestionService;
    QuestionService mathQuestionService;

    public ExaminerServiceImpl(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int lenght = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (amount <= lenght) {

            Set<Question> listOfRandomQuestions = new HashSet<>();

            Set<Question> collectionOfAllQuestions = new HashSet<>();
            collectionOfAllQuestions.addAll(javaQuestionService.getAll());
            collectionOfAllQuestions.addAll(mathQuestionService.getAll());

            while (listOfRandomQuestions.size() < amount) {
                listOfRandomQuestions.add(getRandomQuestion(collectionOfAllQuestions));
            }
            return listOfRandomQuestions;
        } else {
            throw new QuestionBadRequestException("запрошено большее количество вопросов, " +
                    "чем есть в списке");
        }
    }

    private Question getRandomQuestion(Collection<Question> collection) {
        Random random = new Random();
        int randomIndex = random.nextInt(collection.size());
        List<Question> questionList= collection.stream().
                collect(Collectors.toList());
        return questionList.get(randomIndex);
    }

}
