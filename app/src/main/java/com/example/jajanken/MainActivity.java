package com.example.jajanken;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock, b_paper, b_scissors;
    TextView tv_score;
    ImageView iv_YourScore, iv_OpponentScore, iv_OpponentChoice;

    int YourScore, OpponentScore = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        iv_YourScore = (ImageView) findViewById(R.id.iv_YourChoice);
        iv_OpponentScore = (ImageView) findViewById(R.id.iv_OpponentChoice);

        tv_score = (TextView) findViewById(R.id.tv_score);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_YourScore.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: You: " + Integer.toString(YourScore) + "opponent: " + Integer.toString(OpponentScore));
            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_YourScore.setImageResource(R.drawable.paper);
               String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: You: " + Integer.toString(YourScore) + "opponent: " + Integer.toString(OpponentScore));

            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_YourScore.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: You: " + Integer.toString(YourScore) + "opponent: " + Integer.toString(OpponentScore));


            }
        });

    }
    public String play_turn(String your_choice){
        String Opponent_Choice = "";
        Random r = new Random();
        int Opponent_choice_number = r.nextInt(3) + 1;

        if (Opponent_choice_number == 1) {
            Opponent_Choice = "rock";
        }else

        if (Opponent_choice_number == 2) {
            Opponent_Choice = "paper";
        }else

        if (Opponent_choice_number == 3) {
            Opponent_Choice = "scissors";
        }
        // ImageView iv_OpponentChoice;
        if (Opponent_Choice == "rock") {
            iv_OpponentChoice.setImageResource(R.drawable.rock);
        }
        else
        if (Opponent_Choice == "paper") {
            iv_OpponentChoice.setImageResource(R.drawable.paper);
            }
        else
        if (Opponent_Choice == "scissors") {
            iv_OpponentChoice.setImageResource(R.drawable.scissors);
                }
        if (Opponent_Choice == your_choice){
            return "Draw";
        }
        else if (your_choice == "rock" && Opponent_Choice == "scissors") {
            YourScore++;
            return "Rock crushes scissors. You Win!";}
        else if (your_choice == "rock" && Opponent_Choice == "paper") {
            OpponentScore++;
            return "Paper covers Rock. Opponent Wins!";}
        else if (your_choice == "scissors" && Opponent_Choice == "rock") {
            OpponentScore++;
            return "Rock crushes scissors. Opponent Win!";}
        else if (your_choice == "scissors" && Opponent_Choice == "paper") {
            YourScore++;
            return "Scissors cuts paper. You Win!";}
        else if (your_choice == "paper" && Opponent_Choice == "rock") {
            YourScore++;
            return "Paper covers Rock. You Win!";}
        else if (your_choice == "paper" && Opponent_Choice == "scissors") {
            OpponentScore++;
            return "scissors cuts Paper. Opponent Win!";
        }
        else return "end";
    }
}