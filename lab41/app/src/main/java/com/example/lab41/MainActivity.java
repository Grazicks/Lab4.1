package com.example.lab41;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int quest_count = 0;
    int quest_limit = 5;
    int tr_ans = 0;
    private static int array_ind, quest_ind;
    Button trueButton, falseButton, nextButton;
    String quest_value = getQuestion_value(array_ind, quest_ind);
    String question_key = "QUESTION_VALUE_SERIALIZABLE_KEY";
    private int question_value;

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
        TextView question = findViewById(R.id.Question);
        question.setGravity(Gravity.CENTER);
        trueButton = findViewById(R.id.TrueButton);
        falseButton = findViewById(R.id.FalseButton);
        nextButton = findViewById(R.id.Next);

        View nextButton = findViewById(R.id.Next);
        nextButton.setEnabled(false);
        question.setText(question_value);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View trueButton = findViewById(R.id.TrueButton);
                trueButton.setEnabled(false);
                View falseButton = findViewById(R.id.FalseButton);
                falseButton.setEnabled(false);
                View nextButton = findViewById(R.id.Next);
                nextButton.setEnabled(true);
                if (array_ind < 10) {
                    tr_ans++;
                }
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View trueButton = findViewById(R.id.TrueButton);
                trueButton.setEnabled(false);
                View falseButton = findViewById(R.id.FalseButton);
                falseButton.setEnabled(false);
                View nextButton = findViewById(R.id.Next);
                nextButton.setEnabled(true);
                if (array_ind >= 10) {
                    tr_ans++;
                }
            }
        });
    }
}