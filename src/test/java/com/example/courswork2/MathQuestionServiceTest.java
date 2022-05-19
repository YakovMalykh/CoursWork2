package com.example.courswork2;

import com.example.courswork2.interfaces.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.courswork2.ConstantsForJavaQuestionServise.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @Mock
    QuestionRepository questionRepositoryMock;

    @InjectMocks
    MathQuestionService out;

    @BeforeEach
    public void fillQustionsSet() {
        out.add(QUESTION_1, ANSWER_1);
    }

    @Test
    public void shouldReturnAddedQuestion() {
        when(questionRepositoryMock.add(anyString(), anyString())).thenReturn(SECOND_QUESTION);
        assertEquals(SECOND_QUESTION, out.add(QUESTION_2, ANSWER_2));
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenQuestionAlreadyExists() {
        when(questionRepositoryMock.add(anyString(), anyString())).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> out.add(QUESTION_1, ANSWER_1));
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenIncorrectInput() {
        when(questionRepositoryMock.add(anyString(), anyString())).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> out.add(EMPTY_STRING, STRING_IS_BLANK));
    }

    @Test
    public void shouldReturnRemovedQuestion() {
        when(questionRepositoryMock.remove(anyString(), anyString())).thenReturn(FIRST_QUESTION);
        assertEquals(FIRST_QUESTION, out.remove(QUESTION_1, ANSWER_1));
        assertTrue(0 == out.getAll().size());
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenQuestionDoesNotExists() {
        when(questionRepositoryMock.remove(anyString(), anyString())).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> out.remove(QUESTION_2, ANSWER_2));
    }

    @Test
    public void shouldReturnCollectionOfQuestions() {
        when(questionRepositoryMock.getAll()).thenReturn(QUESTION_SET);
        assertEquals(QUESTION_SET, out.getAll());
    }

    @Test
    public void shouldReturnRandomQuestion() {
        when(questionRepositoryMock.getAll()).thenReturn(QUESTION_SET);
        assertTrue(QUESTION_SET.contains(out.getRandomQuestion()));
    }

}
