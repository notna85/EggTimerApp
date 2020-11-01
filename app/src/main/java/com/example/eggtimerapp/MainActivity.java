package com.example.eggtimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button timerButton, eggButtonSoft, eggButtonMedium, eggButtonHard;
    TextView timerDisplay;
    TimerManager timerManager = new TimerManager();
    private String timerStart, timerStop, timerDefault, timerFinish;
    private boolean isTimerStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerButton = findViewById(R.id.btn_Timer);
        eggButtonSoft = findViewById(R.id.btn_Soft);
        eggButtonMedium = findViewById(R.id.btn_Medium);
        eggButtonHard = findViewById(R.id.btn_Hard);
        timerDisplay = findViewById(R.id.txt_Time);
        timerStart = getString(R.string.timer_start);
        timerStop = getString(R.string.timer_stop);
        timerFinish = getString(R.string.timer_finish);
        timerDefault = getString(R.string.timer_default);
        isTimerStarted = false;
    }

    public void onButtonEggClicked(View v)
    {
        timerDisplay.setText(timerManager.setTimer(v));
        timerButton.setEnabled(true);
    }

    public void onButtonTimerClicked(View v)
    {
        if(isTimerStarted == false)
            startCountdown();
        else
            stopCountdown();
    }

    private void startCountdown()
    {
        isTimerStarted = true;
        enableEggButtons(false);
        timerButton.setText(timerStop);
        timerManager.startTimer(timerDisplay, timerButton, timerFinish);
    }

    private void stopCountdown()
    {
        timerManager.stopTimer();
        setTimerToDefault();
    }

    private void setTimerToDefault()
    {
        timerButton.setEnabled(false);
        isTimerStarted = false;
        enableEggButtons(true);
        timerButton.setText(timerStart);
        timerDisplay.setText(timerDefault);
    }

    private void enableEggButtons(boolean isEnabled)
    {
        eggButtonSoft.setEnabled(isEnabled);
        eggButtonMedium.setEnabled(isEnabled);
        eggButtonHard.setEnabled(isEnabled);
    }
}