package com.example.courswork2;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = capitalize(question.toLowerCase());
        this.answer = capitalize(answer.toLowerCase());
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return question.equals(question1.question) && answer.equals(question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Вопрос: " +
                question +
                ", ответ: " + answer;
    }
}
