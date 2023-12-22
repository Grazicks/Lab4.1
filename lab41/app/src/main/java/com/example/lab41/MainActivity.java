package com.example.lab41;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int quest_count = 0;
    int quest_limit = 5;
    int tr_ans = 0;
    private static int array_ind, quest_ind;
    Button trueButton, falseButton, nextButton;
    String quest_value = getQuestion_value(array_ind, quest_ind);
    String question_key = "QUESTION_VALUE_SERIALIZABLE_KEY";

    public static String getQuestion_value(int arr_index, int q_index) {
        String question_value;
        Random rand = new Random();
        int min = 0; // Min value
        int max = 1; // Max value
        array_ind = rand.nextInt(20);
        quest_ind = 0;
        question_value = QuestionDataBase.GetQuestion(array_ind, quest_ind);
        return question_value;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}