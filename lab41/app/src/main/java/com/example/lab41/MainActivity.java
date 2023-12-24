package com.example.lab41;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public Button trueButton, falseButton, nextButton, cheatButton;
    private QuizModelView quizModelView;

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);
        TextView question = findViewById(R.id.Question);
        question.setGravity(Gravity.CENTER);
        question.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        trueButton = findViewById(R.id.TrueButton);
        falseButton = findViewById(R.id.FalseButton);
        nextButton = findViewById(R.id.Next);
        cheatButton = findViewById(R.id.Cheatbutton);
        quizModelView = new ViewModelProvider(this).get(QuizModelView.class);
        View nextButton = findViewById(R.id.Next);
        int cheat_count = getIntent().getIntExtra("cheat_count", 0);
        quizModelView.cheat_count = cheat_count;
        question.setText(quizModelView.quest_value);
        nextButton.setEnabled(false);

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizModelView.cheat_count+=1;
                Intent intent = new Intent(MainActivity.this, CheatActivity.class);
                intent.putExtra("arr_index", quizModelView.array_ind);
                intent.putExtra("cheat_count", quizModelView.cheat_count);
                startActivity(intent);
            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ((Button)view).getText().toString(), Toast.LENGTH_SHORT).show();
                View trueButton = findViewById(R.id.TrueButton);
                trueButton.setEnabled(false);
                View falseButton = findViewById(R.id.FalseButton);
                falseButton.setEnabled(false);
                View nextButton = findViewById(R.id.Next);
                nextButton.setEnabled(true);
                if (quizModelView.array_ind < 10) {
                    quizModelView.tr_ans++;
                }
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ((Button)view).getText().toString(), Toast.LENGTH_SHORT).show();
                View trueButton = findViewById(R.id.TrueButton);
                trueButton.setEnabled(false);
                View falseButton = findViewById(R.id.FalseButton);
                falseButton.setEnabled(false);
                View nextButton = findViewById(R.id.Next);
                nextButton.setEnabled(true);
                if (quizModelView.array_ind >= 10) {
                    quizModelView.tr_ans++;
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ((Button)view).getText().toString(), Toast.LENGTH_SHORT).show();
                View trueButton = findViewById(R.id.TrueButton);
                trueButton.setEnabled(true);
                View falseButton = findViewById(R.id.FalseButton);
                falseButton.setEnabled(true);
                quizModelView.quest_count++;
                if (quizModelView.quest_count == quizModelView.quest_limit) {
                    String answers_count = "Правильных ответов: " + quizModelView.tr_ans;
                    Toast.makeText(MainActivity.this, answers_count, Toast.LENGTH_LONG).show();
                    view.setEnabled(false);
                    trueButton.setEnabled(false);
                    falseButton.setEnabled(false);
                }
                else {
                    quizModelView.quest_value = quizModelView.getQuestion_value();
                    question.setText(quizModelView.quest_value);
                    view.setEnabled(false);
                }
            }
        });
    }
    public void ggkire(View view) {
        quizModelView.quest_count++;
    }
}