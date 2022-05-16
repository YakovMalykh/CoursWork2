package com.example.courswork2;

import com.example.courswork2.exceptions.QuestionBadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.courswork2.ConstantsForJavaQuestionServise.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionServiceMock;
    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void shouldReturnCollectionOfQuestions() {
        when(questionServiceMock.getAll()).thenReturn(QUESTION_SET_CONTAINS_ONE_ELEMENT);
        when(questionServiceMock.getRandomQuestion()).thenReturn(FIRST_QUESTION);
        assertEquals(QUESTION_SET_CONTAINS_ONE_ELEMENT, out.getQuestions(1));
    }

    @Test
    public void shooldTHrowsQuestionBadRequestExceptionWhenAmountMoreThenSize() {
        assertThrows(QuestionBadRequestException.class,()->out.getQuestions(2));
    }
}
