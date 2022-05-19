package com.example.courswork2;

import com.example.courswork2.exceptions.QuestionBadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.courswork2.ConstantsForJavaQuestionServise.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionServiceMock;
    @Mock
    MathQuestionService mathQuestionServiceMock;

    @InjectMocks
    ExaminerServiceImpl out;

    @BeforeEach
    public void fillQuestionSet() {
        out = new ExaminerServiceImpl(
                javaQuestionServiceMock,
                mathQuestionServiceMock
        );
    }

    @Test
    public void shouldReturnCollectionOfQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(QUESTION_SET);
        when(mathQuestionServiceMock.getAll()).thenReturn(MATH_QUESTION_SET);
        assertTrue(GENERAL_QUESTION_SET.containsAll(out.getQuestions(2)));
    }

    @Test
    public void shooldTHrowsQuestionBadRequestExceptionWhenAmountMoreThenSize() {
        assertThrows(QuestionBadRequestException.class, () -> out.getQuestions(5));
    }
}
