package com.example.lab41;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int quest_count = 0;
    int quest_limit = 5;
    int tr_ans = 0;
    private static int array_ind, quest_ind;
    Button trueButton, falseButton, nextButton, beforeButton;
    String quest_value = getQuestion_value(array_ind, quest_ind);
    String question_key = "QUESTION_VALUE_SERIALIZABLE_KEY";

    public static String getQuestion_value(int arr_index, int q_index) {
        String quest_value;
        Random rand = new Random();
        int min = 0; // Min value
        int max = 1; // Max value
        array_ind = rand.nextInt(20);
        quest_ind = 0;
        quest_value = QuestionDataBase.GetQuestion(array_ind, quest_ind);
        return quest_value;
    }
    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_main);
        TextView question = findViewById(R.id.Question);
        question.setGravity(Gravity.CENTER);
        trueButton = findViewById(R.id.TrueButton);
        falseButton = findViewById(R.id.FalseButton);
        nextButton = findViewById(R.id.Next);

        View nextButton = findViewById(R.id.Next);
        nextButton.setEnabled(false);
        question.setText(quest_value);
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
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View trueButton = findViewById(R.id.TrueButton);
                trueButton.setEnabled(true);
                View falseButton = findViewById(R.id.FalseButton);
                falseButton.setEnabled(true);
                quest_count++;
                if (quest_count == quest_limit) {
                    String answers_count = "Правильных ответов: " + tr_ans;
                    Toast.makeText(MainActivity.this, answers_count, Toast.LENGTH_LONG).show();
                    view.setEnabled(false);
                    trueButton.setEnabled(false);
                    falseButton.setEnabled(false);
                }
                else {
                    Random rand = new Random();
                    array_ind = rand.nextInt(20);
                    quest_ind += 1;
                    quest_value = QuestionDataBase.GetQuestion(array_ind, quest_ind);
                    question.setText(quest_value);
                    view.setEnabled(false);
                }
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("question_value", quest_value);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        quest_value = savedInstanceState.getString("question_value");
        TextView question = findViewById(R.id.Question);
        question.setGravity(Gravity.CENTER);
        question.setText(quest_value);
    }
}