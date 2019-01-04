package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;


import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller
{
    public Label Score;
    public Label txt;
    public Label time;
    private int score = 0;
    private boolean counting = false;
    private boolean done = false;

    public void pressButton(ActionEvent event)
    {
        if(!counting && !done)
        {
            long step = System.nanoTime() + 10000000000L;
            viewTime();
            new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if(now > step)
                    {
                        Score.setText("You ended with " + score);
                        counting = false;
                        done = true;
                        time.setText("Time Left: 0");
                    }
                    if (now < step) {
                        long time2 = now - step;
                        time.setText("Time Left: " + -time2);
                    }
                }
            }.start();
            counting = true;
        }
        if(counting) {
            score++;
            Score.setText("Score: " + String.valueOf(score));
        }
    }

    public void viewTime()
    {

    }
}
