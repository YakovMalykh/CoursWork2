package com.example.courswork2;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
//    Question add(Question question);
    Question remove(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
