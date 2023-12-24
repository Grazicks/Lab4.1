package com.example.lab41;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private String apiVersion = "API Level" + String.valueOf(Build.VERSION.SDK_INT);
    private CheatModelView cheatModelView;
    Button showAnswerButton;
    TextView showAPIversion;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        cheatModelView = new ViewModelProvider(this).get(CheatModelView.class);
        int cheat_count = getIntent().getIntExtra("cheat_count", 0);
        cheatModelView.cheat_count = cheat_count;
        int arr_index = getIntent().getIntExtra("arr_index", 0);
        cheatModelView.arr_index = arr_index;
        TextView trueAnswer = findViewById(R.id.TrueAnswer);
        trueAnswer.setGravity(Gravity.CENTER_HORIZONTAL);
        trueAnswer.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        showAPIversion = findViewById(R.id.ApiVersion);
        showAPIversion.setText(apiVersion);
        TextView cheatCount = findViewById(R.id.CheatCount);
        if (cheatModelView.cheat_count < 4){
            cheatCount.setText("Кол-во подсказок " + (4 - cheatModelView.cheat_count));
        }
        if (cheatModelView.cheat_count >= 4) {
            View showAnswerButton = findViewById(R.id.ShowAnswerButton);
            showAnswerButton.setEnabled(false);
            trueAnswer.setText("Подсказок закончились");
            cheatCount.setText("Кол-во подсказок " + (0));
        }
        else {
            trueAnswer.setText("Вы хотите узнать правильный ответ?");
        }
        showAnswerButton = findViewById(R.id.ShowAnswerButton);
        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cheatModelView.arr_index == 0) {
                    trueAnswer.setText("False");
                    cheatCount.setText("Кол-во подсказок " + (3 - cheatModelView.cheat_count));
                }
                else if (cheatModelView.arr_index == 1) {
                    trueAnswer.setText("True");
                    cheatCount.setText("Кол-во подсказок " + (3 - cheatModelView.cheat_count));
                }
                View showAnswerButton = findViewById(R.id.ShowAnswerButton);
                showAnswerButton.setEnabled(false);
                Intent intent = new Intent(CheatActivity.this, MainActivity.class);
                intent.putExtra("cheat_count", cheatModelView.cheat_count);
            }
        });
    }
}