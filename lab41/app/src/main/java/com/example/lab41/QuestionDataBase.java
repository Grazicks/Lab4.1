package com.example.lab41;

public class QuestionDataBase {

    public static String GetQuestion(int ArrayIndex, int QuestionIndex) {
        String[] TrueQuestions = new String[]{
                "Тихий океан - самая большой океан в мире",
                "Эверест - самая большая гора в мире",
                "Россия имеет выход ко всем океанам",
                "Россия граничит с 18-тью странами",
                "Токио - столица Японии",
        };
        String[] FalseQuestions = new String[]{
                "Столица США - Нью йорк",
                "Китай - самая большая по населению страна",
                "Останкинская телебашня - самая высокая башня в мире",
                "Нил - самая длинная река в мире",
                "Река Темза протекает по территории России",
        };
        if (ArrayIndex >= 10) {
            return FalseQuestions[QuestionIndex];
        }
        if (ArrayIndex < 10) {
            return TrueQuestions[QuestionIndex];
        }
        else return "";
    }
}
