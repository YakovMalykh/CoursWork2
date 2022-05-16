package com.example.courswork2;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();



    public Set<Question> getQuestions() {
        return questions;
    }

    private void isCorrectString(String anyStryng) {
        if (isBlank(anyStryng) || isEmpty(anyStryng)) {
            throw new IllegalArgumentException("введены недопустимые символы");
        }
    }

    @Override
    public Question add(String question, String answer) {
        isCorrectString(question);
        isCorrectString(answer);
        Question result = new Question(question, answer);
        if (!questions.contains(result)) {
            questions.add(result);
            return result;
        }else {
            throw new IllegalArgumentException("Такой вопрос уже есть в списке");
        }

    }

    @Override
    public Question remove(String question, String answer) {
        isCorrectString(question);
        isCorrectString(answer);
        Question result = new Question(question, answer);
        if (questions.contains(result)) {
            questions.remove(result);
            return result;
        } else {
            throw new IllegalArgumentException("Такого вопроса в списке нет");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return getQuestions();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        List<Question>questionList= questions.stream().
                collect(Collectors.toList());
        return questionList.get(randomIndex);
    }
}
