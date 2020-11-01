package com.example.eggtimerapp;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.ItemTouchUIUtil;

public class TimerManager {

    private long time, minutes, seconds;
    private CountDownTimer countDownTimer;

    public String setTimer(View v)
    {
        String timerDisplay;
        switch(v.getId())
        {
            case R.id.btn_Soft:
                time = 5 * 60 * 1000; //time in milliseconds
                timerDisplay = "05:00";
                break;
            case R.id.btn_Medium:
                time = 7 * 60 * 1000; //time in milliseconds
                timerDisplay = "07:00";
                break;
            case R.id.btn_Hard:
                time = 10 * 60 * 1000; //time in milliseconds
                timerDisplay = "10:00";
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
        return timerDisplay;
    }

    public void startTimer(TextView timerDisplay, Button timerButton, String buttonText)
    {
        countDownTimer = new CountDownTimer(time, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                long remainingSeconds = millisUntilFinished / 1000;
                minutes = remainingSeconds / 60;
                seconds = remainingSeconds % 60;

                timerDisplay.setText(String.format("%02d:%02d", minutes, seconds));
            }
            @Override
            public void onFinish() {
                timerButton.setText(buttonText);
            }
        };
        countDownTimer.start();
    }
    
    public void stopTimer()
    {
        countDownTimer.cancel();
    }
}
