package com.example.lab41;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.view.ActionMode;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuizModelView extends ViewModel {
    int quest_count;
    int quest_limit;
    int tr_ans = 0;
    int array_ind, quest_ind;
    String quest_value;
    int cheat_count;

    public QuizModelView() {
        quest_value = getQuestion_value();
        tr_ans = 0;
        quest_limit = 5;
        quest_count = 0;
    }

    public String getQuestion_value() {
        String quest_value;
        array_ind = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        quest_ind = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        quest_value = QuestionDataBase.GetQuestion(array_ind, quest_ind);

        return quest_value;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
