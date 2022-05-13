package com.example.courswork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.courswork2.ConstantsForJavaQuestionServise.*;
import static org.junit.jupiter.api.Assertions.*;


public class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    public void fillQustionsSet() {
        out.getQuestions().add(FIRST_QUESTION);
    }

    @Test
    public void shouldReturnAddedQuestion() {
        assertEquals(SECOND_QUESTION, out.add(QUESTION_2, ANSWER_2));
        assertTrue(2==out.getQuestions().size());
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenQuestionAlreadyExists() {
        assertThrows(IllegalArgumentException.class,()->out.add(QUESTION_1,ANSWER_1));
    }
    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenIncorrectInput() {
        assertThrows(IllegalArgumentException.class, ()->out.add(EMPTY_STRING,STRING_IS_BLANK));
    }

    @Test
    public void shouldReturnRemovedQuestion() {
        assertEquals(FIRST_QUESTION,out.remove(QUESTION_1,ANSWER_1));
        assertTrue(0==out.getQuestions().size());
    }
    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenQuestionDoesNotExists() {
        assertThrows(IllegalArgumentException.class,()->out.remove(QUESTION_2,ANSWER_2));
    }

    @Test
    public void shouldReturnCollectionOfQuestions() {
        out.add(QUESTION_2,ANSWER_2);
        assertEquals(QUESTION_SET,out.getAll());
    }

    @Test
    public void shouldReturnRandomQuestion() {
        assertEquals(FIRST_QUESTION,out.getRandomQuestion());
    }//Идеа не дала замокать класс Random, этот тест проходит успешно, т.к. в сете questions только один
    // элемент... Как нужно было поступить?

}
