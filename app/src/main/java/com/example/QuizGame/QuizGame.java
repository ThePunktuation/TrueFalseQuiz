package com.example.QuizGame;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizGame extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private TextView ShowScore, mQuestion;
    private Button btnTruth;
    private Button btnFalsehood;
    private boolean aAnswer;
    private int aScore = 0;
    private int aQuestionNum = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ShowScore = (TextView)findViewById(R.id.showScore);
        mQuestion = (TextView)findViewById((R.id.question));
        btnTruth = (Button)findViewById(R.id.btnTrue);
        btnFalsehood = (Button)findViewById(R.id.btnFalse);

        uQuestion();

        btnTruth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aAnswer == true) {
                    aScore++;
                    uScore(aScore);

                    if (aQuestionNum == QuestionBank.Quizquestions.length) {
                        Intent i = new Intent(QuizGame.this, QuizResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalGrade", aScore);
                        i.putExtras(bundle);
                        QuizGame.this.finish();
                        startActivity(i);
                    } else {
                        uQuestion();
                    }
                }
                else {
                    if (aQuestionNum == QuestionBank.Quizquestions.length) {
                        Intent i = new Intent(QuizGame.this, QuizResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalGrade", aScore);
                        i.putExtras(bundle);
                        QuizGame.this.finish();
                        startActivity(i);
                    } else {
                        uQuestion();
                    }
                }
            }

        });
        btnFalsehood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aAnswer == false) {
                    aScore++;
                    uScore(aScore);

                    if (aQuestionNum == QuestionBank.Quizquestions.length) {
                        Intent i = new Intent(QuizGame.this, QuizResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalGrade", aScore);
                        i.putExtras(bundle);
                        QuizGame.this.finish();
                        startActivity(i);
                    } else {
                        uQuestion();
                    }
                }
                else {
                    if (aQuestionNum == QuestionBank.Quizquestions.length) {
                        Intent i = new Intent(QuizGame.this, QuizResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalGrade", aScore);
                        i.putExtras(bundle);
                        QuizGame.this.finish();
                        startActivity(i);
                    } else {
                        uQuestion();
                    }
                }
            }

        });


    }



    private void uQuestion(){
        mQuestion.setText(QuestionBank.Quizquestions[aQuestionNum]);
        aAnswer = QuestionBank.answers[aQuestionNum];
        aQuestionNum++;
    }


    @SuppressLint("SetTextI18n")
    public void uScore(int point){
        ShowScore.setText("" + aScore);
    }







    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()) {
            case R.id.mnuMain:
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                return true;
            case R.id.mnuExit:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }


}