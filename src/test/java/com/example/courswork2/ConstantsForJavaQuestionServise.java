package com.example.courswork2;


import java.util.HashSet;
import java.util.Set;

public class ConstantsForJavaQuestionServise {
    public static final String EMPTY_STRING = "";
    public static final String STRING_IS_BLANK = "    ";
    public static final String QUESTION_1 = "Где хранятся примитивы?";
    public static final String ANSWER_1 = "в стэке";
    public static final String QUESTION_2 = "Где хранится ссылочный тип данных?";
    public static final String ANSWER_2 = "в куче";
    public static final String QUESTION_3 = "вопрос по математике";
    public static final String ANSWER_3 = "ответ по математике";


    public static final Question FIRST_QUESTION = new Question(QUESTION_1, ANSWER_1);
    public static final Question SECOND_QUESTION = new Question(QUESTION_2, ANSWER_2);
    public static final Question MATH_QUESTION = new Question(QUESTION_3, ANSWER_3);


    public static final Set<Question> QUESTION_SET = new HashSet<Question>(
            Set.of(FIRST_QUESTION, SECOND_QUESTION)
    );
    public static final Set<Question> QUESTION_SET_CONTAINS_ONE_ELEMENT = new HashSet<Question>(
            Set.of(FIRST_QUESTION)
    );
    public static final Set<Question> MATH_QUESTION_SET = new HashSet<Question>(
            Set.of(MATH_QUESTION)
    );
    public static final Set<Question> GENERAL_QUESTION_SET = new HashSet<Question>(
            Set.of(FIRST_QUESTION, SECOND_QUESTION, MATH_QUESTION)
    );


}
