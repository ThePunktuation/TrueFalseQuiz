package com.example.QuizGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResultsActivity extends AppCompatActivity {
    TextView aGrade, aFinal;
    Button aReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        aReturn = (Button)findViewById(R.id.retry);
        aGrade = (TextView)findViewById(R.id.grade);
        aFinal = (TextView)findViewById(R.id.outOf);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalGrade");

        aFinal.setText("You got " + score + " outta " + QuestionBank.Quizquestions.length);
        if (score == 15){
            aGrade.setText("Perfect!");
        }
        else if (score == 14){
            aGrade.setText("Godly!");
        }
        else if (score == 13){
            aGrade.setText("Metroid!");
        }
        else if (score == 12){
            aGrade.setText("Killer!");
        }
        else if (score == 11){
            aGrade.setText("Good Job!");
        }
        else if (score == 10){
            aGrade.setText("Good Job!");
        }
        else if (score == 9){
            aGrade.setText("Good Job!");
        }
        else if (score == 8){
            aGrade.setText("You Tried!");
        }
        else if (score == 7){
            aGrade.setText("You Tried!");
        }
        else if (score == 6){
            aGrade.setText("You Tried!");
        }
        else if (score == 5){
            aGrade.setText("Give it another go!");
        }
        else if (score == 4){
            aGrade.setText("Give it another go!");
        }
        else if (score == 3){
            aGrade.setText("Give it another go!");
        }
        else if (score == 2){
            aGrade.setText("oof!");
        }
        else if (score == 1){
            aGrade.setText("oof!");
        }
        else if (score == 0){
            aGrade.setText("Try, Try, Try Again!");
        }

        aReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResultsActivity.this, QuizGame.class));
                QuizResultsActivity.this.finish();
            }
                                   });





























        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           goBack();
                                       }
                                   }

        );
    }
    private void goBack() {
        Intent intent = new Intent(QuizResultsActivity.this, MainMenu.class);
        this.startActivity(intent);
    }
}