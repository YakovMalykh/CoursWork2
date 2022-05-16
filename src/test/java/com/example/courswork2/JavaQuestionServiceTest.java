package com.example.courswork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static com.example.courswork2.ConstantsForJavaQuestionServise.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class JavaQuestionServiceTest {



    JavaQuestionService out = new JavaQuestionService();

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
        assertTrue(QUESTION_SET.contains(out.getRandomQuestion()));
    }//т.к.  с "замокать" класс Random возникли сложности, нашел вот такое решение, это позволит,
    // не мокая Random, протестировать метод getRandomQuestion, т.е. я проверяю содержится ли возвращаемый
    // вопрос методом getRandomQuestion в сете. Т.е. если сейчас я out заполню несколкими вопросам
    // тест будет проходить

}
