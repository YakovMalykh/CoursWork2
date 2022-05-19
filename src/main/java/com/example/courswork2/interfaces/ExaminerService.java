package com.example.courswork2.interfaces;

import com.example.courswork2.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions (int amount);
}
