package com.example.courswork2.interfaces;

import com.example.courswork2.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);
    Question remove(String question, String answer);
    Collection<Question> getAll();
}
