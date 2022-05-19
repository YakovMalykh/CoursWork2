package com.example.courswork2;

import com.example.courswork2.Question;
import com.example.courswork2.interfaces.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isEmpty;
@Repository
public class MathQuestionRepository implements QuestionRepository {

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
}
